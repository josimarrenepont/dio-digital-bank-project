package model;

import java.util.Set;

public class Bank {

    private String name;
    private Set<Account> accounts;

    public Bank(){}

    public Bank(String name, Set<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

}
