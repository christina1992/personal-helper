package com.personal.helper.controllers;

import com.personal.helper.models.Card;
import com.personal.helper.models.Wallet;
import com.personal.helper.services.CardService;
import com.personal.helper.services.WalletServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hnastevska on 3/5/2017.
 */
@RestController
@RequestMapping("/wallet/api")
public class WalletController {
    private static final Logger logger = LoggerFactory.getLogger(WalletController.class);
    private WalletServiceImpl walletService;
    private CardService cardService;


    @Autowired
    public WalletController(WalletServiceImpl walletService, CardService cardService) {
        this.cardService = cardService;
        this.walletService = walletService;
    }

    @RequestMapping(value = "/addNewWallet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewWallet(@RequestBody Wallet wallet) {
        walletService.createOrUpdateWollet(wallet);

    }

    @RequestMapping(value = "/addCardToWallet/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCardToWallet(@PathVariable Long id, @RequestBody Card card) {
        Wallet wallet = walletService.findWollet(id);
        if (wallet != null) {
            List<Card> cards = wallet.getCards();
            cards.add(card);
            wallet.setCards(cards);
            walletService.createOrUpdateWollet(wallet);
        }

    }

    @RequestMapping(value = "/getWallet/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Wallet getWalletById(@PathVariable("id") Long id) {
        Wallet wallet = walletService.findWollet(id);
        return wallet;
    }

    @RequestMapping(value = "/updateWallet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateWallet(@RequestBody Wallet wallet) {

        Wallet receivedWallet = walletService.findWollet(wallet.getWallet_id());
        if (receivedWallet != null) {
            receivedWallet.setName(wallet.getName());
            receivedWallet.setWallet_id(wallet.getWallet_id());
            receivedWallet.setCurrentBalance(wallet.getCurrentBalance());
            receivedWallet.setOwnerName(wallet.getOwnerName());
            receivedWallet.setDescription(wallet.getDescription());
            receivedWallet.setCards(wallet.getCards());
            walletService.createOrUpdateWollet(receivedWallet);
        }
    }
}
