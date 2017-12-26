/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageUtil;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author cubes6
 */
public class PageUtilities {


    public static String getRandomText() {
        return "Test" + (int) (Math.random() * 1000);
    }
    
    public static String getRandomFirstName(){
        return "First Name" + (int) (Math.random() *100);
    }
    
    public static String getRandomLastName (){
        return "Last Name" + getRandomInteger();
    }
    
    public static String getRandomEmail (){
        return getRandomText()+ ("@mail.rs");
    }
    
    public static int getRandomInteger() {
        return (int) (Math.random() * 10000);
    }

    public static String getRandomUrl() {
        return "http://".concat(getRandomText()).concat(".te");
    }
    
    public static int getRandomZoom(){
        return new Random().nextInt(20 - 1) + 1;
}
    public static String getRandomLatitude(){
    return new Random().nextInt(100) + 100 + "." + (int) (Math.random()*10000);
}

    

}
