package com.personal.helper.cards;


import com.personal.helper.wallet.Wallet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by hnastevska on 8/16/2017.
 */
@Entity
public class Card {
    @Id
    private String id;
    private String name;
    private String description;
    @ManyToOne
    private Wallet wallet;


    public Card(String id, String name, String description, Wallet wallet) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.wallet = wallet;
    }

    public Card() {

    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
