/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactInfo;

import domen.ContactInfo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.contactInfo.ContactInfoPages;
import setup.SeleniumProperties;

/**
 *
 * @author Stankovic
 */
public class TestContactInfo {
    
    private static WebDriver driver;
//    private static WebDriverWait wait;
    private ContactInfoPages cip;
    
    @BeforeClass
    public static void setUpClass() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage lp = new LoginPage();
        SeleniumProperties.init();        
        lp.logIn(driver, SeleniumProperties.url, SeleniumProperties.username, SeleniumProperties.password);        
        db.DbConnection.getConnection();

    }
    
    @AfterClass
    public static void tearDownClass() {
        LogoutPage lo = new LogoutPage();
        lo.logOut(driver);
        db.DbConnection.close();
        driver.quit();
    }
    
    @Before
    public void setUp() {
        HomePage hp = new HomePage();
        hp.clickOnContactInfo(driver);
        cip = new ContactInfoPages();
    }
    
    @After
    public void tearDown() {
    }

    
     @Test
     public void addContactInfo() {
         
        ContactInfo ciWeb = cip.createContactInfo(driver);
        System.out.println("ContactInfo is saved: ");
        ContactInfo ciDb = db.DbConnection.getContactInfo("SELECT * FROM `cms_contact` WHERE id = " + ciWeb.getId());

        Assert.assertEquals(ciWeb.getId(), ciDb.getId());
        System.out.println("ContactInfo location is: "+ ciWeb.getLocation());
        Assert.assertEquals(ciWeb.getLocation(), ciDb.getLocation());
        Assert.assertEquals(ciWeb.getAddress(), ciDb.getAddress());
        Assert.assertEquals(ciWeb.getAddressNumber(), ciDb.getAddressNumber());
        Assert.assertEquals(ciWeb.getHours(), ciDb.getHours());
        Assert.assertEquals(ciWeb.getLatitude(), ciDb.getLatitude());
        Assert.assertEquals(ciWeb.getLongitude(), ciDb.getLongitude());
        Assert.assertEquals(ciWeb.getPhone(), ciDb.getPhone());
        Assert.assertEquals(ciWeb.getEmail(), ciDb.getEmail());
        Assert.assertEquals(ciWeb.getZoom(), ciDb.getZoom());

     }
     
     @Test
     public void editContactInfo() {
         
        ContactInfo ciWeb = cip.editContactInfo(driver);
        System.out.println("ContactInfo is edited: ");
        ContactInfo ciDb = db.DbConnection.getContactInfo("SELECT * FROM `cms_contact` WHERE id = " + ciWeb.getId());

        Assert.assertEquals(ciWeb.getId(), ciDb.getId());
        System.out.println("ContactInfo location is: "+ ciWeb.getLocation());
        Assert.assertEquals(ciWeb.getLocation(), ciDb.getLocation());
        Assert.assertEquals(ciWeb.getAddress(), ciDb.getAddress());
        Assert.assertEquals(ciWeb.getAddressNumber(), ciDb.getAddressNumber());
        Assert.assertEquals(ciWeb.getHours(), ciDb.getHours());
        Assert.assertEquals(ciWeb.getLatitude(), ciDb.getLatitude());
        Assert.assertEquals(ciWeb.getLongitude(), ciDb.getLongitude());
        Assert.assertEquals(ciWeb.getPhone(), ciDb.getPhone());
        Assert.assertEquals(ciWeb.getEmail(), ciDb.getEmail());
        Assert.assertEquals(ciWeb.getZoom(), ciDb.getZoom());
     
     }
    
     @Test
    public void deleteContactInfo() {
        
        ContactInfo ciWeb = cip.deleteContactInfo(driver);
        System.out.println("ContactInfo is deleted: ");

        int counter = db.DbConnection.count("SELECT * FROM `cms_contact` WHERE id = " + ciWeb.getId());
        Assert.assertEquals(0, counter);
    }
}
