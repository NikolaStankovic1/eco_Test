/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categories;

import domen.Categorie;
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
import pages.categories.CategoriesPages;
import setup.SeleniumProperties;

/**
 *
 * @author Stankovic
 */
public class TestCategories {

    private static WebDriver driver;
    private CategoriesPages cp;

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
        hp.clickOnCategories(driver);
        cp = new CategoriesPages();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addCategories() {
        
        Categorie cWeb = cp.createCategories(driver);
        System.out.println("Categorie is saved: ");
        Categorie cDb = db.DbConnection.getCategories("SELECT * FROM `cms_portfolios_categories` WHERE id = " + cWeb.getId());

        Assert.assertEquals(cWeb.getId(), cDb.getId());
        System.out.println("Categorie title is: "+ cWeb.getName());
        Assert.assertEquals(cWeb.getName(), cDb.getName());
        Assert.assertEquals(cWeb.getDescription(), cDb.getDescription());
    
    }
    
    @Test
    public void editCategories(){
    
        Categorie cWeb = cp.editCategories(driver);
        System.out.println("Categorie is edied: ");
        Categorie cDb = db.DbConnection.getCategories("SELECT * FROM `cms_portfolios_categories` WHERE id = " + cWeb.getId());

        Assert.assertEquals(cWeb.getId(), cDb.getId());
        System.out.println("Categorie title is: "+ cWeb.getName());
        Assert.assertEquals(cWeb.getName(), cDb.getName());
        Assert.assertEquals(cWeb.getDescription(), cDb.getDescription());
        
    }
    
    @Test
    public void deleteCategories (){
        
        Categorie cWeb = cp.deleteCategories(driver);
        System.out.println("Categorie is deleted: ");
        int counter = db.DbConnection.count("SELECT * FROM `cms_portfolios_categories` WHERE id = " + cWeb.getId());
        Assert.assertEquals(0, counter);
    }
}
