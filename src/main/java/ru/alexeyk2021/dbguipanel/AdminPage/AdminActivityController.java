package ru.alexeyk2021.dbguipanel.AdminPage;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import ru.alexeyk2021.dbguipanel.managers.DbManager;
import ru.alexeyk2021.dbguipanel.models.AddService;
import ru.alexeyk2021.dbguipanel.models.Client;

import java.util.ArrayList;

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
        ObservableList<String> likeNumbers = FXCollections.observableList(DbManager.getInstance().findByPartNumber(find_client_text.getText()));
        clients_list_view.setItems(likeNumbers);
    }

    public void chosenClient(MouseEvent mouseEvent) {
        MultipleSelectionModel<String> phoneNumberSelectionModel = clients_list_view.getSelectionModel();
        phoneNumberSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                updateData(t1);
            }
        });

    }

    public void createClient(ActionEvent actionEvent) {

    }

    public void setClientTariff(ActionEvent actionEvent) {

    }

    public void setClientAddServices(ActionEvent actionEvent) {

    }

    public void setClientName(ActionEvent actionEvent) {

    }

    public void setClientAccountState(ActionEvent actionEvent) {

    }

    private void updateData(String newValue) {
        Client chosenClient = DbManager.getInstance().findByPhoneNumber(newValue);
        client_name.setText(chosenClient.getPersonalInfo().getFullName());
        client_account_state.setText(Boolean.toString(chosenClient.accountState()));
        client_balance.setText(Double.toString(chosenClient.getBalance()));
        client_tariff.setText(chosenClient.getTariff().getName());

        ArrayList<String> adds = new ArrayList<>();
        for (AddService add : chosenClient.getAddServiceList()) {
            adds.add(add.getName());
        }

        ObservableList<String> addServices = FXCollections.observableList(adds);
        client_add_services.setItems(addServices);
    }


}
