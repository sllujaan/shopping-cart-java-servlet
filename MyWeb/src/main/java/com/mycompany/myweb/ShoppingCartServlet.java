/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myweb;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Subhan
 */
public class ShoppingCartServlet extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShoppingCartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello<h1>");
            try{
                String file = "bc170401495.accdb";
                File dbFile = new File(file);
                if(!dbFile.exists()){
                    out.println("<h1>"+file+" not found."+"<h1>");
                }
                
                /*
                String path = System.getProperty("user.dir");
                out.println("<h1>Current working directory = "+path+"<h1>");
                String temp = "C:\\Users\\Subhan\\OneDrive\\NetBeansProjects\\MyWeb\\src\\main\\webapp\\assets\\bc170401495.accdb";
                String file = ".\\MyWeb\\src\\main\\webapp\\assets\\bc170401495.accdb";
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + file);
                Statement st = conn.createStatement();
                String sql = "SELECT * FROM Products;";
                ResultSet rs = st.executeQuery(sql);
                int i = 1;
                while(rs.next()){    
                    out.println("<h1>"+i + "\t" + rs.getString("Name") + "\t" + rs.getFloat("price") + "\t" + rs.getString("quantity")+"<h1>");
                    //System.out.println(i + "\t" + rs.getString("Name") + "\t" + rs.getFloat("price") + "\t" + rs.getString("quantity"));
                    i++;
                } */
            }
            catch(Exception e){
                out.println("<h1>Error::: "+e+"<h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        /*try{
            
            while(rs.next()){    
                System.out.println(i + "\t" + rs.getString("Name") + "\t" + rs.getFloat("price") + "\t" + rs.getString("quantity"));
                i++;
            }
            while(1 == 1){
                        
            }
        }
        catch(Exception e){
            
        }*/
        
    }
    
    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
