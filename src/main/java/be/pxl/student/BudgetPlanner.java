package be.pxl.student;

import be.pxl.student.dao.AccountDAO;
import be.pxl.student.entity.Account;
import be.pxl.student.util.BudgetPlannerImporter;

import java.util.logging.Logger;

public class BudgetPlanner {
    public static void main(String[] args) {
        BudgetPlannerImporter importer=new BudgetPlannerImporter();
        Account account= importer.readFile("src\\main\\resources\\account_payments.csv");
        System.out.println(account);

    }

}
