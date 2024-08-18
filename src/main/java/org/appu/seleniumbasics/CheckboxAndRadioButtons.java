package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CheckboxAndRadioButtons {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        System.out.println("****Checkbox*****");
//        WebElement daysCheckbox = driver.findElement(By.id("sunday"));
//        System.out.println(daysCheckbox.isSelected());
//        daysCheckbox.click();
//        System.out.println(daysCheckbox.isSelected());

        //To select all checkbox and count it
        List<WebElement> allCheckbox = driver.findElements(By.xpath("//*[@type='checkbox']"));
        System.out.println("Total number of checkboxes: "+allCheckbox.size());
        for (WebElement checkBox : allCheckbox) {
            checkBox.click();
        }
//
//        System.out.println("****Radio Button*****");
//        WebElement genderRadiobutton = driver.findElement(By.id("female"));
//        System.out.println(genderRadiobutton.isSelected());
//        genderRadiobutton.click();
//        System.out.println(genderRadiobutton.isSelected());
        Thread.sleep(3000);
        driver.quit();


    }
}
