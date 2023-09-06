package org.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (isLoginLinkPresent()){
            click(By.xpath("/button[contains(.,'Sign Out')]"));

        }
        //click on Login link - a:nth-child(4) -css
        clickLoginLink();
    }

    @Test
    public void loginPositiveTest() {
        fillLoginRegistrationForm("Kicun@gmail.com", "Zarik2010!");
        //click on Login button
        click(By.xpath("//button[.='Login']"));
        //assert Sign Out button present
        Assert.assertTrue(isElementPresent2(By.xpath("/button[contains(.,'Sign Out')]")));


    }
}
