package com.personal.helper.services;

import com.personal.helper.models.Wallet;

/**
 * Created by hnastevska on 3/5/2017.
 */
public interface WalletService {
    void createOrUpdateWollet(Wallet wallet);

    Wallet findWollet(Long walletId);
}
