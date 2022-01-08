package com.qamer91.Utilities;

import org.openqa.selenium.Platform;
import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class DriverHandler {

    private static Platform platform;
    ChromeDriver driver;

    //Setting WebDriver/Chrome driver version using WebDriverManager

    private void setWebDriver(Platform platform) {

        switch (platform) {
            case MAC:
                WebDriverManager.chromedriver().operatingSystem(OperatingSystem.MAC).setup();
                break;
            case WINDOWS:
                WebDriverManager.chromedriver().operatingSystem(OperatingSystem.WIN).setup();
                break;
            case LINUX:
                WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
                break;
            default:
                System.out.println("WebDriver has not been set! There is a problem!\n");
                break;
        }
    }


    //Get current platform, will use to get correct webdriver version
    public static Platform getCurrentPlatform() {
        System.out.println("Ana f getCurrentPlatform");
        if (platform == null) {
            String operatingSystem = System.getProperty("os.name").toLowerCase();
            if (operatingSystem.contains("win")) {
                System.out.println("Ana windows");
                platform = Platform.WINDOWS;
            } else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("aix")) {
                System.out.println("Ana linux");
                platform = Platform.LINUX;
            } else if (operatingSystem.contains("mac")) {
                platform = Platform.MAC;
            }
            System.out.println("M3rftsh eh el OS");
        }
        return platform;
    }

    public ChromeDriver createDriver() throws IOException {
        System.setProperty("java.awt.headless", "true");

        System.out.println("Ya Mosahel");
        setWebDriver(getCurrentPlatform());

        System.out.println("Ya Molayen");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--incognito");
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.setCapability("applicationCacheEnabled", false);
        driver  = new ChromeDriver(options);
        System.out.println("Ya Karim");
        return driver;

    }
}
