package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class GetMethodsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String title = driver.getTitle();
        System.out.println("Title is: " + title);

        String currentURL = driver.getCurrentUrl();
        System.out.println("URL is: " + currentURL);

        String handle = driver.getWindowHandle();
        System.out.println("Window Handle is: " + handle);

        WebElement linkElement = driver.findElement(By.linkText("OrangeHRM, Inc"));
        linkElement.click();

        Set<String> handles = driver.getWindowHandles();
        handles.forEach(h -> System.out.println("Handle value is: " + h));

        driver.quit();
    }
}
