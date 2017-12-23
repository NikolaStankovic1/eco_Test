/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.categories;

import domen.Categorie;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Page;

/**
 *
 * @author Stankovic
 */
public class CategoriesPages extends Page {
    
    private void clickOnAddCategory (WebDriver driver){
        clickOnElement(driver, By.className("glyphicon-plus"));
    }
    
    private String sendTextOnNameField (WebDriver driver) {
        return sendtextOnField(driver, By.id("name"));
    }
    
    private String sendTextOnDescriptionField (WebDriver driver){
        return sendtextOnField(driver, By.id("description"));
    }
    
    public int getIdFromCategories(WebDriver driver) {
        return getIdFromLastRow(driver, "data-portfolio-id");
    }
    
    private Categorie commonSteps(WebDriver driver, String text) {
        Categorie cat = new domen.Categorie();
        if (text.equals("create")) {
            clickOnAddCategory(driver);
        } else  {
            editLastRow(driver, By.className("glyphicon-pencil"));
        }

        cat.setName(sendTextOnNameField(driver));
        cat.setDescription(sendTextOnDescriptionField(driver));
        
        
        clickOnElement(driver, By.id("new_category_submit"));
        cat.setId(getIdFromCategories(driver));

        return cat;  
    }
    
    public Categorie createCategories(WebDriver driver) {
          return  commonSteps(driver, "create");
}

    public Categorie editCategories (WebDriver driver) {
            return commonSteps(driver, "edit");
}

    public Categorie deleteCategories(WebDriver driver) {
        Categorie cat = new domen.Categorie();
        deleteLastRow(driver);
        return cat;
    }
}
