package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynamicTableWithNavigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        // WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://makeseleniumeasy.com/2020/05/09/storing-web-table-with-pagination-data-into-list-of-map-java/");

        String text = driver.findElement(By.xpath("//div[contains(text(),'Showing')]")).getText();
//        String pageNumber = text.substring((text.indexOf("of"))+2, text.indexOf(" ent"));
//        System.out.println("page Number is" + pageNumber);
        int pageNumber = Integer.parseInt(text.substring((text.indexOf("of")) + 2, text.indexOf(" ent")).trim());
        System.out.println(pageNumber);

        printdata(driver);
        System.out.println("**********************************************************************");
        for (int i = 2; i <pageNumber; i++) {
            driver.findElement(By.xpath("//a[normalize-space()='" + i + "']")).click();
            Thread.sleep(2000);
            System.out.println("**********************************************************************");
            printdata(driver);
        }
        // printdata(driver);


        driver.quit();


    }

    public static void printdata(WebDriver driver) {
        List<WebElement> list = driver.findElements(By.xpath("(//table[@id='dtBasicExample'])[1]//tbody/tr"));
        int rowCount = list.size();

        for (int i = 1; i <= rowCount; i++) {
            int cellCount = driver.findElements(By.xpath("(//table[@id='dtBasicExample'])[1]//tbody/tr[" + i + "]/td")).size();
            for (int j = 1; j <= cellCount; j++) {
                String data = driver.findElement(By.xpath("(//table[@id='dtBasicExample'])[1]//tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.print(data + "\t");
            }
            System.out.println();
        }
    }
}
