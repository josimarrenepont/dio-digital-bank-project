package model;

import model.DTO.ClientDTO;

import java.util.HashSet;
import java.util.Set;

public abstract class CurrentAccount extends Account {

    public CurrentAccount(ClientDTO clientDTO){
        super(createClientSet(clientDTO));
    }
    private static Set<Client> createClientSet(ClientDTO clientDTO) {
        Set<Client> clients = new HashSet<>();
        clients.add(new Client(clientDTO.getName(), clientDTO.getTypeAccount()));
        return clients;
    }
    @Override
    public void printStatement(){
        System.out.println("-----------------------------------------------");
        System.out.println("          Current Account Statement            ");
        System.out.println("-----------------------------------------------");
        super.printStatement();
    }


}
