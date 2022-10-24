package ru.alexeyk2021.dbguipanel.managers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginManager {
    private static LoginManager loginManager = null;
    private DbManager dbManager;

    private boolean isAdminLogged = false;
    private int currentUserId = -1;
    private String adminLogin = "smirnov@admin.ru";
    private String adminPasswd = "ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270";

    private LoginManager() {
        dbManager = DbManager.getInstance();
    }

    public static LoginManager getInstance() {
        if (loginManager == null)
            loginManager = new LoginManager();
        return loginManager;
    }

    public boolean enter(String login, String password) {
        String encryptedPassword = bytesToHex(digest(password.getBytes(), "SHA-256"));
        if(login.equals(adminLogin) && password.equals(encryptedPassword)) return true;

        int enterId = dbManager.approveEnter(login, encryptedPassword);
        System.out.println("LOGIN: " + enterId);
        if (enterId > -1) {
            currentUserId = enterId;
        }
        return enterId > -1;
    }

    private static byte[] digest(byte[] input, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        return md.digest(input);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
