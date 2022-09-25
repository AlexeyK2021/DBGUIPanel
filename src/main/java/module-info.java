module com.example.dbguipanel {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;


    opens ru.alexeyk2021.dbguipanel to javafx.fxml;
    exports ru.alexeyk2021.dbguipanel;
    exports ru.alexeyk2021.dbguipanel.managers;
    opens ru.alexeyk2021.dbguipanel.managers to javafx.fxml;
    exports ru.alexeyk2021.dbguipanel.LoginPage;
    opens ru.alexeyk2021.dbguipanel.LoginPage to javafx.fxml;
}