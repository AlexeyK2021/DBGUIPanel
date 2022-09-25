package ru.alexeyk2021.dbguipanel.managers;

import ru.alexeyk2021.dbguipanel.models.ClientPersonalInfo;

import java.sql.*;

public class LoginManager {
    private static LoginManager loginManager = null;
    private DbManager dbManager;

    private boolean isAdminLogged = false;
    private int currentUserId = -1;

    private LoginManager() {
        dbManager = DbManager.getInstance();
    }

    public static LoginManager getInstance() {
        if (loginManager == null)
            loginManager = new LoginManager();
        return loginManager;
    }

    public boolean enter(String login, String password) {
        boolean enterResult = checkEnter(login, password);
        System.out.println("LOGIN: " + enterResult);

        return enterResult;
    }

    private boolean checkEnter(String login, String password) {
        for (ClientPersonalInfo info : dbManager.getAllClientsData()) {
            if (info.getLogin().equals(login) && info.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
