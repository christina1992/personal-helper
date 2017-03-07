package com.personal.helper.repositories;

import com.personal.helper.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hnastevska on 3/5/2017.
 */
public interface CardRepository extends JpaRepository<Card,Long> {
}
