package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StaticWebtableDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Total no or records
        List<WebElement> table = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
        System.out.println("Total no of Records is: " + table.size());

        //Total no of columns
        System.out.println("Total no of columns: " + driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th")).size());

        List<WebElement> e1 = driver.findElements(By.xpath("//table[@name='BookTable']/tbody//tr[1]/th"));
        for (WebElement w : e1) {
            System.out.print(w.getText() + "\t");
        }
        System.out.println();

        //Read all cell data
        for (int i = 2; i <= table.size(); i++) {
            List<WebElement> e = driver.findElements(By.xpath("//table[@name='BookTable']/tbody//tr[" + i + "]/td"));
            for (WebElement w : e) {
                System.out.print(w.getText() + "\t");
            }
            System.out.println();
        }

        //Read Specific cell data
        System.out.println(driver.findElement(By.xpath("//table[@name='BookTable']/tbody//tr[2]/td[2]")).getText());


        //Print book of author Mukesh
        for (int i = 2; i <= table.size(); i++) {
            List<WebElement> e = driver.findElements(By.xpath("//table[@name='BookTable']/tbody//tr[" + i + "]/td[2]"));
            for (WebElement w : e) {
                if (w.getText().equalsIgnoreCase("Mukesh")) {
                    WebElement s = driver.findElement(By.xpath("//table[@name='BookTable']/tbody//tr[" + i + "]/td[1]"));
                    System.out.println("Book name is: " + s.getText());
                    break;
                }
            }
        }

        List<Integer> list=new ArrayList<>();
        int price=0;
        //Total price of all books
        for (int i = 2; i <= table.size(); i++) {
            List<WebElement> e = driver.findElements(By.xpath("//table[@name='BookTable']/tbody//tr[" + i + "]/td[4]"));
            for (WebElement w : e) {
               String s=w.getText();
               int p=Integer.parseInt(s);
               list.add(p);
               price=price+p;
            }
        }
        System.out.println("Total price is:"+price);

        //To find lowest and highest price
        Collections.sort(list);
        System.out.println("Lowest price is:"+list.get(0));
        System.out.println("Highest price is:"+list.get(list.size()-1));

        driver.quit();
    }
}
