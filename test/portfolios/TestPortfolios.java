/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolios;

import db.DbConnection;
import domen.Portfolios;
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
import pages.portfolios.PortfoliosPages;
import setup.SeleniumProperties;

/**
 *
 * @author Stankovic
 */
public class TestPortfolios {
    
    private static WebDriver driver;
    private PortfoliosPages pp;
    

    
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
        hp.clickOnPortfolios(driver);
        pp = new PortfoliosPages();
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void addPortfolios() {

        Portfolios portWeb = pp.createPortfolios(driver);
        System.out.println("Portfolio is saved: ");
        Portfolios portDb = db.DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE id = " + portWeb.getId());

        Assert.assertEquals(portWeb.getId(), portDb.getId());
        System.out.println("Portfolio title is: "+ portDb.getTitle());
        Assert.assertEquals(portWeb.getTitle(), portDb.getTitle());
        Assert.assertEquals(portWeb.getCharacteristic1(), portDb.getCharacteristic1());
        Assert.assertEquals(portWeb.getCharacteristic2(), portDb.getCharacteristic2());
        System.out.println("Portfolio description is: "+ portDb.getDescription());
        Assert.assertEquals(portWeb.getDescription(), portDb.getDescription());
   
    }
     
     @Test
     public void editPortfolios() {
     
         Portfolios portWeb = pp.editPortfolios(driver);
         System.out.println("Portfolio is edited: ");
         
         Portfolios portDb = db.DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE id = " + portWeb.getId());

        Assert.assertEquals(portWeb.getId(), portDb.getId());
        System.out.println("Portfolio title is: "+ portDb.getTitle());
        Assert.assertEquals(portWeb.getTitle(), portDb.getTitle());
        Assert.assertEquals(portWeb.getCharacteristic1(), portDb.getCharacteristic1());
        Assert.assertEquals(portWeb.getCharacteristic2(), portDb.getCharacteristic2());
        System.out.println("Portfolio description is: "+ portDb.getDescription());
        Assert.assertEquals(portWeb.getDescription(), portDb.getDescription());
     
     }
     
     @Test
     public void deletePortfolios () {
     
         Portfolios portWeb = pp.deletePortfolios(driver);
         System.out.println("Portfolio is deleted: ");
         
         int counter = db.DbConnection.count("SELECT * FROM `cms_portfolios` WHERE id = " + portWeb.getId());
        Assert.assertEquals(0, counter);
     }
     
     
}
