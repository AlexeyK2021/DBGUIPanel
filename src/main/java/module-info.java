module ru.alexeyk.dbguipanel {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires javax.persistence;


    exports ru.alexeyk2021.dbguipanel;
    opens ru.alexeyk2021.dbguipanel to javafx.fxml;
    exports ru.alexeyk2021.dbguipanel.managers;
    opens ru.alexeyk2021.dbguipanel.managers to javafx.fxml;
    exports ru.alexeyk2021.dbguipanel.LoginPage;
    opens ru.alexeyk2021.dbguipanel.LoginPage to javafx.fxml;
    exports ru.alexeyk2021.dbguipanel.AdminPage;
    opens ru.alexeyk2021.dbguipanel.AdminPage to javafx.fxml;
    exports ru.alexeyk2021.dbguipanel.models;
    opens ru.alexeyk2021.dbguipanel.models to javafx.fxml;
    exports ru.alexeyk2021.dbguipanel.ClientPage;
    opens ru.alexeyk2021.dbguipanel.ClientPage to javafx.fxml;
}