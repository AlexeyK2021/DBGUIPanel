package ru.alexeyk2021.dbguipanel.models;

public class ClientPersonalInfo {
    private String fullName;
    private String passportData;
    private String login;
    private String password;

    public ClientPersonalInfo(String fullName, String passportData, String login, String password) {
        this.fullName = fullName;
        this.passportData = passportData;
        this.login = login;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassportData() {
        return passportData;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
