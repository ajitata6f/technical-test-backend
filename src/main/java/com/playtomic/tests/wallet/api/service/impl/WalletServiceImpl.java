package com.playtomic.tests.wallet.api.service.impl;

import com.playtomic.tests.wallet.api.dto.WalletDTO;
import com.playtomic.tests.wallet.api.exception.WalletNotFoundException;
import com.playtomic.tests.wallet.api.model.Wallet;
import com.playtomic.tests.wallet.api.repository.WalletRepository;
import com.playtomic.tests.wallet.api.service.WalletService;
import com.playtomic.tests.wallet.service.StripeService;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

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

    @Transactional(readOnly = true)
    @Override
    public WalletDTO getWallet(int id) {
        Wallet wallet = walletRepository.findById(id).orElseThrow(() -> new WalletNotFoundException(String.format("Sorry, no wallet was found with id %s", id)));

        return modelMapper.map(wallet, WalletDTO.class);
    }

    @Async
    @Transactional
    @Override
    public CompletableFuture<WalletDTO> topUpWallet(WalletDTO walletDTO) {
        Wallet wallet = walletRepository.findById(walletDTO.getId()).orElseThrow(() -> new WalletNotFoundException(String.format("Sorry, no wallet was found with id %s", walletDTO.getId())));

        stripeService.charge(walletDTO.getCreditCardNumber(), walletDTO.getTopUpAmount());

        BigDecimal newBalance = wallet.getBalance().add(walletDTO.getTopUpAmount());
        wallet.setBalance(newBalance);

        return CompletableFuture.completedFuture(modelMapper.map(walletRepository.save(wallet), WalletDTO.class));
    }

}
