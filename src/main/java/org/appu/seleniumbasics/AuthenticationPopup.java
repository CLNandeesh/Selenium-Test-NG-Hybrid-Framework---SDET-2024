package org.appu.seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AuthenticationPopup {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
