package com.playtomic.tests.wallet.api.service;

import com.playtomic.tests.wallet.api.dto.WalletDTO;

public interface WalletService {

    WalletDTO getWallet(int id);

    WalletDTO topUpWallet(WalletDTO walletDTO);

}
