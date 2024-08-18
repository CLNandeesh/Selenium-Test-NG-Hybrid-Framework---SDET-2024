package org.appu.seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Test case:
//Open Browser
//Open URL "https://demo.opencart.com/"
//Validate Title is "Your Store"
//Close Broswer

public class BrowserOperation {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        if (title.equals("Your Store")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        driver.quit();

        WebDriver driver1 = new FirefoxDriver();
        driver.get("https://demo.opencart.com/");
        String title1 = driver1.getTitle();
        System.out.println("Title is: " + title);
        if (title.equals("Your Store")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        driver.quit();


    }
}
