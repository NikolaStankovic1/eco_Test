/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author qa
 */
public class HomePage extends Page{
    
    public void clickOnIndexSlider (WebDriver driver){
        clickOnElement(driver, By.className("fa-sliders"));
    }
    
    public void clickOnPhotoGalleries (WebDriver driver) {
        clickOnElement(driver, By.className("fa-photo"));
    }
    
    public void clickOnUsers (WebDriver driver){
        clickOnElement(driver, By.xpath("//*[@id='side-menu']/li[6]/ul/li[1]/a"));
    }
    
}
