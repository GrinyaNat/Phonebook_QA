package org.ait.phonebook;

import org.ait.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        if (app.getUser().isLoginLinkPresent()){
            app.getUser().click(By.xpath("/button[contains(.,'Sign Out')]"));

        }
        //click on Login link - a:nth-child(4) -css
        app.getContact().addContact();
        //click on add Link - [href='/add'] -css
        app.getContact().clickOnAddLink();
    }

    @Test
    public void addContactPositiveTest() {
        //enter all input fields in contact form - input:nth-child(1) - css
        app.getContact().fillContactForm(new Contact()
                .setName("Yarik")
                .setSurname("Yurik")
                .setPhone("1234567890")
                .setEmail("yarik@gm.com")
                .setAdress("Koblenz")
                .setDesc("goalkeeper"));
        //click on Save button
        app.getContact().clickOnSaveButton();
        //assert contact is added by text
        Assert.assertTrue(app.getContact().isContactAdded("Karl"));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }

}
