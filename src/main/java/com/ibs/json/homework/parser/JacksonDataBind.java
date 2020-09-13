package com.ibs.json.homework.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibs.json.homework.entity.Company;

import java.io.File;
import java.io.IOException;


public class JacksonDataBind {
    public static Company[] parseJson(String path){
        ObjectMapper objectMapper = new ObjectMapper();

       Company[] companies = null;

        try {
            companies = objectMapper.readValue(new File(path), Company[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return companies;
    }
}
