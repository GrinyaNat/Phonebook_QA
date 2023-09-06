package org.ait.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        if (isLoginLinkPresent()){
            click(By.xpath("/button[contains(.,'Sign Out')]"));

        }
        //click on Login link - a:nth-child(4) -css
        clickLoginLink();
        fillLoginRegistrationForm("Kicun@gmail.com", "Zarik2010!");
        //click on Login button
        click(By.xpath("//button[.='Login']"));
        //click on add Link - [href='/add'] -css
    }

    @Test
    public void addContactPositiveTest() {
        //enter all input fields in contact form - input:nth-child(1) - css
        type(By.cssSelector("input:nth-child(1)"), "Yarik");
        type(By.cssSelector("input:nth-child(2)"), "Yurik");
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        type(By.cssSelector("input:nth-child(4)"), "yarik@gm.com");
        type(By.cssSelector("input:nth-child(5)"), "Koblenz");
        type(By.cssSelector("input:nth-child(6)"), "goalkeeper");
        //click on Save button
        click(By.cssSelector(".add_form__2rsm2 button"));
        //assert contact is added by text
        Assert.assertTrue(isContactAdded("Karl"));
    }
    @AfterMethod
    public void postCondition(){
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //click on Remove button - //button[.='Remove'] - xpath
        click(By.xpath("//button[.='Remove']"));
    }

    @Override
    public boolean isContactAdded() {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el:contacts){
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }
}
