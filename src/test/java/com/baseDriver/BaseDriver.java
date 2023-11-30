package com.baseDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BaseDriver {

    private static final ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public static WebDriver initializeBrowser() {
        List<String> browsers = Arrays.asList("chrome", "edge");
        String randomBrowser = browsers.get(new Random().nextInt(browsers.size()));

        if (randomBrowser.equalsIgnoreCase("chrome")) {
            tdriver.set(new ChromeDriver());
        } else if (randomBrowser.equalsIgnoreCase("edge")) {
            tdriver.set(new EdgeDriver());
        }

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        return getDriver();
    }

    public static WebDriver getDriver() {
        return tdriver.get();
    }
}