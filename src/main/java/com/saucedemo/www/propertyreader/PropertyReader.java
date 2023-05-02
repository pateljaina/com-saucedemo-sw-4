package com.saucedemo.www.propertyreader;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    /*
    Rules for implementing singleton pattern
    1. Make constructor private
    2.Create a static method to get the instance
    3.Create a static member variable
     */
    //Declare the Property reader variable
    private static volatile PropertyReader propInstance;

    //Create private constructor Because of prevent the instantiation of class
    private PropertyReader() {

    }

    /**
     * This method will return instance of PropertyReader class
     *
     * @return
     */
    public static synchronized PropertyReader getInstance() {//inbuilt so you do not get errors
        if (propInstance == null) {
            propInstance = new PropertyReader();
        }
        return propInstance;
    }

    /**
     * This method will read property from property file
     *
     * @param propertyName
     * @return
     */
    public String getProperty(String propertyName) {

        Properties prop = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/propertiesfile/config.properties");
            prop.load(inputStream);
            if (prop.getProperty(propertyName) != null) {
                return prop.getProperty(propertyName);
            }
        } catch (Exception e) {
            System.out.println("Property not found");
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().getProperty("browser"));
        System.out.println(getInstance().getProperty("baseUrl"));
    }

}
