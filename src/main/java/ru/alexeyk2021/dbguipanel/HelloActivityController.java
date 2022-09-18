package ru.alexeyk2021.dbguipanel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ru.alexeyk2021.dbguipanel.managers.DbManager;

import java.io.IOException;
import java.util.Objects;

public class HelloActivityController {
    @FXML
    public Label HelloText;
    public Button hello_button;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        welcomeText.setText("Welcome to JavaFX Application!");
        HelloText.setText("Hello world from JavaFX!");
        DbManager manager = DbManager.getInstance();
        manager.connect();

//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
//        Stage stage = (Stage) hello_button.getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
}