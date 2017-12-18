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
 * @author Stankovic
 */
public class LogoutPage extends Page {
    
    public void logOut (WebDriver driver){
        clickOnElement(driver, By.className("dropdown-toggle"));
        clickOnElement(driver, By.className("fa-sign-out"));
    }
    
}
