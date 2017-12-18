/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.indexSlider;

import domen.IndexSlider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.Page;

/**
 *
 * @author qa
 */
public class IndexSliderPages extends Page {

    private void clickOnAddIndexSlider(WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-plus"));
    }

    private String sendTextOnTitleField(WebDriver driver) {
        return sendtextOnField(driver, By.id("title"));
    }

    private String sendTextOnDescriptionField(WebDriver driver) {
        return sendtextOnField(driver, By.id("description"));
    }

    private void linkType(WebDriver driver) {
        WebElement link = waitForElementClickability(driver, By.id("link_type"));
        Select linkType = new Select(link);
        linkType.selectByValue("InternalLink");
    }

    private void editLinkType(WebDriver driver) {
        WebElement link = waitForElementClickability(driver, By.id("link_type"));
        Select linkType = new Select(link);
        linkType.selectByValue("ExternalLink");
    }

    private String sendtextOnLinkLabelfield(WebDriver driver) {
        return sendtextOnField(driver, By.id("link_label"));
    }

    private String sendUrlOnLinkUrlField(WebDriver driver) {
        return sendTextOnField(driver, By.id("internal_link_url"), "https\\www.player.rs");
    }

    private String editUrlOnLinkUrlField(WebDriver driver) {
        return sendTextOnField(driver, By.id("external_link_url"), "https\\www.sterlingbymusicman.com");
    }

    private void sendPhoto(WebDriver driver) {
        sendTextOnField(driver, By.id("index_slide_photo"), System.getProperty("user.dir")+ "/src/images/Focal Aria 926.jpg");
    }

    private void editPhoto(WebDriver driver) {
        sendTextOnField(driver, By.id("index_slide_photo"), System.getProperty("user.dir")+ "/src/images/Focal Elear.jpg");
    }

    private void clickOnSave(WebDriver driver) {
        clickOnElement(driver, By.id("new_indexSlide_submit"));
    }

    private IndexSlider commonSteps(WebDriver driver, String text) {
        IndexSlider index = new IndexSlider();
        if (text.equals("create")) {
            clickOnAddIndexSlider(driver);
        } else  {
            editLastRow(driver, By.className("glyphicon-pencil"));
        }

        index.setTitle(sendTextOnTitleField(driver));
        index.setDescription(sendTextOnDescriptionField(driver));
        
        if (text.equals("create")){
            linkType(driver);
            index.setLinkLabel(sendtextOnLinkLabelfield(driver));
            index.setInternalLink(sendUrlOnLinkUrlField(driver));
            sendPhoto(driver);
        } else {
            editLinkType(driver);
            index.setLinkLabel(sendtextOnLinkLabelfield(driver));
            index.setExternalLink(editUrlOnLinkUrlField(driver));
            editPhoto(driver);
        }
        
        clickOnSave(driver);
        index.setId(getIdFromIndexSlider(driver));

        return index;   
        
    }

    public IndexSlider createIndexSlider(WebDriver driver) {
          return  commonSteps(driver, "create");

    }

    public IndexSlider editIndexSlider(WebDriver driver) {
            return commonSteps(driver, "edit");

    }

    public IndexSlider deleteIndexSlider(WebDriver driver) {
        IndexSlider index = new IndexSlider();
        deleteLastRow(driver);
        return index;
    }

    public int getIdFromIndexSlider(WebDriver driver) {
        return getIdFromLastRow(driver, "data-index-slide-id");
    }
}
