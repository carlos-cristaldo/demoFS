package com.prueba.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperty {

    private static final String DIR = "src/test/resources/config.properties";

    public static String getProperties(String data){

        Properties properties = new Properties();

        try {
            FileInputStream file = new FileInputStream(DIR);
            properties.load(file);
            file.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return properties.getProperty(data);
    }
}
