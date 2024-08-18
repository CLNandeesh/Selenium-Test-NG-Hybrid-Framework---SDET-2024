package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class CloseSpecificBrowser {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement linkElement = driver.findElement(By.linkText("OrangeHRM, Inc"));
        linkElement.click();

        Set<String> handles = driver.getWindowHandles();
        //handles.stream().map(x -> driver.switchTo().window(x).getTitle()).forEach(s -> System.out.println(s));

        for (String s : handles) {
            if (driver.switchTo().window(s).getTitle().equals("OrangeHRM")) {
                driver.close();
            }
        }
    }
}
