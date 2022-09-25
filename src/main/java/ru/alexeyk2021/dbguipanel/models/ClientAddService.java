package ru.alexeyk2021.dbguipanel.models;

import java.util.Date;

public class ClientAddService {
    private int clientAddServiceId;
    private int addServiceId;
    private int clientId;
    private Date finishDate;

    public ClientAddService(int clientAddServiceId, int addServiceId, int clientId, Date finishDate) {
        this.clientAddServiceId = clientAddServiceId;
        this.addServiceId = addServiceId;
        this.clientId = clientId;
        this.finishDate = finishDate;
    }

    public int getClientAddServiceId() {
        return clientAddServiceId;
    }

    public int getAddServiceId() {
        return addServiceId;
    }

    public int getClientId() {
        return clientId;
    }

    public Date getFinishDate() {
        return finishDate;
    }
}
