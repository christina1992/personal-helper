package com.personal.helper.money;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hnastevska on 10/2/2017.
 */
@Repository
public interface MoneyRepo extends JpaRepository<Money, Long> {
}
