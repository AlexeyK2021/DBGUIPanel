package ru.alexeyk2021.dbguipanel.models;

import javax.persistence.Entity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
@Entity
public class Client {
    private int clientId;
    private double balance;
    private String phoneNumber;
    private boolean accountState;
    private int tariffId;

    public Client(int clientId, double balance, String phoneNumber, boolean accountState, int tariffId, ClientPersonalInfo personalInfo) {
        this.clientId = clientId;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
        this.accountState = accountState;
        this.tariffId = tariffId;
    }

    public Client(ResultSet resultSet) {
        try {
            clientId = resultSet.getInt("client_id");
            balance = resultSet.getDouble("balance");
            phoneNumber = resultSet.getString("phone_number");
            accountState = resultSet.getBoolean("account_state");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean isAccountState() {
        return accountState;
    }


    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", balance=" + balance +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accountState=" + accountState +
                '}';
    }
}
