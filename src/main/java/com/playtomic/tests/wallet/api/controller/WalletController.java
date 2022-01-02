package com.playtomic.tests.wallet.api.controller;

import com.playtomic.tests.wallet.api.dto.WalletDTO;
import com.playtomic.tests.wallet.api.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallets")
public class WalletController {
    private final Logger log = LoggerFactory.getLogger(WalletController.class);

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping(value = "/{walletId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletDTO> getWallet(@PathVariable int walletId) {
        return ResponseEntity.status(HttpStatus.OK).body(walletService.getWallet(walletId));
    }

    @GetMapping("/")
    void log() {
        log.info("Logging from /");
    }

}
