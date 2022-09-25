package ru.alexeyk2021.dbguipanel.LoginPage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import ru.alexeyk2021.dbguipanel.managers.DbManager;
import ru.alexeyk2021.dbguipanel.managers.LoginManager;

public class LoginActivityController {
    @FXML
    public Button enter_btn;
    @FXML
    public PasswordField password_text;
    @FXML
    public TextField login_text;

    @FXML
    protected void enter() {
        if (LoginManager.getInstance().enter(login_text.getText(), password_text.getText())) {
            enter_btn.setStyle("-fx-background-color: Green");
            enter_btn.setText("Done!");
        } else {
            enter_btn.setStyle("-fx-background-color: Red");
            enter_btn.setText("Error!");
        }
    }
}
