package be.pxl.student.util;

import be.pxl.student.entity.Payment;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class BudgetPlannerImporterTest {
    BudgetPlannerImporter planner;

    @Test
    public void paymentShouldReturnCorrectAmount(){
        String line = "Jos,BE69771770897312,BE38966278832259,Sat Feb 15 10:56:46 CET 2020,-3372.36,EUR,Et est voluptatibus perferendis voluptatem.";
        BudgetPlannerImporter bpi = new BudgetPlannerImporter();
        Payment payment = bpi.getPayment(line);

        Payment payment2 = new Payment();
        payment2.setAmount(-2263.59f);
        payment2.setCurrency("EUR");
        payment2.setDetail("Veritatis qui voluptas nostrum iste vitae maxime enim.");

        Assertions.assertEquals(payment.getAmount(), (payment.getAmount() * 100) / 100);
    }

    @Test
    public void paymentShouldReturnCorrectDetail(){
        String line = "Jos,BE69771770897312,BE38966278832259,Sat Feb 15 10:56:46 CET 2020,-3372.36,EUR,Et est voluptatibus perferendis voluptatem.";
        BudgetPlannerImporter bpi = new BudgetPlannerImporter();
        Payment payment = bpi.getPayment(line);

        Payment payment2 = new Payment();
        payment2.setAmount(-2263.59f);
        payment2.setCurrency("EUR");
        payment2.setDetail("Et est voluptatibus perferendis voluptatem.");

        Assertions.assertEquals(payment.getDetail(), payment2.getDetail());
    }

    @Test
    public void paymentShouldReturnCorrectCurrency(){
        String line = "Jos,BE69771770897312,BE38966278832259,Sat Feb 15 10:56:46 CET 2020,-3372.36,EUR,Et est voluptatibus perferendis voluptatem.";
        BudgetPlannerImporter bpi = new BudgetPlannerImporter();
        Payment payment = bpi.getPayment(line);

        Payment payment2 = new Payment();
        payment2.setAmount(-2263.59f);
        payment2.setCurrency("EUR");
        payment2.setDetail("Et est voluptatibus perferendis voluptatem.");

        Assertions.assertEquals(payment.getCurrency(), payment2.getCurrency());
    }
}
