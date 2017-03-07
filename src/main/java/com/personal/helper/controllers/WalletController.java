package com.personal.helper.controllers;

import com.personal.helper.models.Card;
import com.personal.helper.models.Wallet;
import com.personal.helper.services.CardService;
import com.personal.helper.services.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by hnastevska on 3/5/2017.
 */
@RestController
@RequestMapping("/wallet/api")
public class WalletController {
    private WalletServiceImpl walletService;
    private CardService cardService;


    @Autowired
    public WalletController(WalletServiceImpl walletService, CardService cardService) {
        this.cardService = cardService;
        this.walletService = walletService;
    }

    @RequestMapping(value = "/addNewWallet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewWallet(@RequestBody Wallet wallet) {
        if (!wallet.getBankCards().isEmpty()) {
            Collection<Card> cards = wallet.getBankCards();
            cards.stream().forEach(x -> cardService.saveCard(x));
        }
        walletService.createOrUpdateWollet(wallet);
    }

    @RequestMapping(value = "/getWallet/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Wallet addNewWallet(@PathVariable("id") Long id) {
        return walletService.findWollet(id);
    }

    @RequestMapping(value = "/updateWallet", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateWallet(@RequestBody Wallet wallet) {

        Wallet receivedWallet = walletService.findWollet(wallet.getWallet_id());
        receivedWallet.setName(wallet.getName());
        receivedWallet.setWallet_id(wallet.getWallet_id());
        receivedWallet.setCurrentBalance(wallet.getCurrentBalance());
        receivedWallet.setOwnerName(wallet.getOwnerName());
        receivedWallet.setDescription(wallet.getDescription());

        Collection<Card> cards = wallet.getBankCards();
        cards.stream().forEach(x -> cardService.saveCard(x));

        walletService.createOrUpdateWollet(receivedWallet);


    }
}
