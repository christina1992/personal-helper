package com.personal.helper.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by hnastevska on 3/5/2017.
 */
@Data
@Entity
@Table(name= "wollets")
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long wallet_id;
    private String name;
    private String ownerName;
    private String description;
    private double currentBalance;
   @OneToMany(mappedBy = "cardWallet")
    private Set<Card> bankCards;

}
