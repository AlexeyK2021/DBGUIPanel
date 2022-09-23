package ru.alexeyk2021.dbguipanel.models;

import java.util.Date;

public class Report {
    private int reportId;
    private Category category;
    private Date finish_date;
    private boolean result;
    private String description;

    public Report(int reportId, Category category, Date finish_date, boolean result, String description) {
        this.reportId = reportId;
        this.category = category;
        this.finish_date = finish_date;
        this.result = result;
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public boolean isResult() {
        return result;
    }

    public String getDescription() {
        return description;
    }
}
