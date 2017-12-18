/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.portfolios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.Page;

/**
 *
 * @author qa
 */
public class Portfolios extends Page {
    
    private void clickOnAddPortfolios (WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-plus"));
    }
    
    private String sendTextOnFirstNameField (WebDriver driver) {
        return sendtextOnField(driver, By.id("title"));
    }
    
    private void selectDataCategories (WebDriver driver){
        WebElement data = waitForElementClickability(driver, By.className("btn-group"));
        Select dataCategories = new Select(data);
        dataCategories.selectByValue("20");
    }
    
    private String sendtextOnCharacteristic1Field (WebDriver driver) {
        return sendtextOnField(driver, By.id("characteristic1"));
    }
    
}
