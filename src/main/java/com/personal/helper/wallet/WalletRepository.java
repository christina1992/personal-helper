package com.personal.helper.wallet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hnastevska on 8/17/2017.
 */
@Repository
public interface WalletRepository extends CrudRepository<Wallet,String> {
}
