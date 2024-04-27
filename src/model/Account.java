package model;

import exceptions.InsufficientFundsException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Account {
    private static final int AGENCY = 1;
    private static int SEQUENTIAL = 1;

    protected Double balance;
    protected Integer numberAccount;
    protected Integer agency;
    protected Set<Client> client;
    protected Set<Account> accounts;

    protected Double dailyWithdrawalLimit = 2000.0;
    protected Double transferRate = 4.99;

    public Account(Set<Client> client) {
        this.agency = Account.AGENCY;
        this.numberAccount = SEQUENTIAL++;
        this.client = client;
        this.accounts = new HashSet<>();
        this.balance = 0.0;
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getNumberAccount() {
        return numberAccount;
    }

    public Integer getAgency() {
        return agency;
    }

    public Set<Client> getClient() {
        return client;
    }

    public Double getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }

    public Double getTransferRate() {
        return transferRate;
    }

    public Set<Account> getAccounts(Class<SavingsAccount> savingsAccountClass) {
        return accounts;
    }

    public void printStatement() {
        System.out.println("Titular: " + client.iterator().next().getName());
        System.out.println("Agencia: " + this.getAgency());
        System.out.println("Número: " + this.getNumberAccount());
        System.out.println("Depósito: " + getDeposit(0.0)); // Valor do depósito inicial
        System.out.println("Saque: " + (balance - getDeposit(0.0))); // Valor do saque (saldo atual - saldo inicial)
        System.out.println("Saldo Após o Saque: " + this.getBalance());
        System.out.println("Limite de Saque Diário: R$ " + (this.getDailyWithdrawalLimit()));
        System.out.println("Taxa de Transferência: R$ " + this.getTransferRate());
    }


    public abstract String getAccountType();

    public void deposit(Double value) throws IllegalArgumentException {
        if (value <= 0) {
            throw new IllegalArgumentException("Valor de depósito inválido. Valor precisa ser maior que zero: " + value);
        }
        balance += value;
    }

    public void withdraw(Double withdraw) throws InsufficientFundsException {
        if (withdraw > dailyWithdrawalLimit) {
            throw new InsufficientFundsException("Limite diário de saque excedido: " + dailyWithdrawalLimit);
        }
        if (withdraw > balance) {
            throw new InsufficientFundsException("Saldo insuficiente para saque: " + balance);
        }

        // Subtrai o valor do saque do saldo
        balance -= withdraw;

        // Subtrai apenas o valor do saque do limite de saque diário
        dailyWithdrawalLimit -= withdraw;
    }


    public void transfer(Double value, Account destinationAccount) throws InsufficientFundsException {
        if (value > balance) {
            throw new InsufficientFundsException("Saldo insuficiente para transferência: " + balance);
        }
        withdraw(value); // Subtrai o valor da transferência do saldo da conta de origem
        destinationAccount.deposit(value + transferRate);
    }

    public abstract Double getDeposit(Double value);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(getBalance(), account.getBalance()) && Objects.equals(getNumberAccount(), account.getNumberAccount()) && Objects.equals(getAgency(), account.getAgency()) && Objects.equals(getClient(), account.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBalance(), getNumberAccount(), getAgency());
    }
}
