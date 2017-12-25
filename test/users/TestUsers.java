/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import domen.Users;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.users.UsersPages;
import setup.SeleniumProperties;

/**
 *
 * @author Stankovic
 */
public class TestUsers {
    private static WebDriver driver;
    private UsersPages up;

    
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
        hp.clickOnUsers(driver);
        up = new UsersPages();
    }
    
    @After
    public void tearDown() {
    }

    
     @Test
     public void createUser() {
     
         Users uWeb = up.createUsers(driver);
         System.out.println("User is saved: ");
         Users uDb = db.DbConnection.getUsers("SELECT * FROM `cms_users` ORDER BY id DESC LIMIT 1 ");
         
//         Assert.assertEquals(uWeb.getId(), uDb.getId());
         System.out.println("Username is: "+ uWeb.getUsername());
         Assert.assertEquals(uWeb.getUsername(), uDb.getUsername());
         System.out.println("FirstName is: "+ uWeb.getFirstName());
         Assert.assertEquals(uWeb.getFirstName(), uDb.getFirstName());
         System.out.println("LastName is: "+ uWeb.getLastName());
         Assert.assertEquals(uWeb.getLastName(), uDb.getLastName());
         System.out.println("Email is: "+ uWeb.getEmail());
         Assert.assertEquals(uWeb.getEmail(), uDb.getEmail());
     }
     
     @Test
     public void editUser (){
         
         Users uWeb = up.editUsers(driver);
         System.out.println("User is edited: ");
         Users uDb = db.DbConnection.getUsers("SELECT * FROM `cms_users` WHERE id = " + uWeb.getId());
         
         Assert.assertEquals(uWeb.getId(), uDb.getId());

         Assert.assertEquals(uWeb.getUsername(), uDb.getUsername());
         System.out.println("Username is: "+ uWeb.getUsername());
         Assert.assertEquals(uWeb.getFirstName(), uDb.getFirstName());
         Assert.assertEquals(uWeb.getLastName(), uDb.getLastName());
         Assert.assertEquals(uWeb.getEmail(), uDb.getEmail());   
     }
     
     @Test
     public void deleteUser(){
     
         Users uWeb = up.deleteUsers(driver);
         System.out.println("User is deleted: ");
         
         int counter = db.DbConnection.count("SELECT * FROM `cms_users` WHERE id = " + uWeb.getId());
         Assert.assertEquals(0, counter);
         
     }
     
}
