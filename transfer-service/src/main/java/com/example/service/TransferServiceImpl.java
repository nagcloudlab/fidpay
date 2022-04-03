package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.apache.log4j.Logger;

// SOLID
public class TransferServiceImpl implements TransferService{

    private static final Logger logger=Logger.getLogger("ts");
    private AccountRepository accountRepository;

    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository=accountRepository;
        logger.info("TransferService instance created..");
    }

    public boolean transfer(double amount, String fromAccNumber, String toAccNumber) {
        logger.info("transfer initiated.");
        Account a1 = accountRepository.load(fromAccNumber);
        Account a2 = accountRepository.load(toAccNumber);
        a1.setBalance(a1.getBalance() - amount);
        a2.setBalance(a2.getBalance() + amount);
        accountRepository.update(a1);
        accountRepository.update(a2);
        logger.info("transfer completed.");
        return true;
    }

}
