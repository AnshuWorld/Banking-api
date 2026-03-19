package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Account;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    private Map<Integer, Account> map = new HashMap<>();

    public Account create(int id, String name, double balance) {
        Account acc = new Account(id, name, balance);
        map.put(id, acc);
        return acc;
    }

    public Account deposit(int id, double amount) {
        Account acc = map.get(id);
        if (acc == null)
            return null;

        acc.balance += amount;
        return acc;
    }

    public double getBalance(int id) {
        Account acc = map.get(id);
        return acc == null ? -1 : acc.balance;
    }

    public Account withdraw(int id, double amount) {
        Account acc = map.get(id);

        if (acc == null) {
            return null;
        }

        if (acc.balance < amount) {
            System.out.println("Insufficient Balance");
            return acc;
        }

        acc.balance -= amount;
        return acc;
    }
}