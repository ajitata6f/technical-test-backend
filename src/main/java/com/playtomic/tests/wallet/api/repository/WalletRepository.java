package com.playtomic.tests.wallet.api.repository;

import com.playtomic.tests.wallet.api.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

}
