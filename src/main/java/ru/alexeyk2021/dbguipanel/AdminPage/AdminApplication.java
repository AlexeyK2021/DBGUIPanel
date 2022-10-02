package ru.alexeyk2021.dbguipanel.AdminPage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.alexeyk2021.dbguipanel.HelloApplication;

import java.io.IOException;

public class AdminApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Admin panel");
        stage.setScene(scene);
        stage.show();
    }
}
