package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectDropdownDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Single select
        Select select = new Select(driver.findElement(By.id("colors")));
        select.selectByValue("blue");
        System.out.println("Selected value is:" + select.getFirstSelectedOption());

        List<WebElement> list = select.getOptions();
        list.stream().map(s -> s.getText()).forEach(s -> System.out.println("Value is: " + s));


        driver.quit();
    }
}
