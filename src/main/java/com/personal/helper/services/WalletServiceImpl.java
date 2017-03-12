package com.personal.helper.services;

import com.personal.helper.models.Wallet;
import com.personal.helper.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hnastevska on 3/5/2017.
 */
@Service
public class WalletServiceImpl implements WalletService {

    WalletRepository wolletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository wolletRepository) {
        this.wolletRepository = wolletRepository;
    }

    public void createOrUpdateWollet(Wallet wallet) {
        wolletRepository.save(wallet);
    }

    @Override
    public List<Wallet> findWollet() {
        return wolletRepository.findAll();
    }

    public Wallet findWollet(Long walletId) {
        return wolletRepository.findOne(walletId);
    }

}
