/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suit;

import categories.TestCategories;
import contactInfo.TestContactInfo;
import indexSlider.TestIndexSlider;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import photoGalleries.TestPhotoGalleries;
import portfolios.TestPortfolios;
import users.TestUsers;

/**
 *
 * @author Stankovic
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestCategories.class,TestContactInfo.class, TestIndexSlider.class, TestPortfolios.class, TestPhotoGalleries.class, TestUsers.class})
public class TestSuit {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
