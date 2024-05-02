    package contracts;

    import exceptions.InsufficientFundsException;
    import model.Account;

    public interface IAccount {
        void withdraw(Double value) throws InsufficientFundsException;

        void balance(Double value);

        void numberAccount(String account);

        void printStatement();

        void deposit(Double value);

        void transfer(Double value, Account destinationAccount) throws InsufficientFundsException;

        Double getDeposit(Double value);
    }
