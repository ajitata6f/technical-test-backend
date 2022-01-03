package com.playtomic.tests.wallet.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO {

    @NotNull(message = "Id may not be null")
    private Integer id;

    private BigDecimal balance;

    @JsonProperty("top_up_amount")
    @NotNull(message = "Top up amount may not be null")
    private BigDecimal topUpAmount;

    @JsonProperty("credit_card")
    @Size(min = 14, max = 16, message ="Invalid credit card number must ")
    @NotBlank(message = "credit card number may not be blank")
    private String creditCardNumber;

}
