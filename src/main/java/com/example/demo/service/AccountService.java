// package com.example.demo.service;

// import org.springframework.stereotype.Service;
// import com.example.demo.model.Account;

// import java.util.HashMap;
// import java.util.Map;

// @Service
// public class AccountService {

//     private Map<Integer, Account> map = new HashMap<>();

//     public Account create(int id, String name, double balance) {
//         Account acc = new Account(id, name, balance);
//         map.put(id, acc);
//         return acc;
//     }

//     public Account deposit(int id, double amount) {
//         Account acc = map.get(id);
//         if (acc == null)
//             return null;

//         acc.balance += amount;
//         return acc;
//     }

//     public double getBalance(int id) {
//         Account acc = map.get(id);
//         return acc == null ? -1 : acc.balance;
//     }

//     public Account withdraw(int id, double amount) {
//         Account acc = map.get(id);

//         if (acc == null) {
//             return null;
//         }

//         if (acc.balance < amount) {
//             System.out.println("Insufficient Balance");
//             return acc;
//         }

//         acc.balance -= amount;
//         return acc;
//     }
// }
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repo;

    // 🔹 Create Account
    public Account create(String name, double balance) {
        Account acc = new Account();
        acc.name = name;
        acc.balance = balance;
        return repo.save(acc);
    }

    // 🔹 Deposit Money
    public Account deposit(int id, double amount) {
        Account acc = repo.findById(id).orElse(null);

        if (acc == null) {
            return null;
        }

        acc.balance += amount;
        return repo.save(acc);
    }

    // 🔹 Withdraw Money
    public Account withdraw(int id, double amount) {
        Account acc = repo.findById(id).orElse(null);

        if (acc == null) {
            return null;
        }

        if (acc.balance < amount) {
            System.out.println("Insufficient Balance");
            return acc;
        }

        acc.balance -= amount;
        return repo.save(acc);
    }

    // 🔹 Get Balance
    public double getBalance(int id) {
        Account acc = repo.findById(id).orElse(null);

        if (acc == null) {
            return -1;
        }

        return acc.balance;
    }
}