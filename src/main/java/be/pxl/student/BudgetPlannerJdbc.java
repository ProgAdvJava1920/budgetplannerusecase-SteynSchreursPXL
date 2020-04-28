package be.pxl.student;

import be.pxl.student.dao.AccountDAO;
import be.pxl.student.dao.LabelDAO;
import be.pxl.student.dao.PaymentDAO;
import be.pxl.student.entity.Account;
import be.pxl.student.entity.Label;
import be.pxl.student.entity.Payment;

import java.time.LocalDateTime;
import java.util.List;

public class BudgetPlannerJdbc {
    public static void main(String[] args) {
        AccountDAO accountDao = new AccountDAO("jdbc:mysql://localhost:3306/budgetplanner?useSSL=false", "root", "root");
        PaymentDAO paymentDao = new PaymentDAO("jdbc:mysql://localhost:3306/budgetplanner?useSSL=false", "root", "root");
        LabelDAO labelDao = new LabelDAO("jdbc:mysql://localhost:3306/budgetplanner?useSSL=false", "root", "root");
        Account account = new Account();

        account = accountDao.readAccount(1);
        Account toAccount = accountDao.readAccount(2);


        Payment payment = new Payment(LocalDateTime.now(), 10, "EUR", "");
        payment.setCounterAccountId(toAccount.getId());
        payment.setAccountId(account.getId());
        payment.setAccount(account);
        payment.setLabelId(1);
        paymentDao.createPayment(payment);


    }
}
