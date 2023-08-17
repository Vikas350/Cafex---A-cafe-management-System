/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Acer
 */
public class UserDao {
//    whenever this method call it take User var as parameter
    public static void save(User user){
        String query = "insert into user(name,email,phoneNumber,address,password,securityQuestion,answer,status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getPhoneNumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
        DbOperations.setDataOrDelete(query,"Regestered Successfully! Wait for Admin Approval!");
    }
    
//    using this we check user is exist or not
    public static User Login(String email, String password){
        User user = null;
        
        try{
            ResultSet rs = DbOperations.getData("Select *from user where email='"+email+"' and password='"+password+"'");
            while(rs.next())
            {
                user = new User();
                user.setStatus(rs.getString("status"));
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        return user;
    }
    
//    create a method for getting security question of a particular email in for got password page 
    public static User getSecurityQuestion(String email){
        User user = null;
        try{
            ResultSet rs = DbOperations.getData("Select *from user where email = '"+email+"'");
            while(rs.next())
            {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return user;
    }
    
//    create a method for update the password to new Password
    public static void update(String email, String newPassword){
        String query = "update user set password = '" + newPassword + "' where email = '" + email + "'";
        DbOperations.setDataOrDelete(query,"Password Changed Successfully");
    }
    
//    create a method for store the user details in the verify users page
    public static ArrayList<User> getAllRecords(String email){
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select *from user where email like '%"+email+"%'");
            while(rs.next())
            {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;
    }
    
//    create a method for update the Status of users
    public static void changeStatus(String email,String status){
        String query = "update user set status='"+status+"' where email='"+email+"'";
        DbOperations.setDataOrDelete(query,"Status Changed Successfully");
    }
    
//    method for change the password of a user
    public static void changePassword(String email,String oldPassword, String newPassword){
        try{
            ResultSet rs = DbOperations.getData("select *from user where email='"+email+"' and password='"+oldPassword+"'");
            if(rs.next())
            {
                update(email,newPassword);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Old Password in Wrong!");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
}
