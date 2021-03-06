package com.personal.helper.money.savings;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Savings {
    @Id
    @GeneratedValue
   private Long id;
   private Double amount;
   private int month;
   private boolean isGiven;
   private long account_id;
}
