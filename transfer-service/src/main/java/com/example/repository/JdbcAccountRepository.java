package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;

public class JdbcAccountRepository implements AccountRepository{

    private static final Logger logger=Logger.getLogger("ts");

    public JdbcAccountRepository() {
        logger.info("JdbcAccountRepository instance created..");
    }

    public Account load(String accNumber){
        logger.info("loading account - "+accNumber);
        // TODO:
        return new Account(accNumber,1000.00);
    }
    public Account update(Account account){
        logger.info("updating account - "+account.getNumber());
        // TODO:
        return account;
    }
}
