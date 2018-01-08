package com.personal.helper.cards;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hnastevska on 8/17/2017.
 */
@Repository
public interface CardRepository extends CrudRepository<Card,String> {
     List<Card> findByWalletId(String walletId);
     Card findByName(String name);
     Card findByDescription(String description);
}
