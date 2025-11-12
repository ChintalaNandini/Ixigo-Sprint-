package com.stepDefinitionTestNG;

import com.setup.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    Properties prop = new Properties();

    @Before
    public void setUp() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/PropertiesFiles/Profile.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String sourceUrl = prop.getProperty("sourceUrl");

        WebDriverManager.chromedriver().setup();
        BaseSteps.driver = new ChromeDriver();
        BaseSteps.driver.manage().window().maximize();
        BaseSteps.driver.get(sourceUrl);
    }

//    @After
//    public void tearDown() {
//        if (BaseSteps.driver != null) {
//            BaseSteps.driver.quit();
//        }
//    }
}












































































