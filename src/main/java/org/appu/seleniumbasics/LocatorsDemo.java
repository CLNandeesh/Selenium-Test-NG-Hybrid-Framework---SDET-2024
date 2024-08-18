package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();

        //driver.findElement(By.name("search")).sendKeys("Mobile");

       // List<WebElement> elements = driver.findElements(By.className("nav-item"));
//        for(WebElement element:elements)
//        {
//            System.out.println("Option is: "+element.getText());
//
//        }
       // elements.forEach(x -> System.out.println(x.getText()));

        List<WebElement> images = driver.findElements(By.tagName("img"));
        images.stream().map(x -> x.getAttribute("src")).forEach(x -> System.out.println(x));

        driver.findElement(By.cssSelector(""));

    }
}
