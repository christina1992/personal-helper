package com.personal.helper.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hnastevska on 8/16/2017.
 */
@Service //Services in Spring are singleton
public class WalletService {

    @Autowired
    WalletRepository walletRepository;


    public List<Wallet> getAllWallets() {
        List<Wallet> wallets = new ArrayList<>();
        walletRepository.findAll().forEach(wallets::add);
        return wallets;
    }

    public Wallet getWallet(String id) {
        return walletRepository.findOne(id);
    }

    public void addWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }

    public void updateWallet(String id, Wallet wallet) {
       walletRepository.save(wallet);
    }

    public void deleteWallet(String id) {
        walletRepository.delete(id);
    }
}
