package com.personal.helper.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by hnastevska on 3/5/2017.
 */
@Data
@Entity
@Table(name = "credit_cards")
public class Card implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String bank;
    private double currentBalance;
    private double debt;
    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = true)
    private Wallet cardWallet;
}
