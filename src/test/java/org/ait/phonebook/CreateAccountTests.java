package org.ait.phonebook;

import org.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    //preconditPrecondition: if User should be logged out
    @BeforeMethod
    public void ensurePrecondition(){
        if (app.getUser().isAlertPresent()){
            app.getUser().clickOnSignOutButton();

        }
        //click on Login link - a:nth-child(4) -css
        app.getUser().clickLoginLink();
    }

    @Test
    public  void existedUserRegistrationNegativeTest() {
        //enter email - [placeholder='Email'] -css
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("Kicun@gmail.com")
                .setPassword("Zarik2010!"));

        //click on Registration button - //button[text()='Registration']-xpath
        app.getUser().clickOnRegistrationButton();

        //assert Sign out button displayed - //button[contains(.,'Sign Out')] - xpath
        //Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));

        //assert alert is appeared
        Assert.assertTrue(app.getUser().isAlertPresent());

    }


}
