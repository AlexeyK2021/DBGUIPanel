package ru.alexeyk2021.dbguipanel.models;

public class User {
    private String name;
    private String login;
    private String encryptedPassword;
    private Boolean isAdmin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public User(String name, String login, String encrypted_password, Boolean isAdmin) {
        this.name = name;
        this.login = login;
        this.encryptedPassword = encrypted_password;
        this.isAdmin = isAdmin;
    }
}
