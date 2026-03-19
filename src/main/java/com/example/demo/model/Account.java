// package com.example.demo.model;

// public class Account {
//     public int id;
//     public String name;
//     public double balance;

//     public Account(int id, String name, double balance) {
//         this.id = id;
//         this.name = name;
//         this.balance = balance;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;
    public double balance;
}