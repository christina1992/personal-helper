package com.personal.helper.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hnastevska on 8/16/2017.
 */
@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    @RequestMapping(value = "/wallets", method = RequestMethod.GET)
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    @RequestMapping(value = "/wallets/{id}", method = RequestMethod.GET)
    public Wallet getWallet(@PathVariable String id) {
        return walletService.getWallet(id);
    }

    @RequestMapping(value = "/wallets", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addWallet(@RequestBody Wallet wallet) {
        walletService.addWallet(wallet);
    }
    @RequestMapping(value = "/wallets/{id}", method = RequestMethod.PUT)
    public void updateWallet(@RequestBody Wallet wallet, @PathVariable String id) {
        walletService.updateWallet(id, wallet);
    }
    @RequestMapping(value = "/wallets/{id}", method = RequestMethod.DELETE)
    public void deleteWallet(@PathVariable String id) {
        walletService.deleteWallet(id);
    }
}
