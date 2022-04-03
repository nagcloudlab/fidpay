package com.example.repository;

import com.example.model.Account;

public interface AccountRepository {
    public Account load(String accNumber);
    public Account update(Account account);
}
