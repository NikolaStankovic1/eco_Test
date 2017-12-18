/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.photoGalleries;

import domen.PhotoGalleries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Page;

/**
 *
 * @author Stankovic
 */
public class PhotoGalleriesPages extends Page {

    private void clickOnAddPhotoGallery(WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-plus"));
    }

    private String sendTextOnTitleField(WebDriver drver) {
        return sendtextOnField(drver, By.id("title"));
    }

    private String sendTextOnDescriptionField(WebDriver driver) {
        return sendtextOnField(driver, By.id("description"));
    }

    private void sendPhoto(WebDriver driver) {
        sendTextOnField(driver, By.id("photo_gallery_leading_photo"), System.getProperty("user.dir")+ "/src/images/Focal Aria 926.jpg");
    }

    private void editPhoto(WebDriver driver) {
        sendTextOnField(driver, By.id("photo_gallery_leading_photo"), System.getProperty("user.dir")+ "/src/images/Focal Elear.jpg");
    }


    private PhotoGalleries commonSteps(WebDriver driver, String text) {
        PhotoGalleries pg = new PhotoGalleries();
        if (text.equals("create")){
        clickOnAddPhotoGallery(driver);
        } else {
            editLastRow(driver, By.className("glyphicon-pencil"));
        }
        pg.setTitle(sendTextOnTitleField(driver));
        pg.setDescription(sendTextOnDescriptionField(driver));

        if (text.equals("create")) {
            sendPhoto(driver);
            clickOnElement(driver, By.className("btn-success"));
            clickOnElement(driver, By.id("new_photoGallery_submit"));
        } else {
            editPhoto(driver);
            clickOnElement(driver, By.id("new_photoGallery_submit"));
        }
        pg.setId(getIdFromPhotoGalleries(driver));

        return pg;
    }

    private int getIdFromPhotoGalleries(WebDriver driver) {
        return getIdFromLastRow(driver, "data-photo-gallery-id");
    }

    public PhotoGalleries createPhotoGalleries(WebDriver driver) {
        return commonSteps(driver, "create");
    }

    public PhotoGalleries editPhotoGalleries(WebDriver driver) {
        return commonSteps(driver, "edit");
    }

    public PhotoGalleries deletePhotoGalleries(WebDriver driver) {
        PhotoGalleries pg = new PhotoGalleries();
        deleteLastRow(driver);
        return pg;
    }
}
