package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class BrowserWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();

        while (it.hasNext()) {
            String handle = it.next();
            driver.switchTo().window(handle);

            String title = driver.getTitle();
            System.out.println(title);

            if (title.equalsIgnoreCase("Human Resources Management Software | OrangeHRM")) {
                Thread.sleep(3000);
                driver.findElement(By.xpath("(//button[text()='Book a Free Demo'])[2]")).click();
                Thread.sleep(3000);
                String text = driver.findElement(By.xpath("//h1[contains(text(),'Manage Your People and Operations')]")).getText();
                System.out.println("String Text: " + text);
            }


        }
        driver.quit();
    }
}
