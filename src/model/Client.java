package model;

import java.util.Objects;

public class Client {
    private String name;
    private String typeAccount;

    public Client(){}

    public Client(String name, String typeAccount) {
        this.name = name;
        this.typeAccount = typeAccount;
    }

    public String getName() {
        return name;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(getName(), client.getName()) && Objects.equals(getTypeAccount(), client.getTypeAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getTypeAccount());
    }
}
