package com.finalproject.entity;

public class CreditAccount {
    int id;
    String status;
    int balance;
    int creditLimit;
    int debt;
    int percentage;
    int creditRate;
    String depositStart;
    String depositEnd;
    int depositDuration;
    int accountId;

    public CreditAccount(int id, String status, int balance, int creditLimit, int debt,
                         int percentage, int creditRate, String depositStart,
                         String depositEnd, int depositDuration, int accountId) {
        this.id = id;
        this.status = status;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.debt = debt;
        this.percentage = percentage;
        this.creditRate = creditRate;
        this.depositStart = depositStart;
        this.depositEnd = depositEnd;
        this.depositDuration = depositDuration;
        this.accountId = accountId;
    }

    public CreditAccount(String status, int balance, int creditLimit, int debt,
                         int percentage, int creditRate, String depositStart,
                         String depositEnd, int depositDuration, int accountId) {
        this.status = status;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.debt = debt;
        this.percentage = percentage;
        this.creditRate = creditRate;
        this.depositStart = depositStart;
        this.depositEnd = depositEnd;
        this.depositDuration = depositDuration;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(int creditRate) {
        this.creditRate = creditRate;
    }

    public String getDepositStart() {
        return depositStart;
    }

    public void setDepositStart(String depositStart) {
        this.depositStart = depositStart;
    }

    public String getDepositEnd() {
        return depositEnd;
    }

    public void setDepositEnd(String depositEnd) {
        this.depositEnd = depositEnd;
    }

    public int getDepositDuration() {
        return depositDuration;
    }

    public void setDepositDuration(int depositDuration) {
        this.depositDuration = depositDuration;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", creditLimit=" + creditLimit +
                ", debt=" + debt +
                ", percentage=" + percentage +
                ", creditRate=" + creditRate +
                ", depositStart='" + depositStart + '\'' +
                ", depositEnd='" + depositEnd + '\'' +
                ", depositDuration=" + depositDuration +
                ", accountId=" + accountId +
                '}';
    }
}
