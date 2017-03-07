package com.personal.helper.repositories;

import com.personal.helper.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hnastevska on 3/5/2017.
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
