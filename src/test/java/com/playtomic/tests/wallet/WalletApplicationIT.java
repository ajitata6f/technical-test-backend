package com.playtomic.tests.wallet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playtomic.tests.wallet.api.dto.WalletDTO;
import com.playtomic.tests.wallet.api.service.WalletService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
public class WalletApplicationIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	WalletService walletService;

	@Test
	public void testGetWallet() throws Exception {
		MockHttpServletResponse response = mockMvc
				.perform(
					MockMvcRequestBuilders
							.get("http://localhost:8090/api/v1/wallets/1")
							.contentType(MediaType.APPLICATION_JSON_VALUE)
							.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.*", hasSize(2)))
				.andExpect(jsonPath("$.id").isNumber())
				.andExpect(jsonPath("$.balance").isNumber())
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse();
	}

	@Test
	public void testTopUpWallet() throws Exception {
		WalletDTO walletDTO = new WalletDTO();
		walletDTO.setId(1);
		walletDTO.setCreditCardNumber("5200828282828210");
		walletDTO.setTopUpAmount(new BigDecimal(10000));

		ObjectMapper objectMapper = new ObjectMapper();

		MockHttpServletResponse response = mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("http://localhost:8090/api/v1/wallets/top-up")
								.content(objectMapper.writeValueAsString(walletDTO))
								.accept(MediaType.APPLICATION_JSON_VALUE)
								.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.*", hasSize(2)))
				.andExpect(jsonPath("$.id").isNumber())
				.andExpect(jsonPath("$.balance").isNumber())
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse();
	}


	@Test
	public void emptyTest() {
	}

}
