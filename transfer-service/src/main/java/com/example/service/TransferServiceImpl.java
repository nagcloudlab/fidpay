package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("transferService")
public class TransferServiceImpl implements TransferService{

    private static final Logger logger=Logger.getLogger("ts");
    private AccountRepository accountRepository;

    @Autowired
    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository=accountRepository;
        logger.info("TransferService instance created..");
    }

    // ACIDD principles
    // Atomic
    // Consistency
    // Isolation
    // Durability

    @Transactional(
            transactionManager = "transactionManager",
            rollbackFor = {AccountBalanceException.class},
            noRollbackFor = {RuntimeException.class},
            timeout = 60,
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            readOnly = false
    )
    public boolean transfer(double amount, String fromAccNumber, String toAccNumber) {
        logger.info("transfer initiated.");
        Account a1 = accountRepository.load(fromAccNumber);
        Account a2 = accountRepository.load(toAccNumber);
        if(!(a1.getBalance()>=amount))
            throw new AccountBalanceException("no enough balance");
        a1.setBalance(a1.getBalance() - amount);
        a2.setBalance(a2.getBalance() + amount);
        accountRepository.update(a1);
        accountRepository.update(a2);
        logger.info("transfer completed.");
        return true;
    }


}
