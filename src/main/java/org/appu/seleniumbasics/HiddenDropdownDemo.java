package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HiddenDropdownDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        // driver.findElement(By.xpath("(//button[@type='submit']")).click();
        ele.click();

        driver.findElement(By.xpath("//span[text()='PIM']")).click();

        driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div/div/div/div")).click();

        List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'oxd-select-option')]/span"));
        System.out.println("Total options are: " + list.size());
        list.stream().map(x -> x.getText()).forEach(x -> System.out.println("Option is: " + x));

        //Selecting element
        for (WebElement e : list) {
            if (e.getText().equalsIgnoreCase("Automaton Tester")) {
                e.click();
                break;
            }
        }
        Thread.sleep(4000);
        driver.quit();
    }
}
