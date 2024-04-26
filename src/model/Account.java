package model;

import contracts.IAccount;

import java.util.Objects;
import java.util.Set;

public abstract class Account implements IAccount {
    protected Double withdraw;
    protected Double balance;
    protected String numberAccount;
    protected String agency;
    protected Double deposit;
    protected Set<Client> client;

    protected Double dailyWithdrawalLimit = 2000.0;
    protected Double transferRate = 4.99;


    public Account(){}

    public Account(Double withdraw, Double balance, String numberAccount, String agency, Double deposit, Set<Client> client) {
        this.withdraw = withdraw;
        this.balance = balance;
        this.numberAccount = numberAccount;
        this.agency = agency;
        this.deposit = deposit;
        this.client = client;
    }

    public Double getWithdraw() {
        return withdraw;
    }

    public Double getBalance() {
        return balance;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public String getAgency() {
        return agency;
    }

    public Set<Client> getClient() {
        return client;
    }

    @Override
    public void withdraw(Double withdraw) {
        balance -= withdraw;
    }

    @Override
    public void balance(Double balance) {
        balance += deposit;
    }

    @Override
    public void numberAccount(String account) {
        this.numberAccount = numberAccount;
    }

    @Override
    public void transfer(Double value, Account destinationAccount) {
            this.withdraw(value);
            destinationAccount.deposit(value + transferRate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(getWithdraw(), account.getWithdraw()) && Objects.equals(getBalance(), account.getBalance()) && Objects.equals(getNumberAccount(), account.getNumberAccount()) && Objects.equals(getAgency(), account.getAgency()) && Objects.equals(getClient(), account.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWithdraw(), getBalance(), getNumberAccount(), getAgency());
    }
}
