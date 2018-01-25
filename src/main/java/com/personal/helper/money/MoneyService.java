package com.personal.helper.money;

import com.personal.helper.money.creditCard.CreditCard;
import com.personal.helper.money.creditCard.CreditCardRepo;
import com.personal.helper.money.savings.Savings;
import com.personal.helper.money.savings.SavingsRepo;
import com.personal.helper.money.spending.Spending;
import com.personal.helper.money.spending.SpendingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hnastevska on 10/2/2017.
 */
@Service
public class MoneyService {


    @Autowired
    MoneyRepo moneyRepo;
    @Autowired
    SpendingRepo spendingRepo;
    @Autowired
    SavingsRepo savingsRepo;
    @Autowired
    CreditCardRepo creditCardRepo;

    public void addSalary(Double salary, Long id) {
        Money money = moneyRepo.findOne(id);
        Double soFar = money.getSalary();
        money.setSalary(salary + soFar);
        moneyRepo.save(money);
    }

    public void addDailySpending(Double amount, String reason, Long id) {
        Money money = moneyRepo.findOne(id);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        Double soFar = money.getDailySpending();
        money.setDailySpending(soFar + amount);
        Spending spending = new Spending();
        spending.setAmount(amount);
        spending.setReason(reason);
        spending.setMonth(month);
        spendingRepo.save(spending);
    }

    public void addSavings(Double amount, Long id) {
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        Savings sav = new Savings();
        sav.setAmount(amount);
        sav.setMonth(month);
        sav.setGiven(false);
        sav.setAccount_id(id);
        Money money = moneyRepo.findOne(id);
        Double soFar = money.getSavings();
        money.setSavings(soFar + amount);
        //money.setSalary(money.getSalary() - amount);
        moneyRepo.save(money);
        savingsRepo.save(sav);
    }

    public List<Money> findAll() {
        return moneyRepo.findAll();
    }

    public List<Spending> getAllSpending() {
        List<Spending> list = spendingRepo.findAllByOrderByIdDesc();
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        return list.stream().filter(x -> x.getMonth() == month).collect(Collectors.toList());
    }
    public List<Spending> getAllSpendingByMonth(int m) {
        List<Spending> list = spendingRepo.findAllByOrderByIdDesc();
        return list.stream().filter(x -> x.getMonth() == m).collect(Collectors.toList());
    }
    public double getSalary(Long id) {
        Money money = moneyRepo.findOne(id);
        return money.getSalary();
    }

    public double getDebt(long account_id) {
        return moneyRepo.findOne(account_id).getDebt();
    }

    public double getSavings(long account_id) {
        return moneyRepo.getOne(account_id).getSavings();

    }

    public List<Savings> getSavingsList() {
        return savingsRepo.findAll();
    }

    public List<CreditCard> getDebtList() {
        return creditCardRepo.findAll();
    }

    public void addDailySpendingMonth(double amount, String reason, int m, long id) {
        Money money = moneyRepo.findOne(id);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        if (m > 0) {
            month = m;
        }
        Double soFar = money.getDailySpending();
        money.setDailySpending(soFar + amount);
        Spending spending = new Spending();
        spending.setAmount(amount);
        spending.setReason(reason);
        spending.setMonth(month);
        spendingRepo.save(spending);
    }

    public List<Spending> addDailySpendingByMonth(int month) {
        List<Spending> list = spendingRepo.findAllByOrderByIdDesc();

        return list.stream().filter(x -> x.getMonth() == month).collect(Collectors.toList());
    }

    public void deleteSpendingById(Long id) {
        spendingRepo.delete(id);
    }
}
