package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    // ✅ Create (JSON)
    @PostMapping("/create")
    public Account create(@RequestBody Account acc) {
        return service.create(acc);
    }

    // Deposit
    @PostMapping("/deposit")
    public Account deposit(@RequestParam int id,
                           @RequestParam double amount) {
        return service.deposit(id, amount);
    }

    // Withdraw
    @PostMapping("/withdraw")
    public Account withdraw(@RequestParam int id,
                            @RequestParam double amount) {
        return service.withdraw(id, amount);
    }

    // Balance
    @GetMapping("/balance/{id}")
    public double getBalance(@PathVariable int id) {
        return service.getBalance(id);
    }
}
