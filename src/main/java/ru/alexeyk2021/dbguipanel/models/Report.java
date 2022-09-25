package ru.alexeyk2021.dbguipanel.models;

import java.util.Date;

public class Report {
    private int reportId;
    private int categoryId;
    private Date finish_date;
    private boolean result;
    private String description;

    public Report(int reportId, int categoryId, Date finish_date, boolean result, String description) {
        this.reportId = reportId;
        this.categoryId = categoryId;
        this.finish_date = finish_date;
        this.result = result;
        this.description = description;
    }

    public int getReportId() {
        return reportId;
    }

    public int getCategoryId() {
        return categoryId;
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
