package be.pxl.student.util;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;
import be.pxl.student.jdbc.AccountDAO;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BudgetPlannerJDBC {
    public static void main(String[] args) {


        AccountDAO accountDao = new AccountDAO("jdbc:mysql://localhost:3306/budgetplanner?useSSL=false", "root", "root");
        Payment payment = new Payment();
        payment.setAmount(10);
        payment.setCurrency("EUR");
        payment.setDate(LocalDateTime.now());
        payment.setDetail("");

        List<Payment> paymentList = new ArrayList<Payment>();
        paymentList.add(payment);
        Account account = new Account();
        account.setIBAN("BE71096123456769");
        account.setId(1);
        account.setName("voornam achternaam");
        account.setPayments(paymentList);
        accountDao.createAccount(account);
        System.out.println(accountDao.readAccount(1).toString());
    }
}
