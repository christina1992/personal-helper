package com.personal.helper.services;

import com.personal.helper.models.Card;
import com.personal.helper.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hnastevska on 3/5/2017.
 */
@Service
public class CardServiceImpl implements CardService {
    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void saveCard(Card card) {
        cardRepository.save(card);
    }
}
