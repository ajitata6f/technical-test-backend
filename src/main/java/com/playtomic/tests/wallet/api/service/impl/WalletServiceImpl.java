package com.playtomic.tests.wallet.api.service.impl;

import com.playtomic.tests.wallet.api.dto.WalletDTO;
import com.playtomic.tests.wallet.api.service.WalletService;
import com.playtomic.tests.wallet.service.StripeService;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    private StripeService stripeService;

    public WalletServiceImpl(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @Override
    public WalletDTO getWallet(int id) {
        return null;
    }

}
