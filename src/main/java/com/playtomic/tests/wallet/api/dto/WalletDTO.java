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

    @NotNull(message = "Please enter a valid wallet id")
    private Integer id;

    private BigDecimal balance;

    @JsonProperty("top_up_amount")
    @NotNull(message = "Please enter the amount you wish to credit into your wallet")
    private BigDecimal topUpAmount;

    @JsonProperty("credit_card")
    @Size(min = 14, max = 16, message ="Invalid credit card number")
    @NotBlank(message = "Please enter your credit card number")
    private String creditCardNumber;

}
