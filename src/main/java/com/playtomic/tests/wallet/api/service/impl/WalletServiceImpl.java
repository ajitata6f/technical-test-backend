package com.playtomic.tests.wallet.api.service.impl;

import com.playtomic.tests.wallet.api.dto.WalletDTO;
import com.playtomic.tests.wallet.api.model.Wallet;
import com.playtomic.tests.wallet.api.repository.WalletRepository;
import com.playtomic.tests.wallet.api.service.WalletService;
import com.playtomic.tests.wallet.service.StripeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {

    private final ModelMapper modelMapper;
    private final StripeService stripeService;
    private final WalletRepository walletRepository;

    public WalletServiceImpl(ModelMapper modelMapper, StripeService stripeService, WalletRepository walletRepository) {
        this.modelMapper = modelMapper;
        this.stripeService = stripeService;
        this.walletRepository = walletRepository;
    }

    @Override
    public WalletDTO getWallet(int id) {
        Optional<Wallet> walletOptional = walletRepository.findById(id);

        return modelMapper.map(walletOptional.get(), WalletDTO.class);;
    }

    @Override
    public void topUpWallet(WalletDTO walletDTO) {
        stripeService.charge();
    }

}
