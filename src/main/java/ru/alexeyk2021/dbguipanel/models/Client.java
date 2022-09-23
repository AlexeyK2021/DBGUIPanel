package ru.alexeyk2021.dbguipanel.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Client {
    private int clientId;
    private double balance;
    private String phoneNumber;
    private boolean accountState;
    private Tariff tariff;
    private ClientPersonalInfo personalInfo;
    private Report[] reports;

    public Client(int clientId, double balance, String phoneNumber, boolean accountState, Tariff tariff, ClientPersonalInfo personalInfo, Report[] reports) {
        this.clientId = clientId;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
        this.accountState = accountState;
        this.tariff = tariff;
        this.personalInfo = personalInfo;
        this.reports = reports;
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

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public ClientPersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public Report[] getReports() {
        return reports;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", balance=" + balance +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accountState=" + accountState +
                ", tariff=" + tariff +
                ", personalInfo=" + personalInfo +
                ", reports=" + Arrays.toString(reports) +
                '}';
    }
}
