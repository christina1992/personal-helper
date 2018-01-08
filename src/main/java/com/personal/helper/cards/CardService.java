package com.personal.helper.cards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hnastevska on 8/16/2017.
 */
@Service //Services in Spring are singleton
public class CardService {

    @Autowired
    CardRepository cardRepository;


    public List<Card> getAllCards(String walletId) {
        List<Card> cards = new ArrayList<>();
        cardRepository.findByWalletId(walletId).forEach(cards::add);
        return cards;
    }

    public Card getCard(String id) {
        return cardRepository.findOne(id);
    }

    public void addCard(Card card) {
        cardRepository.save(card);
    }

    public void updateCard(Card card) {
        cardRepository.save(card);
    }

    public void deleteCard(String cardId, String walletId) {

        cardRepository.delete(cardId);
    }

}
