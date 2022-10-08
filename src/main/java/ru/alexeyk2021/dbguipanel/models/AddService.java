package ru.alexeyk2021.dbguipanel.models;

import javax.persistence.*;

public class AddService {
    private int addServiceId;
    private String name;
    private double cost;
    private String description;
    private double internetSize;
    private int minutesSize;
    private int smsSize;

    public AddService(int addServiceId, String name, double cost, String description, double internetSize, int minutesSize, int smsSize) {
        this.addServiceId = addServiceId;
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.internetSize = internetSize;
        this.minutesSize = minutesSize;
        this.smsSize = smsSize;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public double getInternetSize() {
        return internetSize;
    }

    public int getMinutesSize() {
        return minutesSize;
    }

    public int getSmsSize() {
        return smsSize;
    }
}
