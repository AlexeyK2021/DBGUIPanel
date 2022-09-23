package ru.alexeyk2021.dbguipanel.models;

public class Admin {
    private int adminId;
    private String fullName;
    private String login;
    private String password;

    public Admin(int adminId, String fullName, String login, String password) {
        this.adminId = adminId;
        this.fullName = fullName;
        this.login = login;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
