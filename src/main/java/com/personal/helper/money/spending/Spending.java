package com.personal.helper.money.spending;

import com.sun.istack.internal.Nullable;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data

public class Spending {
    @Id
    @GeneratedValue
    private Long id;
    private Double amount;
    private String reason;
    private  int month;
}
