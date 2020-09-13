package com.ibs.json.homework.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Company {

    private String name;
    private String address;
    private String phoneNumber;
    private String inn;
    private String ogrn;
    private ArrayList<Security>securities;
    private Date foundationDate;

    public Company() {
    }

    public Company(String name, String address, String phoneNumber, String inn, String ogrn, ArrayList<Security> securities, String foundationDate) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inn = inn;
        this.ogrn = ogrn;
        this.securities = securities;
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        try {
            this.foundationDate = ft.parse(foundationDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public ArrayList<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(ArrayList<Security> securities) {
        this.securities = securities;
    }

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", inn='" + inn + '\'' +
                ", ogrn='" + ogrn + '\'' +
                ", securities=" + securities +
                ", foundationDate=" + foundationDate +
                '}';
    }
}
