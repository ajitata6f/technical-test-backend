package com.playtomic.tests.wallet.api.repository;

import com.playtomic.tests.wallet.api.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

}
