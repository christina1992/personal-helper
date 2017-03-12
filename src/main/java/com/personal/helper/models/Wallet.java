package com.personal.helper.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hnastevska on 3/5/2017.
 */

@Entity
@Table(name = "wollets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long wallet_id;
    private String name;
    private String ownerName;
    private String description;
    private double currentBalance;
    @OneToMany
    @JoinColumn(name = "wallet_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Card> cards = new ArrayList<>();

    @Override
    public String toString() {
        return "Wallet{" +
                "wallet_id=" + wallet_id +
                ", name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", description='" + description + '\'' +
                ", currentBalance=" + currentBalance +
                ", bankCard=" + cards +
                '}';
    }

    public Long getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(Long wallet_id) {
        this.wallet_id = wallet_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

}
