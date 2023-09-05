package org.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest(){
       //driver.findElement(By.xpath("//h1[text()='Home Component']"));
        //System.out.println("Home Component is " + isElementPresent(By
                //.xpath("//h1[text()='Home Component']")));

        Assert.assertTrue(isHomeComponentPresent());

    }

}


