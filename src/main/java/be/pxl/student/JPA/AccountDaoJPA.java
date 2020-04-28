package be.pxl.student.JPA;

import be.pxl.student.entity.Account;

import javax.persistence.*;
import javax.persistence.Persistence;
import java.util.List;

public class AccountDaoJPA {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");

    public List<Account> read() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Account> accountList = em.createQuery("Select a From Account;").getResultList();
        tx.commit();
        em.close();
        return accountList;
    }
}
