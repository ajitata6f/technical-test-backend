package com.playtomic.tests.wallet.api.controller;

import com.playtomic.tests.wallet.api.dto.WalletDTO;
import com.playtomic.tests.wallet.api.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/wallets")
public class WalletController {
    private final Logger log = LoggerFactory.getLogger(WalletController.class);

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletDTO> getWallet(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(walletService.getWallet(id));
    }

    @PostMapping(value = "/top-up", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletDTO> topUpWallet(@Valid @RequestBody WalletDTO walletDTO) {
        WalletDTO responseWalletDTO = walletService.topUpWallet(walletDTO);

        return new ResponseEntity<>(responseWalletDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/refund", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletDTO> refund(@Valid @RequestBody WalletDTO walletDTO) {
        WalletDTO responseWalletDTO = walletService.refund(walletDTO);

        return new ResponseEntity<>(responseWalletDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    void log() {
        log.info("Logging from /");
    }

}
