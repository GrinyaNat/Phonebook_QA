package org.ait.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //  driver = new FirefoxDriver();
        driver.get("https://telranedu.web.app");
        //maximize browser window
        driver.manage().window().maximize();
        //set implicit timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean isHomeComponentPresent(){
        return driver.findElements(By.xpath("//h1[text()='Home Component']")).size()>0;
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;//один элемент из списка
    }

    public  boolean isElementPresent2(By locator){
        try {
            driver.findElement(locator);
            return  true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
