/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Category;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class CategoryDao {
    
//  method for save the new item 
    public static void save(Category category){
        String query = "insert into category (name) values('"+category.getName()+"')";
        DbOperations.setDataOrDelete(query,"Category added Successfully");
    }
    
//  write array list and return category
    public static ArrayList<Category> getAllRecords(){
        //create a new array list
        ArrayList<Category> arrayList = new ArrayList<>();
        
        try{
            ResultSet rs = DbOperations.getData("select *from category");
            while(rs.next())
            {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arrayList.add(category);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        
        return arrayList;
    }
    
//    method to delete an item
    public static void delete(String id){
        String query = "delete from category where id='"+id+"'";
        DbOperations.setDataOrDelete(query,"Category Deleted Successfully");
    }
}
