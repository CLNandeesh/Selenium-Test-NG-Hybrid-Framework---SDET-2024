package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FrameDemo {
    private static String appu;

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("appu");
        Thread.sleep(3000);

        driver.switchTo().defaultContent();

    }
}
