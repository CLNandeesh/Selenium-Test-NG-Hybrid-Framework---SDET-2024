package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class MultiSelectDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Multi Select
        try {
            Select s = new Select(driver.findElement(By.id("option-droup-demo")));
            System.out.println(s.isMultiple());
            s.deselectAll();
            s.selectByValue("Bootstrap");
            System.out.println(s.getFirstSelectedOption().getText());



//            List<WebElement> l = s.getAllSelectedOptions();
//            l.stream().map(x -> x.getText()).forEach(x -> System.out.println("Multi Value is: " + x));
//
//            s.deselectAll();
//
//            List<WebElement> l2 = s.getAllSelectedOptions();
//            l2.stream().map(x -> x.getText()).forEach(x -> System.out.println("Multi Value is: " + x));
//
//            List<WebElement> li = s.getOptions();
//            li.stream().map(x -> x.getText()).forEach(x -> System.out.println("Value is:" + x));
        } catch (Exception e) {
            System.out.println(e);
        }

        Thread.sleep(5000);
       // driver.quit();
    }
}
