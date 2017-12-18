/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.IndexSlider;
import domen.PhotoGalleries;
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
        
        public static int countIndexSliders(String query) {
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
        
         public static int countPhotoGalleries (String query) {
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
         
         public static Users getUsers (String query){
            Users u = new Users();
            try {
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery(query);
            
            System.out.println(query);
            
            while(rs.next()){
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
        }
        
         public static int countUsers (String query) {
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
         
    
}
