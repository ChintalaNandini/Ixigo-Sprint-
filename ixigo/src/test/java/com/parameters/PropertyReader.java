package com.parameters;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static Properties readProperty() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\PropertiesFiles\\profile.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}