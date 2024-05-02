import exceptions.InsufficientFundsException;
import model.*;
import model.DTO.ClientDTO;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<ClientDTO> clientDTOList = new ArrayList<>();
        clientDTOList.add(new ClientDTO("João", "Current Account"));
        clientDTOList.add(new ClientDTO("Maria", "Savings Account"));

        Bank bank = new Bank("MyBank", new HashSet<>());

        for (ClientDTO clientDto : clientDTOList) {
            Account account;
            if (clientDto.getTypeAccount().equals("Current Account")) {
                Set<Client> clients = createClientSet(clientDto);
                account = new CurrentAccount(clientDto) {
                    @Override
                    public String getAccountType() {
                        return "";
                    }

                    @Override
                    public Double getDeposit(Double value) {
                        return 300.0;
                    }
                };
                bank.getAccounts().add(account);

                // Realiza operações bancárias para a conta corrente
                account.deposit(300.0); // Realiza um depósito inicial
                // Realiza um saque de 150.0
                try {
                    account.withdraw(150.0);
                } catch (InsufficientFundsException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                Set<Client> clients = createClientSet(clientDto);
                account = new SavingsAccount(clients) {
                    @Override
                    public String getAccountType() {
                        return "";
                    }

                    @Override
                    public Double getDeposit(Double value) {
                        return 300.0;
                    }
                };
                bank.getAccounts().add(account);

                // Realiza operações bancárias para a conta poupança
                account.deposit(200.0); // Realiza um depósito inicial
                // Realiza uma transferência de 100.0 para a outra conta
                try {
                    account.transfer(100.0, bank.getAccounts().iterator().next());
                } catch (InsufficientFundsException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            // Exibe o extrato da conta
            account.printStatement();
        }
    }

    // Método para criar o Set<Client> com base no ClientDTO
    private static Set<Client> createClientSet(ClientDTO clientDTO) {
        Set<Client> clients = new HashSet<>();
        clients.add(new Client(clientDTO.getName(), clientDTO.getTypeAccount()));
        return clients;
    }
}
