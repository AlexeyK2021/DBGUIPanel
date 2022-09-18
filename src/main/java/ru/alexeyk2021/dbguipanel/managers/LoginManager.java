package ru.alexeyk2021.dbguipanel.managers;

import ru.alexeyk2021.dbguipanel.models.User;

public class LoginManager {
    private User currentUser;
    private static LoginManager loginManager = null;
    private LoginManager(){}

    public static LoginManager getInstance() {
        if(loginManager == null)
            loginManager = new LoginManager();
        return loginManager;
    }
}
