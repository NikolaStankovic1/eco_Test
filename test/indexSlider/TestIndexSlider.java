/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexSlider;

import db.DbConnection;
import domen.IndexSlider;
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
import pages.indexSlider.IndexSliderPages;
import setup.SeleniumProperties;

/**
 *
 * @author qa
 */
public class TestIndexSlider {

    private static WebDriver driver;
//    private static WebDriverWait wait;
    private IndexSliderPages isp;

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
        db.DbConnection.close();
        driver.quit();
    }

    @Before
    public void setUp() {
        HomePage hp = new HomePage();
        hp.clickOnIndexSlider(driver);
        isp = new IndexSliderPages();
    }

    @After
    public void tearDown() {
        LogoutPage lo = new LogoutPage();
        lo.logOut(driver);
    }

    @Test
    public void addIndexSlider() {

        IndexSlider indexWeb = isp.createIndexSlider(driver);
        System.out.println("Index Slider is saved: ");
        IndexSlider indexDb = db.DbConnection.getIndex_slides("SELECT * FROM `cms_index_slides` WHERE id = " + indexWeb.getId());

        Assert.assertEquals(indexWeb.getId(), indexDb.getId());
        System.out.println("IndexSlider title is: "+ indexWeb.getTitle());
        Assert.assertEquals(indexWeb.getTitle(), indexDb.getTitle());
        Assert.assertEquals(indexWeb.getDescription(), indexDb.getDescription());
        Assert.assertEquals(indexWeb.getLinkLabel(), indexDb.getLinkLabel());
        Assert.assertEquals(indexWeb.getInternalLink(), indexDb.getInternalLink());

        
        
    }

    @Test
    public void editIndexSlider() {

        IndexSlider indexWeb = isp.editIndexSlider(driver);
        System.out.println("Index Slider is edited:");
        IndexSlider indexDb = db.DbConnection.getIndex_slides("SELECT * FROM `cms_index_slides` WHERE id = " + indexWeb.getId());

        Assert.assertEquals(indexWeb.getId(), indexDb.getId());
        System.out.println("IndexSlider title is: "+ indexWeb.getTitle());       
        Assert.assertEquals(indexWeb.getTitle(), indexDb.getTitle());
        Assert.assertEquals(indexWeb.getDescription(), indexDb.getDescription());
        Assert.assertEquals(indexWeb.getLinkLabel(), indexDb.getLinkLabel());
        Assert.assertEquals(indexWeb.getExternalLink(), indexDb.getExternalLink());

    }

    @Test
    public void deleteIndexSlider() {
        
        IndexSlider indexWeb = isp.deleteIndexSlider(driver);
        System.out.println("Index Slider is deleted:");

        int counter = DbConnection.countIndexSliders("SELECT * FROM `cms_index_slides` WHERE id = " + indexWeb.getId());
        Assert.assertEquals(0, counter);
    }

}
