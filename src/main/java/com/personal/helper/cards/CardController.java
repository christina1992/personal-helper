package com.personal.helper.cards;

import com.personal.helper.wallet.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hnastevska on 8/16/2017.
 */
@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/wallets/{walletId}/cards/", method = RequestMethod.GET)
    public List<Card> getAllCards(@PathVariable String walletId) {
        return cardService.getAllCards(walletId);
    }

    @RequestMapping(value = "/wallets/{walletId}/cards/{id}", method = RequestMethod.GET)
    public Card getCard(@PathVariable String id) {
        return cardService.getCard(id);
    }

    @RequestMapping(value = "/wallets/{walletId}/cards", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCard(@RequestBody Card card, @PathVariable String walletId) {
        card.setWallet(new Wallet(walletId, "", ""));
        cardService.addCard(card);
    }

    @RequestMapping(value = "/wallets/{walletId}/cards/{id}", method = RequestMethod.PUT)
    public void updateCard(@RequestBody Card card, @PathVariable String walletId, @PathVariable String id) {
        card.setWallet(new Wallet(walletId, "", ""));
        cardService.updateCard(card);
    }

    @RequestMapping(value = "/wallets/{walletId}/cards/{cardId}", method = RequestMethod.DELETE)
    public void deleteCard(@PathVariable String walletId, @PathVariable String cardId) {
        cardService.deleteCard(cardId, walletId);
    }
}
