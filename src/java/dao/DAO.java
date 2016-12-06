/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nesquit
 */
public class DAO {
    
    private Connection con;
    
    public void setCon(Connection con){
        this.con=con;
    } 
    
    public  Connection getCon(){
        return con;
    }
    
    public void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaprendas?user=root&password=");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar a la BD: " + e);
        }
    }
    public void cerrar(){
        try{
            if (con!=null) {
                if (con.isClosed()==false) {
                    con.close();                    
                }                
            }
        }catch (Exception e){
            System.err.println("Error al cerrar la conexión: " + e);
        }
    }
    
}
