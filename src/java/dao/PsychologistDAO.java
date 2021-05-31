/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.Psychologist ; 
import util.DBConnection ; 
import java.sql.Connection ; 
import java.sql.ResultSet ; 
import java.util.ArrayList ; 
import java.sql.Statement ; 
/**
 *
 * @author YILMAZ
 */
public class PsychologistDAO {
    Connection connection = null ; 
    DBConnection dbConnection = null ; 
    Statement statement = null ; 
    ResultSet resultSet = null  ;
    private ArrayList<Psychologist> pyschologist = null ; 

    public ArrayList<Psychologist> getPyschologist() {
        return pyschologist;
    }

    public void setPyschologist(ArrayList<Psychologist> pyschologist) {
        this.pyschologist = pyschologist;
    }
    public ArrayList<Psychologist> getPsychologistList(){
        try{
            String query = "select * from PSYCHS " ;
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection() ; 
            statement = connection.createStatement() ; 
            resultSet = statement.executeQuery(query) ; 
            pyschologist = new ArrayList<>();
            while(resultSet.next()){
                pyschologist.add(new Psychologist(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),
                resultSet.getInt(9),resultSet.getBoolean(10),resultSet.getInt(11),resultSet.getDouble(12),resultSet.getString(13)));
            }
            return pyschologist ; 
            
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return null ; 
    }
}
