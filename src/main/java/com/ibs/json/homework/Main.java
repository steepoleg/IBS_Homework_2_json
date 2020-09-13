package com.ibs.json.homework;

import com.ibs.json.homework.entity.Company;
import com.ibs.json.homework.entity.Security;
import com.ibs.json.homework.parser.JacksonDataBind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    Company[] companies;
    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int valueSecurities = 0;
        Main main = new Main();
        SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy.MM.dd");

        String path = null;
        System.out.println("Введите путь к json файлу: ");
        try {
            path = consoleReader.readLine();
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        main.companies = JacksonDataBind.parseJson(path);

        System.out.println("Все имеющиеся компании:");
        for (Company company:main.companies) {
            System.out.println(company.getName() + " Дата основания " + formatForDate.format(company.getFoundationDate()));
            System.out.println();
        }
        System.out.println("Все просроченные ценные бумаги:");
        for (Company company:main.companies) {
            for (Security security: company.getSecurities()) {
                Date date = new Date();
                if(security.getExpirationDate().getTime() < date.getTime()){
                    valueSecurities++;
                    System.out.println(security.getCodeOfSecurity() + " " + formatForDate.format(security.getExpirationDate()) + " " +  company.getName());
                }
            }
        }

        System.out.println("Количество просроченных бумаг: " + valueSecurities);
        System.out.println();




        while (true){
            System.out.println("Введите пользовательскую команду: ");

            String request = null;
            try {
                request = consoleReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String currency = null;


            switch (request) {
                case "UAH":
                    currency = "UAH";
                    break;
                case "USD":
                    currency = "USD";
                    break;
                case "GBP":
                    currency = "GBP";
                    break;
                case "EUR":
                    currency = "EUR";
                    break;
                case "JPY":
                    currency = "JPY";
                    break;
                case "CHF":
                    currency = "CHF";
                    break;
                case "CNY":
                    currency = "CNY";
                    break;
                case "RUB":
                    currency = "RUB";
            }

            if(currency != null) {


                System.out.println("Список ценных бумаг, использующих валюту " + currency + ": ");

                for (Company company : main.companies) {
                    for (Security security : company.getSecurities()) {
                        if (security.getCurrency().equals(currency)) {
                            System.out.print("id:" + security.getId());
                            System.out.println(" код " + security.getCodeOfSecurity());
                        }
                    }
                }

                 continue;
            }



            SimpleDateFormat ft1 = new SimpleDateFormat ("dd.MM.yyyy");
            SimpleDateFormat ft2 = new SimpleDateFormat ("dd.MM.yy");
            SimpleDateFormat ft3 = new SimpleDateFormat ("dd/MM/yyyy");
            SimpleDateFormat ft4 = new SimpleDateFormat ("dd/MM/yy");

            Date date = null;

            try {
                date = ft1.parse(request);
            } catch (ParseException e) {
                try {
                     date = ft2.parse(request);
                } catch (ParseException ex) {
                    try {
                         date = ft3.parse(request);
                    } catch (ParseException exc) {
                        try {
                             date = ft4.parse(request);
                        } catch (ParseException e1) {
                            System.out.println("Неверный формат даты!");
                        }
                    }
                }
            }

            System.out.println("Список всех организаций основанных после " + date);
            for (Company company: main.companies) {
                if(company.getFoundationDate().getTime() > date.getTime()){
                    System.out.println(company.getName() + " основана " + formatForDate.format(company.getFoundationDate()));
                }
            }

        }

    }
}
