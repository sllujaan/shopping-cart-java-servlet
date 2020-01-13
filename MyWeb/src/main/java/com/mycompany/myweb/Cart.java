/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myweb;

import java.sql.ResultSet;

/**
 *
 * @author Subhan
 */
public class Cart {
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
}
