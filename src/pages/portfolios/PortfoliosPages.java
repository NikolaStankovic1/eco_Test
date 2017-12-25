/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.portfolios;

import domen.Portfolios;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.Page;

/**
 *
 * @author qa
 */
public class PortfoliosPages extends Page {

    private void clickOnAddPortfolios(WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-plus"));
    }

    private String sendTextOnTitleField(WebDriver driver) {
        return sendtextOnField(driver, By.id("title"));
    }
   
        private void selectDataCategories(WebDriver driver) {
        WebElement combobox = waitForElementVisibility(driver, By.id("data_categories"));
        Select data = new Select(combobox);
        data.selectByValue("19");
        data.selectByValue("17");
}

    private String sendtextOnCharacteristic1Field(WebDriver driver) {
        return sendtextOnField(driver, By.id("characteristic1"));
    }

    private String sendTextOnCharacteristic2Field(WebDriver driver) {
        return sendtextOnField(driver, By.id("characteristic2"));
    }

    private String sendTextOnDescriptionField(WebDriver driver) {
        return sendtextOnField(driver, By.id("description"));
    }

    private void sendPhoto(WebDriver driver) {
        sendTextOnField(driver, By.id("portfolio_photo"), System.getProperty("user.dir") + "/src/images/Focal Aria 926.jpg");
    }

    private void editPhoto(WebDriver driver) {
        sendTextOnField(driver, By.id("portfolio_photo"), System.getProperty("user.dir") + "/src/images/Focal Elear.jpg");
    }

    public int getIdFromPortfolios(WebDriver driver) {
        return getIdFromLastRow(driver, "data-portfolio-id");
    }

    private Portfolios commonSteps(WebDriver driver, String text) {
        Portfolios port = new Portfolios();
        if (text.equals("create")) {
            clickOnAddPortfolios(driver);
        } else {
            editLastRow(driver, By.className("glyphicon-pencil"));
        }

        port.setTitle(sendTextOnTitleField(driver));
        selectDataCategories(driver);
        port.setCharacteristic1(sendtextOnCharacteristic1Field(driver));
        port.setCharacteristic2(sendTextOnCharacteristic2Field(driver));
        port.setDescription(sendTextOnDescriptionField(driver));

        if (text.equals("create")) {
            sendPhoto(driver);
        } else {
            editPhoto(driver);
        }

        clickOnElement(driver, By.id("new_portfolio_submit"));
        port.setId(getIdFromPortfolios(driver));

        return port;
    }

    public Portfolios createPortfolios(WebDriver driver) {
        return commonSteps(driver, "create");
    }

    public Portfolios editPortfolios(WebDriver driver) {
        return commonSteps(driver, "edit");
    }

    public Portfolios deletePortfolios (WebDriver driver) {
        Portfolios port = new Portfolios();
        deleteLastRow(driver);
        return port;
    }

}
