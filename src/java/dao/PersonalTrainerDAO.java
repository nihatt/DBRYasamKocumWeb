/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import util.DBConnection ; 
import entity.PersonalTrainer ; 

import java.sql.Connection ; 
import java.sql.Statement ; 
import java.sql.ResultSet ; 
import java.util.ArrayList ; 

public class PersonalTrainerDAO {
    Connection connection = null ; 
    DBConnection dbConnection = null ; 
    Statement statement = null ; 
    ResultSet resultSet = null  ; 
    private ArrayList<PersonalTrainer> personalTrainer = null ; 

    public ArrayList<PersonalTrainer> getPersonalTrainer() {
        return personalTrainer;
    }

    public void setPersonalTrainer(ArrayList<PersonalTrainer> personalTrainer) {
        this.personalTrainer = personalTrainer;
    }
    
    public ArrayList<PersonalTrainer> getPersonalTrainerList(){
        String query = "select * from PTS" ; 
        dbConnection = new DBConnection();
        connection = dbConnection.createConnection() ; 
        try{
            statement = connection.createStatement() ; 
            resultSet = statement.executeQuery(query) ; 
            personalTrainer = new ArrayList<>();
            while(resultSet.next()){
                personalTrainer.add(new PersonalTrainer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),
                resultSet.getInt(9),resultSet.getBoolean(10),resultSet.getInt(11),resultSet.getDouble(12),resultSet.getInt(13)));
            }
            return personalTrainer ; 
            
            
        }catch(Exception e1){
            e1.printStackTrace();
        }
        return null ; 
    }
}
