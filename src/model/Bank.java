package model;

import java.util.Set;

public class Bank {

    private String name;
    private Set<Account> accounts;
    private Set<Client> clients;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Client> getClients() {
        return clients;
    }

}
