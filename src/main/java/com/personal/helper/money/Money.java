package com.personal.helper.money;

import com.sun.istack.internal.Nullable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by hnastevska on 10/2/2017.
 */
@Entity
@Data
public class Money {
    @Id
    @GeneratedValue
    private Long id;
    private Double salary;
    private Double dailySpending;
    private String reasonDailySpending;
    private Double savings;
    private Double debt;
    private int month;


}
