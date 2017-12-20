/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author qa
 */
public class LoginPage extends Page{
    
//    public HomePage logIn (WebDriver driver){
//        
//        driver.get("http://ecotest.school.cubes.rs/admin_session/login");
//        
//        sendTextOnField(driver, By.name("username"), "admin");
//        sendTextOnField(driver, By.name("password"), "cubesqa");
//        clickOnElement(driver, By.className("btn-block"));
//        
//        return PageFactory.initElements(driver, HomePage.class);
//        
//    }
    
    public HomePage logIn (WebDriver driver, String url, String username, String password ){
        driver.get(url);
        
        sendTextOnField(driver, By.name("username"), username);
        sendTextOnField(driver, By.name("password"), password);
        clickOnElement(driver, By.className("btn-block"));
        
        return PageFactory.initElements(driver, HomePage.class);
    
    }
}
