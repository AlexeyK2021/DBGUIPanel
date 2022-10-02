package ru.alexeyk2021.dbguipanel.LoginPage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import ru.alexeyk2021.dbguipanel.AdminPage.AdminApplication;
import ru.alexeyk2021.dbguipanel.managers.DbManager;
import ru.alexeyk2021.dbguipanel.managers.LoginManager;

import java.io.IOException;
import java.util.Objects;

public class LoginActivityController {
    @FXML
    public Button enter_btn;
    @FXML
    public PasswordField password_text;
    @FXML
    public TextField login_text;
    public Button loginAsAdmin;
    public TextField isDataCorrect;

    @FXML
    protected void enter() {
        boolean isLoginSuccess = LoginManager.getInstance().enter(login_text.getText(), password_text.getText());
        changeUI(isLoginSuccess);
//        if (isLoginSuccess)
//            changePage();
    }

    @FXML
    public void loginAsAdmin(ActionEvent actionEvent) {
        boolean isLoginSuccess = LoginManager.getInstance().enter(login_text.getText(), password_text.getText(), true);
        changeUI(isLoginSuccess);
        if (isLoginSuccess)
            changePage();
    }

    private void changePage() {
        try {
            Stage stage = (Stage) enter_btn.getScene().getWindow();
            Application adminPanel = new AdminApplication();
            adminPanel.start(stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void changeUI(boolean loginSuccess) {
        isDataCorrect.setVisible(true);
        if (loginSuccess) {
            isDataCorrect.setText("Login success!");
            isDataCorrect.setStyle("-fx-background-color: Green");
        } else {
            isDataCorrect.setText("Login failed!");
            isDataCorrect.setStyle("-fx-background-color: Red");
        }
    }
}
