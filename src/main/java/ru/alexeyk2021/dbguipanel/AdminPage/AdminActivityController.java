package ru.alexeyk2021.dbguipanel.AdminPage;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class AdminActivityController {
    public TextField find_client_text;
    public Button find_client_btn;
    public ListView clients_list_view;
    public Button set_client_tariff_button;
    public Label client_tariff;
    public HBox client_tariff_group;
    public ListView client_add_services;
    public Button set_client_add_services_button;
    public Label client_balance;
    public Label client_account_state;
    public Label client_name;
    public Button set_client_name;
    public Button set_client_account_state;
    public Button create_client_btn;


    public void findClient(ActionEvent actionEvent) {
    }

    public void chosenClient(MouseEvent mouseEvent) {
    }

    public void setClientTariff(ActionEvent actionEvent) {
    }

    public void setClientAddServices(ActionEvent actionEvent) {
    }

    public void setClientName(ActionEvent actionEvent) {
    }

    public void setClientAccountState(ActionEvent actionEvent) {
    }

    public void createClient(ActionEvent actionEvent) {
    }
}
