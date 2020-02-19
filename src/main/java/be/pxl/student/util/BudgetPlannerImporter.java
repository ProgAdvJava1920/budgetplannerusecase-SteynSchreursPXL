package be.pxl.student.util;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Util class to import csv file
 */
public class BudgetPlannerImporter {
    private String fileName;
    private Account account;

    public BudgetPlannerImporter(String fileName) {
        this.fileName = fileName;
    }

    public Account readFile() {
        List<Payment> payments = new ArrayList<>();
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.readLine() != null) {
                String[] splittedString = reader.readLine().split(",");
                if (account == null) {
                    account = createAccount(splittedString);
                }
                Payment payment = createPayment(splittedString);
                payments.add(payment);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        account.setPayments(payments);
        return account;
    }

    private Account createAccount(String[] lines) {
        Account account = new Account();
        account.setName(lines[0]);
        account.setIBAN(lines[1]);
        return account;
    }

    private Payment createPayment(String[] lines) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy");
        LocalDateTime dateTime = LocalDateTime.parse(lines[3], formatter);
        float amount = Float.parseFloat(lines[4]);
        return new Payment(dateTime, amount, lines[5], lines[6]);
    }
}
