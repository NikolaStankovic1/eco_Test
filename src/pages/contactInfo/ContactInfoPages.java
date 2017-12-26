/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.contactInfo;

import domen.ContactInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUtil.PageUtilities;
import pages.Page;

/**
 *
 * @author qa
 */
public class ContactInfoPages extends Page {

    private void clickOnAddContactInfo(WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-plus"));
    }

    private String sendtexOnLocationField(WebDriver driver) {
        return sendtextOnField(driver, By.id("location"));
    }

    private String sendTextOnAddressField(WebDriver driver) {
        return sendtextOnField(driver, By.id("address"));
    }

    private int sendNumberOnAddressNumberField(WebDriver driver) {
        return sendNumberOnField(driver, By.id("address_number"));
    }

    private String sendTextOnEmailField(WebDriver driver) {
        return sendTextOnField(driver, By.id("email"), PageUtilities.getRandomEmail());
    }

    private int sendNumberOnZoomField(WebDriver driver) {
        return sendNumberOnField(driver, By.id("zoom"), PageUtilities.getRandomZoom());
    }

    private String sendPhoneNumberOnField(WebDriver driver) {
        return sendTextOnField(driver, By.id("phone"), ("+38100123" + PageUtilities.getRandomInteger()));
    }

    private String sendHoursOnField(WebDriver driver) {
        return sendTextOnField(driver, By.id("hours"), ("14:35"));
    }

    private String sendLatitudeOnField(WebDriver driver) {
        return sendTextOnField(driver, By.id("latitude"), PageUtilities.getRandomLatitude());
    }

    private String sendLongitudeOnField(WebDriver driver) {
        return sendTextOnField(driver, By.id("longitude"), PageUtilities.getRandomLatitude());
    }

    private int getIdFromCintactInfo(WebDriver driver) {
        return getIdFromLastRow(driver, "data-contact-id");
    }

    private ContactInfo commonSteps(WebDriver driver, String text) {
        ContactInfo ci = new ContactInfo();

        if (text.equals("create")) {
            clickOnAddContactInfo(driver);
        } else {
            waitForElementVisibility(driver, By.className("table-striped"));
            editLastRow(driver, By.className("glyphicon-pencil"));
        }

        ci.setLocation(sendtexOnLocationField(driver));
        ci.setAddress(sendTextOnAddressField(driver));
        ci.setAddressNumber(sendNumberOnAddressNumberField(driver));
        ci.setHours(sendHoursOnField(driver));
        ci.setLatitude(sendLatitudeOnField(driver));
        ci.setLongitude(sendLongitudeOnField(driver));
        ci.setPhone(sendPhoneNumberOnField(driver));
        ci.setEmail(sendTextOnEmailField(driver));
        ci.setZoom(sendNumberOnZoomField(driver));

        clickOnElement(driver, By.id("new_portfolio_submit"));
        ci.setId(getIdFromCintactInfo(driver));
        return ci;
    }

    public ContactInfo createContactInfo(WebDriver driver) {
        return commonSteps(driver, "create");
    }

    public ContactInfo editContactInfo(WebDriver driver) {

        return commonSteps(driver, "edit");
    }

    public ContactInfo deleteContactInfo(WebDriver driver) {
        ContactInfo ci = new ContactInfo();
        deleteLastRow(driver);
        return ci;
    }

}
