/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.users;

import domen.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUtil.PageUtilities;
import pages.Page;

/**
 *
 * @author Stankovic
 */
public class UsersPages extends Page {
    
    private void clickOnAddUser (WebDriver driver){
        clickOnElement(driver, By.className("btn-default"));
    }
    
    private String sendTextOnUsernameField (WebDriver driver){
        return sendtextOnField(driver, By.id("username"));
    }
    
    private String sendTextOnFirtstNameField (WebDriver driver){
//        return sendtextOnField(driver, By.id("first_name"));
        return sendTextOnField(driver, By.id("first_name"), PageUtilities.getRandomFirstName());
    }
    
    private String sendTextOnLastNameField (WebDriver driver){
//        return sendtextOnField(driver, By.id("last_name"));
        return sendTextOnField(driver, By.id("last_name"), PageUtilities.getRandomLastName());
    }
    
    private String sendTextOnEmailField (WebDriver driver) {
        return sendTextOnField(driver, By.id("email"), PageUtilities.getRandomEmail());
    }
    
    private int getIdFromUsers (WebDriver driver){ 
        return getIdFromLastRow(driver, "data-user-id");
    }
    
    private Users commonSteps (WebDriver driver, String text) {
        Users u = new Users();
        
        if (text.equals("create")){
            clickOnAddUser(driver);
        } else {
            waitForElementVisibility(driver, By.className("table-striped"));
            editLastRow(driver, By.className("glyphicon-pencil"));
        }
        u.setUsername(sendTextOnUsernameField(driver));
        u.setFirstName(sendTextOnFirtstNameField(driver));
        u.setLastName(sendTextOnLastNameField(driver));
        u.setEmail(sendTextOnEmailField(driver));

        clickOnElement(driver, By.className("btn-success"));
        
                 
        return u;
    }
    
    public Users createUsers (WebDriver driver){

        return commonSteps(driver, "create");
    }
    
    public Users editUsers (WebDriver driver){
        Users u = new Users();
        commonSteps(driver, "edit");
        waitForElementVisibility(driver, By.tagName("tbody"));
        u.setId(getIdFromUsers(driver));
        return u;

    }
    
    public Users deleteUsers (WebDriver driver){
        Users u = new Users();
        deleteLastRow(driver);
        return u;
    }
    
    
}

