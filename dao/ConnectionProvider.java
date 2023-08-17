/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;

/**
 *
 * @author Acer
 */
public class ConnectionProvider {
    public static Connection getCon() {
        try {
            //This code is use for provide the connecion of data to database - MySQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafex?useSSL=false","root","Vikas@157");
            return con; //return connection
        }
        catch(Exception e) {
            return null;
        }
    }
}
