/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUtil.PageUtilities;

/**
 *
 * @author qa
 */
public class Page {
    
    
    public WebElement waitForElementVisibility(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public WebElement waitForElementClickability(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }
    
    public String sendTextOnField (WebDriver driver, By locator, String text){
        WebElement title = waitForElementVisibility(driver, locator);
        title.clear();
        title.sendKeys(text);
        return text;
    }
    
    public String sendtextOnField ( WebDriver driver, By locator) {
        WebElement element = waitForElementVisibility(driver, locator);
        element.clear();
        String text = PageUtilities.getRandomText();
        element.sendKeys(text);
        return text;
    }

    
    public void clickOnElement (WebDriver driver , By locator){
        WebElement element = waitForElementClickability(driver, locator);
        element.click();
    }
    
    private WebElement findLastRow (WebDriver driver){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        waitForElementVisibility(driver, By.tagName("table"));
//        driver.findElement(By.tagName("table"));
        WebElement table = driver.findElement(By.tagName("tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement lastRow = rows.get(rows.size() - 1);
        return lastRow;
    }
    
    public void editLastRow (WebDriver driver, By locator){
        WebElement lastRow = findLastRow(driver);
        WebElement editButton = lastRow.findElement(locator);
        editButton.click();
    }
    
    public void clickOnDeleteLastRow (WebDriver driver, By locator){
        WebElement lastRow = findLastRow(driver);
        WebElement deleteButton = lastRow.findElement(locator);
        deleteButton.click();
    }
    
    public int getIdFromLastRow(WebDriver driver, String attributeName){
        WebElement lastRow = findLastRow(driver);
        String id = lastRow.getAttribute(attributeName);
        return Integer.valueOf(id);
    }
    
    public void deleteLastRow (WebDriver driver){
        clickOnDeleteLastRow(driver, By.className("glyphicon-trash"));
        waitForElementVisibility(driver, By.className("modal-content"));
        clickOnElement(driver, By.className("btn-danger"));
    }
 
    public int sendNumberOnField ( WebDriver driver, By locator) {
        WebElement element = waitForElementVisibility(driver, locator);
        element.clear();
        int number = PageUtilities.getRandomInteger();
        element.sendKeys("" + number);
        return number;
    }
    
    public int sendNumberOnField (WebDriver driver, By locator, int number){
        WebElement element = waitForElementVisibility(driver, locator);
        element.clear();
        element.sendKeys("" + number);
        return number;
    }
    
   
    
}
