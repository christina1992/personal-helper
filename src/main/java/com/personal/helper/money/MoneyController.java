package com.personal.helper.money;

import com.personal.helper.money.creditCard.CreditCard;
import com.personal.helper.money.savings.Savings;
import com.personal.helper.money.spending.Spending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hnastevska on 10/2/2017.
 */
@RestController
public class MoneyController {

    private final long ACCOUNT_ID = 1;
    @Autowired
    MoneyService moneyService;

    @RequestMapping(value = "/money/salary/{amount}", method = RequestMethod.POST)
    public void postSalary(@PathVariable String amount) {
        moneyService.addSalary(Double.parseDouble(amount), ACCOUNT_ID);

    }

    @RequestMapping(value = "/money/spending/{amount}/{reason}", method = RequestMethod.POST)
    public void postSpending(@PathVariable String amount, @PathVariable String reason) {
        moneyService.addDailySpending(Double.parseDouble(amount), reason, ACCOUNT_ID);

    }

    @RequestMapping(value = "/money/spending/month/{amount}/{reason}/{month}", method = RequestMethod.POST)
    public void postSpendingMonth(@PathVariable String amount, @PathVariable String reason, @PathVariable String month) {
        int m = Integer.parseInt(month);
        moneyService.addDailySpendingMonth(Double.parseDouble(amount), reason, m, ACCOUNT_ID);

    }

    @RequestMapping(value = "/saving/{amount}", method = RequestMethod.POST)
    public void postSavings(@PathVariable String amount) {
        moneyService.addSavings(Double.parseDouble(amount), ACCOUNT_ID);

    }

    @RequestMapping(value = "/money/stats", method = RequestMethod.GET)
    public List<Money> getStats() {
        return moneyService.findAll();

    }

    @RequestMapping(value = "/money/stats/month/{m}", method = RequestMethod.GET)
    public List<Spending> getStatsByMonth(@PathVariable int m) {
        // int month = Integer.parseInt(m);
        return moneyService.addDailySpendingByMonth(m);

    }

    @RequestMapping(value = "/money/getSavingsList", method = RequestMethod.GET)
    public List<Savings> getSavingsList() {
        return moneyService.getSavingsList();

    }

    @RequestMapping(value = "/money/getDebtList", method = RequestMethod.GET)
    public List<CreditCard> getDebtList() {
        return moneyService.getDebtList();

    }

    @RequestMapping(value = "/money/spending/stats", method = RequestMethod.GET)
    public List<Spending> getSpendingStats() {
        return moneyService.getAllSpending();

    }

    @RequestMapping(value = "/money/spending/total", method = RequestMethod.GET)
    public double getSpendingTotal() {
        return moneyService.getAllSpending().stream().mapToDouble(i -> i.getAmount()).sum();

    }

    @RequestMapping(value = "/money/spending/totalByMonth/{m}", method = RequestMethod.GET)
    public double getSpendingTotalByMonth(@PathVariable int m) {
        return moneyService.getAllSpendingByMonth(m).stream().mapToDouble(i -> i.getAmount()).sum();

    }

    @RequestMapping(value = "/money/getSalary", method = RequestMethod.GET)
    public double getSalary() {
        return moneyService.getSalary(ACCOUNT_ID);

    }

    @RequestMapping(value = "/money/getDebt", method = RequestMethod.GET)
    public double getDebt() {
        return moneyService.getDebt(ACCOUNT_ID);

    }

    @RequestMapping(value = "/money/getSavings", method = RequestMethod.GET)
    public double getSavings() {
        return moneyService.getSavings(ACCOUNT_ID);

    }

}
