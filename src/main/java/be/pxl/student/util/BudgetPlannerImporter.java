package be.pxl.student.util;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Util class to import csv file
 */
public class BudgetPlannerImporter {
    private Account account;

    public BudgetPlannerImporter() { //src/main/resources/account_payments.csv
    }

    public List<Payment> readFile(Path pathFileToRead){
        Path path = Paths.get(String.valueOf(pathFileToRead));
        List<Payment> payments = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.readLine();
            String line = null;

            while ((line = reader.readLine()) != null ) {
                if (account == null) {
                    account = getAccount(line);
                    Payment newPayment = getPayment(line);
                    payments.add(newPayment);
                } else {
                    Payment newPayment = getPayment(line);
                    payments.add(newPayment);
                }
            }
            addPaymentsToAccount(payments);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return payments;
    }

    private void addPaymentsToAccount(List<Payment> payments) {
        account.setPayments(payments);
    }

    public Payment getPayment(String line) {
        Payment payment= new Payment();
        String[] lines = line.split(",");


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy");
        LocalDateTime dateTime = LocalDateTime.parse(lines[3], formatter);

        float amount = Float.parseFloat(lines[4]);
        String currency = lines[5];
        String detail = lines[6];

        payment.setDate(dateTime);
        payment.setAmount(amount);
        payment.setCurrency(currency);
        payment.setDetail(detail);

        return payment;
    }

    public Account getAccount(String line) {
        String[] lines = line.split(",");
        account = new Account();
        account.setIBAN(lines[1]);
        account.setName(lines[0]);
        return account;
    }


    @Override
    public String toString() {
        return "Account{" +
                "IBAN='" + account.getIBAN() + '\'' +
                ", name='" + account.getName() + '\'' +
                ", payments=[" + account.getPayments().stream().map(Payment::toString).collect(Collectors.joining(",")) + "]}";
    }

}