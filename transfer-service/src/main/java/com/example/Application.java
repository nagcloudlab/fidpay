package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TransferService;
import com.example.service.TransferServiceImpl;

public class Application {
    public static void main(String[] args) {

        //1. init / booting phase

        AccountRepository jdbcAccountRepository = new JdbcAccountRepository();
        AccountRepository jpaAccountRepository = new JpaAccountRepository();
        TransferService transferService = new TransferServiceImpl(jpaAccountRepository);

        // 2. use phase
        transferService.transfer(100.00, "1", "2");

        // 3. destroy phase
        transferService = null;

    }
}
