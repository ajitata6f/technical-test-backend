package com.playtomic.tests.wallet.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO {

    private Integer id;
    private BigDecimal balance;

}
