/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.contactInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUtil.PageUtilities;
import pages.Page;

/**
 *
 * @author qa
 */
public class ContactInfoPages extends Page{
    
    private void clickOnAddContactInfo (WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-plus"));
    }
    
    private String sendtexOnLocationField (WebDriver driver) {
        return sendtextOnField(driver, By.id("location"));
    }
    
    private String sendTextOnAddressField (WebDriver driver) {
        return sendtextOnField(driver, By.id("address"));
    }
    

    
    
    
}
