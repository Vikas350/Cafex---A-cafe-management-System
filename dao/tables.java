/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class tables {
    
    public static void main(String[] args){
        
        try{
            String userTable = "create table user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),phoneNumber varchar(10),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20),UNIQUE (email))";
            DbOperations.setDataOrDelete(userTable,"User Table Created Successfully");
            //enter Admin details
            String adminDetails = "insert into user(name,email,phoneNumber,address,password,securityQuestion,answer,status) values('Admin','admin@gmail.com','1234567890','India','admin','What primary school did you attend?','ABC','true')";
            DbOperations.setDataOrDelete(adminDetails,"Admin Details Added Successfully");
            
            //create table for manage category page
            String categoryTable = "create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
            DbOperations.setDataOrDelete(categoryTable,"Category Table Created Successfully");
            
            //create table for products
            String productTable = "create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
            DbOperations.setDataOrDelete(productTable,"Product Table Created Successfully");
            
            //create table for BILL
            String billTable = "create table bill(id int primary key,name varchar(200),phoneNumber varchar(200),email varchar(200),date varchar(50),total varchar(200),createdBy varchar(200))";
            DbOperations.setDataOrDelete(billTable,"Bill Table Created Successfully");
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
    }
    
}
