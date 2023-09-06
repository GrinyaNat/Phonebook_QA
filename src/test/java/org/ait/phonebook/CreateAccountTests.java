package org.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    //preconditPrecondition: if User should be logged out
    @BeforeMethod
    public void ensurePrecondition(){
        if (isLoginLinkPresent()){
            clickOnSignOutButton();

        }
        //click on Login link - a:nth-child(4) -css
        clickLoginLink();
    }

    @Test
    public  void existedUserRegistrationNegativeTest() {
        //enter email - [placeholder='Email'] -css
        fillLoginRegistrationForm("Kicun@gmail.com", "Zarik2010!");

        //click on Registration button - //button[text()='Registration']-xpath
        clickOnRegistrationButton();

        //assert Sign out button displayed - //button[contains(.,'Sign Out')] - xpath
        //Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));

        //assert alert is appeared
        Assert.assertTrue(isAlertPresent());

    }


}
