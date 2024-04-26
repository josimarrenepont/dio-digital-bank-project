package contracts;

import model.Account;

public interface IAccount {
    void withdraw(Double value);

    void balance(Double value);

    void numberAccount(String account);

    void printStatement();

    void deposit(Double value);

    void transfer(Double value, Account destinationAccount, Double transferRate);

    void transfer(Double value, Account destinationAccount);
}
