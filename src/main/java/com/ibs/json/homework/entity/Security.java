package com.ibs.json.homework.entity;

import java.util.Date;

public class Security {

    private int codeOfSecurity;
    private int id;
    private Date expirationDate;
    private String currency;

    public Security(int codeOfSecurity, int id, Date expirationDate, String currency) {
        this.codeOfSecurity = codeOfSecurity;
        this.id = id;
        this.expirationDate = expirationDate;
        this.currency = currency;
    }

    public Security() {
    }

    public int getCodeOfSecurity() {
        return codeOfSecurity;
    }

    public void setCodeOfSecurity(int codeOfSecurity) {
        this.codeOfSecurity = codeOfSecurity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Security{" +
                "id=" + codeOfSecurity +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
