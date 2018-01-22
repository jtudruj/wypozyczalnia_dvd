package com.rzonca.barbara.zaliczenie.model;

import com.rzonca.barbara.zaliczenie.errors.DiscException;
import com.rzonca.barbara.zaliczenie.errors.DiscExceptionType;

public class DiscModel {
    private String title;
    private String lender;
    private String lendDate;
    private String additionalInfo;

    public DiscModel(String title, String lender, String lendDate, String additionalInfo) {
        this.title = title;
        this.lender = lender;
        this.lendDate = lendDate;
        this.additionalInfo = additionalInfo;
    }

    public DiscModel(String[] parameters) throws DiscException {
        if (parameters == null || parameters.length != 4) {
            throw new DiscException(DiscExceptionType.INVALID_NUMBER_OF_PARAMETERS);
        }
        this.title = parameters[0];
        this.lender = parameters[1];
        this.lendDate = parameters[2];
        this.additionalInfo = parameters[3];
    }

    public DiscModel(String parametersString) throws DiscException {
        this(parametersString.split(";"));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public String getLendDate() {
        return lendDate;
    }

    public void setLendDate(String lendDate) {
        this.lendDate = lendDate;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public boolean containsText(String text) {
        return title.toLowerCase().contains(text.toLowerCase())
                || lender.toLowerCase().contains(text.toLowerCase())
                || lendDate.toLowerCase().contains(text.toLowerCase())
                || additionalInfo.toLowerCase().contains(text.toLowerCase());
    }

    @Override
    public String toString() {
        return title + ";" +
                lender  + ";" +
                lendDate  + ";" +
                additionalInfo;
    }
}
