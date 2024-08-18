package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutosugestiveDropwdownDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.name("q")).sendKeys("selenium");
        List<WebElement> list=driver.findElements(By.xpath("//ul[@class='G43f7e']//li//span"));

        for(WebElement e:list)
        {
//            if(!(e.getText().isEmpty()))
//            {
//                System.out.println(e.getText());
//            }
            if(e.getText().equalsIgnoreCase("selenium testing"))
            {
                e.click();
                break;
            }
        }

        driver.quit();
    }
}
