/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.DBConnection;
import entity.Nutritionist ; 

import java.sql.Connection ; 
import java.sql.Statement ; 
import java.sql.ResultSet ; 
import java.util.ArrayList ;

public class NutritionistDAO {
    Connection connection = null ; 
    DBConnection dbConnection = null  ;
    Statement statement = null ; 
    ResultSet resultSet = null ; 
    ArrayList<Nutritionist> nutritionist = null ; 

    public ArrayList<Nutritionist> getNutritionist() {
        return nutritionist;
    }

    public void setNutritionist(ArrayList<Nutritionist> nutritionist) {
        this.nutritionist = nutritionist;
    }
    
    public ArrayList<Nutritionist> getNutritionistList(){
        try{
          String query = "SELECT * FROM NUTS " ; 
          dbConnection = new DBConnection();
          connection = dbConnection.createConnection();
          statement = connection.createStatement();
          resultSet = statement.executeQuery(query) ; 
          nutritionist = new ArrayList<>();
          
          while(resultSet.next()){
              nutritionist.add(new Nutritionist(
                      resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),
                resultSet.getInt(9),resultSet.getBoolean(10),resultSet.getInt(11),resultSet.getDouble(12),resultSet.getString(13)
              )
              
              );
          }
          return nutritionist ; 
            
        }catch(Exception e1){
            System.out.println(e1.getMessage());
        }
        
        return null ; 
    }
}
