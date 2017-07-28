package com.example.felipecosta.finances;

/**
 * Created by felipecosta on 7/27/17.
 */
public class User {
    private double money;
    private String name;


    public void withdraw(double amount) {
        this.money -= amount;
    }

    public void deposit(double amount) {
        this.money += amount;
    }

    public double getMoney(){
        return this.money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
