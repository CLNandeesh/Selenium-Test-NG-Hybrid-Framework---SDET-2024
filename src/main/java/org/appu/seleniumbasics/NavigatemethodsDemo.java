package org.appu.seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigatemethodsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.navigate().to("https://www.facebook.com");
        System.out.println(driver.getTitle());
        driver.navigate().back();
        System.out.println(driver.getTitle());
        driver.navigate().forward();
        System.out.println(driver.getTitle());
        driver.navigate().refresh();
        driver.quit();

    }
}
