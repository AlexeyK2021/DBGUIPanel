package ru.alexeyk2021.dbguipanel.models;

public class Category {
    private int categoryId;
    private String name;

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
