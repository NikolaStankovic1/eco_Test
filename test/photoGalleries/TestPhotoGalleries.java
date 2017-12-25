/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photoGalleries;

import domen.PhotoGalleries;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.photoGalleries.PhotoGalleriesPages;
import setup.SeleniumProperties;

/**
 *
 * @author Stankovic
 */
public class TestPhotoGalleries {

    private static WebDriver driver;
//    private static WebDriverWait wait;
    private PhotoGalleriesPages pgp;

    @BeforeClass
    public static void setUpClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//            wait = new WebDriverWait(driver, 10);
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
        hp.clickOnPhotoGalleries(driver);
        pgp = new PhotoGalleriesPages();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addPhotoGalleries() {

        PhotoGalleries pgWeb = pgp.createPhotoGalleries(driver);
        System.out.println("Photo gallery is saved: ");
        PhotoGalleries pgDb = db.DbConnection.getPhotoGalleries("SELECT * FROM `cms_photo_galleries` WHERE id = " + pgWeb.getId());

        Assert.assertEquals(pgWeb.getId(), pgDb.getId());
        System.out.println("Photo Gallery title: "+ pgWeb.getTitle());
        Assert.assertEquals(pgWeb.getTitle(), pgDb.getTitle());
        System.out.println("Photo Gallery description: "+ pgWeb.getDescription());
        Assert.assertEquals(pgWeb.getDescription(), pgDb.getDescription());
    }

    @Test
    public void editPhotoGallerise() {

        PhotoGalleries pgWeb = pgp.editPhotoGalleries(driver);
        System.out.println("Photo gallery is edited: ");
        PhotoGalleries pgDb = db.DbConnection.getPhotoGalleries("SELECT * FROM `cms_photo_galleries` WHERE id = " + pgWeb.getId());

        Assert.assertEquals(pgWeb.getId(), pgDb.getId());
        System.out.println("Photo Gallery title: "+ pgWeb.getTitle());
        Assert.assertEquals(pgWeb.getTitle(), pgDb.getTitle());
        System.out.println("Photo Gallery description: "+ pgWeb.getDescription());
        Assert.assertEquals(pgWeb.getDescription(), pgDb.getDescription());

    }

    @Test
    public void deletePhotoGalleries() {

        PhotoGalleries pgWeb = pgp.deletePhotoGalleries(driver);
        System.out.println("Photo gallery is deleted: ");
        int counter = db.DbConnection.count("SELECT * FROM `cms_photo_galleries` WHERE id = " + pgWeb.getId());
        Assert.assertEquals(0, counter);
    }
}
