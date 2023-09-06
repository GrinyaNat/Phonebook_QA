package org.ait.phonebook;

import org.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (app.getUser().isLoginLinkPresent()){
            app.getUser().click(By.xpath("/button[contains(.,'Sign Out')]"));

        }
        //click on Login link - a:nth-child(4) -css
        app.getUser().clickLoginLink();
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().fillLoginRegistrationForm(new User().setEmail("Kicun@gmail.com")
                .setPassword("Zarik2010!"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert Sign Out button present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }@Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().fillLoginRegistrationForm(new User().setPassword("Zarik2010!"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert Sign Out button present
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
