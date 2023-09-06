package org.ait.phonebook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isAlertPresent() { //class 'Alert'
        Alert alert = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.alertIsPresent());
        if (alert ==null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return  true;
        }

    }

    public void clickLoginLink() {
        click(By.cssSelector("a:nth-child(4)"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isLoginLinkPresent() {
        return !isElementPresent(By.cssSelector("a:nth-child(4)"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.cssSelector("[placeholder='Email']"), email);
        //enter password - [placeholder='Password'] -css
        type(By.cssSelector("[placeholder='Password']"), password);
    }
}
