package org.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLoginLinkPresent()) {
            app.getUser().click(By.xpath("/button[contains(.,'Sign Out')]"));
        }

        app.getUser().login();
        app.getContact().addContact();
    }

    @Test
    public void removeContactPositiveTest() {
        int sizeBefor = app.getContact().sizeOfContacts();
        //click on contact card - .contact-item_card__2SOIM -css
        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        //assert contact is Removed
        Assert.assertEquals(sizeAfter, sizeBefor - 1);

    }


    }


