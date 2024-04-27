package model.DTO;

public class ClientDTO{
    private String name;
    private String typeAccount;

    public ClientDTO(String name, String typeAccount){
        this.name = name;
        this.typeAccount = typeAccount;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

}
