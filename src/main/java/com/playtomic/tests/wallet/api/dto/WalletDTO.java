package com.playtomic.tests.wallet.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO {

    @NotNull(message = "{required.field}")
    private Integer id;

    private BigDecimal balance;

    @JsonProperty("top_up_amount")
    @NotNull(message = "{required.field}")
    private BigDecimal topUpAmount;

    @JsonProperty("credit_card")
    @Size(min = 14, max = 16, message ="Credit card number '${validatedValue}' must be at least {min} characters long. Length found : ${validatedValue.length()}")
    @NotNull(message = "{required.field}")
    private String creditCardNumber;

}
