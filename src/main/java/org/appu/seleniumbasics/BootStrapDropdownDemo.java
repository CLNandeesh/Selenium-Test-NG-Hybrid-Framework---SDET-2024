package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class BootStrapDropdownDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();


        //Multi Select options
        List<String> list = Arrays.asList("Oracle", "MySQL", "Java", "Python");
        String text = "C#";
        String xp = "//input[contains(@value,'"+text+"')]";
        System.out.println(xp);

        for (String s : list) {
            String newXp=xp.replace(text, s);
            System.out.println("New Xpath is: "+newXp);
            driver.findElement(By.xpath(newXp)).click();
            Thread.sleep(3000);
        }

        driver.quit();
    }
}
