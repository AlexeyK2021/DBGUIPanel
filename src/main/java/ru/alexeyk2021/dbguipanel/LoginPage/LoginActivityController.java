package ru.alexeyk2021.dbguipanel.LoginPage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.alexeyk2021.dbguipanel.AdminPage.AdminApplication;
import ru.alexeyk2021.dbguipanel.managers.LoginManager;

public class LoginActivityController {
    @FXML
    public Button enter_btn;
    @FXML
    public PasswordField password_text;
    @FXML
    public TextField login_text;
    public Button loginAsAdmin;
    public Label is_data_correct;


    @FXML
    protected void enter() {
        boolean isLoginSuccess = LoginManager.getInstance().enter(login_text.getText(), password_text.getText());
        changeUI(isLoginSuccess);
//        if (isLoginSuccess)
//            changePage();
    }

    @FXML
    public void loginAsAdmin(ActionEvent actionEvent) {
        boolean isLoginSuccess = LoginManager.getInstance().enter(login_text.getText(), password_text.getText());
        changeUI(isLoginSuccess);
        if (isLoginSuccess)
            openAdminPage();
    }

    private void openClientPage(){
//        try {
//            Stage stage = (Stage) enter_btn.getScene().getWindow();
//            Application adminPanel = new AdminApplication();
//            adminPanel.start(stage);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    private void openAdminPage() {
        try {
            Stage stage = (Stage) enter_btn.getScene().getWindow();
            Application adminPanel = new AdminApplication();
            adminPanel.start(stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void changeUI(boolean loginSuccess) {
        is_data_correct.setVisible(true);
        if (loginSuccess) {
            is_data_correct.setText("Login success!");
            is_data_correct.setStyle("-fx-text-fill: Green");
        } else {
            is_data_correct.setText("Login failed!");
            is_data_correct.setStyle("-fx-text-fill: Red");
        }
    }
}
