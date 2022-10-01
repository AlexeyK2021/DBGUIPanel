package ru.alexeyk2021.dbguipanel.managers;

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
        return dbManager.approveClientEnter(login, password);
    }
}
