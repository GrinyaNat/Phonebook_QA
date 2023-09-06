package org.ait.phonebook.fw;

import org.ait.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        type(By.cssSelector("input:nth-child(2)"), contact.getSurname());
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        type(By.cssSelector("input:nth-child(5)"), contact.getAdress());
        type(By.cssSelector("input:nth-child(6)"), contact.getDesc());
    }

    public void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public boolean isContactAdded(CharSequence text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el : contacts) {
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) ;
        return driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void addContact() {
        clickLoginLink();
        fillContactForm(new Contact()
                .setName("Yarik")
                .setSurname("Yurik")
                .setPhone("1234567890")
                .setEmail("yarik@gm.com")
                .setAdress("Koblenz")
                .setDesc("goalkeeper"));
        clickOnLoginButton();
    }
}
