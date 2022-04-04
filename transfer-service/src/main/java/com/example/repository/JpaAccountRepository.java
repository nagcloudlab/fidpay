package com.example.repository;

import com.example.entity.Account;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component("jpaAccountRepository")
public class JpaAccountRepository implements AccountRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account load(String accNumber) {
        return entityManager.find(Account.class,accNumber);
    }

    @Override
    public Account update(Account account) {
        return entityManager.merge(account);
    }

}
