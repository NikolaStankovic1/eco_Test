/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Categorie;
import domen.ContactInfo;
import domen.IndexSlider;
import domen.PhotoGalleries;
import domen.Portfolios;
import domen.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import setup.SeleniumProperties;

/**
 *
 * @author IKA
 */
public class DbConnection {
    
    private static Connection conn;
    
    public static void getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            SeleniumProperties.init();
            conn = DriverManager.getConnection(SeleniumProperties.dbUrl, SeleniumProperties.dbUsername, SeleniumProperties.dbPassword);
//            conn = DriverManager.getConnection("jdbc:mysql://136.243.5.37:33063/eco_test", "root", "cubesqa");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        public static IndexSlider getIndex_slides(String query){
            IndexSlider index = new IndexSlider();
            try {
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery(query);
            
            System.out.println(query);
            
            while(rs.next()){
                index.setId(rs.getInt("id"));
                index.setTitle(rs.getString(2));
                index.setDescription(rs.getString(3));
                index.setLinkType(rs.getString("link_type"));
                index.setLinkLabel(rs.getString(5));
                index.setInternalLink(rs.getString("internal_link_url"));
                index.setExternalLink(rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return index;
        }
        
        public static int count(String query) {
        int counter = 0;

        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println(query);

            while (rs.next()) {
                counter = rs.getInt(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return counter;
    }
        
         public static PhotoGalleries getPhotoGalleries (String query){
            PhotoGalleries pg = new PhotoGalleries();
            try {
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery(query);
            
            System.out.println(query);
            
            while(rs.next()){
                pg.setId(rs.getInt("id"));
                pg.setTitle(rs.getString(2));
                pg.setDescription(rs.getString(3));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pg;
        }
 
         public static Users getUsers (String query){
            Users u = new Users();
            try {
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery(query);
            
            System.out.println(query);
            
            while(rs.next()){
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString(2));
                u.setEmail(rs.getString(5));
                u.setFirstName(rs.getString(6));
                u.setLastName(rs.getString(7));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
        }
        
        public static Portfolios getPortfolios (String query){
            Portfolios port = new Portfolios();
            try {
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery(query);
            
            System.out.println(query);
            
            while(rs.next()){
                port.setId(rs.getInt("id"));
                port.setTitle(rs.getString(2));
                port.setCharacteristic1(rs.getString("characteristic1"));
                port.setCharacteristic2(rs.getString("characteristic2"));
                port.setDescription(rs.getString("description"));
               
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return port;
        }
         
         public static Categorie getCategories(String query){
             Categorie c = new Categorie();
            try {
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery(query);
            
            System.out.println(query);
            
            while(rs.next()){
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
        }
         
         public static ContactInfo getContactInfo(String query){
            ContactInfo ci = new ContactInfo();
            try {
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery(query);
            
            System.out.println(query);
            
            while(rs.next()){
                ci.setId(rs.getInt("id"));
                ci.setLocation(rs.getString(2));
                ci.setAddress(rs.getString(3));
                ci.setAddressNumber(rs.getInt(4));
                ci.setLatitude(rs.getString(6));
                ci.setLongitude(rs.getString(7));
                ci.setZoom(rs.getInt(8));
                ci.setPhone(rs.getString(9));
                ci.setEmail(rs.getString(11));
                ci.setHours(rs.getString(12));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ci;
        }
    
}
