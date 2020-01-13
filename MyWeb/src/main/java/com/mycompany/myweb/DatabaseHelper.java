/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myweb;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Subhan
 */
public class DatabaseHelper {
    
    static public String getCurrentPath(){
        String path = System.getProperty("user.dir");
        return path;
    }
    
    DatabaseHelper() throws Exception{
        dbFile = new File(file);
        if(!dbFile.exists()){
            throw new FileNotFoundException(file+" not found.");
        }
        System.out.println("Current working directory = "+getCurrentPath());
        System.out.println("absolute path directory = "+getCurrentPath()+"/"+file);
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        conn = DriverManager.getConnection("jdbc:ucanaccess://" + getCurrentPath()+"/"+file);
    }
    
    public ResultSet getProducts() throws Exception{
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM Products;";
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
    
    public static void main(String arg[]){
        try{
            DatabaseHelper db = new DatabaseHelper();
            ResultSet rs = db.getProducts();
            int i = 1;
            while(rs.next()){    
                System.out.println(i + "\t" + rs.getString("Name") + "\t" + rs.getFloat("price") + "\t" + rs.getString("quantity"));
                i++;
            }   
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    private Connection conn;
    private static final String file = "src/main/webapp/assets/bc170401495.accdb";
    private File dbFile;
}
