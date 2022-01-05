package com.playtomic.tests.wallet.api.service;

import com.playtomic.tests.wallet.api.dto.WalletDTO;

import java.util.concurrent.CompletableFuture;

public interface WalletService {

    WalletDTO getWallet(int id);

    CompletableFuture<WalletDTO> topUpWallet(WalletDTO walletDTO);

}
