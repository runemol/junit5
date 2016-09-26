package com.borderlan.account;

public class SavingsAccount {
    private double balance;
    private double interest;
    private String accountName;

    public SavingsAccount() {
        balance = 0;
        interest = 0;
    }

    public SavingsAccount(String accountName, double initialBalance, double initialInterest) {
        balance = initialBalance;
        interest = initialInterest;
        this.accountName = accountName;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        balance = balance - amount;
    }

    public void addInterest() throws IllegalArgumentException {
        if (interest < 0.0D) {
            throw new IllegalArgumentException("Interestcan not be less that 0!");
        }
        balance = balance + balance * interest;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
