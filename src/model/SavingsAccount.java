package model;

import java.util.Set;

public abstract class SavingsAccount extends Account {

    public SavingsAccount(Set<Client> client){
        super(client);
    }
    @Override
    public void printStatement(){
        System.out.println("-----------------------------------------------");
        System.out.println("          Savings Account Statement            ");
        System.out.println("-----------------------------------------------");
        super.printStatement();
    }
}
