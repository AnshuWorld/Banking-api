package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repo;

    // Create
    public Account create(Account acc) {
        return repo.save(acc);
    }

    // Deposit
    public Account deposit(int id, double amount) {
        Account acc = repo.findById(id).orElse(null);
        if (acc == null) return null;

        acc.setBalance(acc.getBalance() + amount);
        return repo.save(acc);
    }

    // Withdraw
    public Account withdraw(int id, double amount) {
        Account acc = repo.findById(id).orElse(null);
        if (acc == null) return null;

        if (acc.getBalance() < amount) return acc;

        acc.setBalance(acc.getBalance() - amount);
        return repo.save(acc);
    }

    // Balance
    public double getBalance(int id) {
        Account acc = repo.findById(id).orElse(null);
        return acc == null ? -1 : acc.getBalance();
    }
}
