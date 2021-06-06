/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import util.DBConnection;
import entity.Yorum;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class YorumDAO {
    Connection connection = null ; 
    DBConnection dbConnection = null  ;
    Statement statement = null ; 
    PreparedStatement preparedStatement = null ; 
    ResultSet resultSet = null ; 
    ArrayList<Yorum> yorumArrayList = null ; 
    
    public ArrayList<Yorum> getTümYorumlarList(){
        String query = "SELECT * FROM YORUMLAR ORDER BY YORUM_ID DESC" ; 
        try{
        dbConnection = new DBConnection();
        connection  = dbConnection.createConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query) ; 
        yorumArrayList = new ArrayList<>();
        while(resultSet.next()){
            yorumArrayList.add(new Yorum(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3)))  ; 
        }
        return yorumArrayList ; 
        
        }catch(Exception e1){
            
        }
        return null ; 
    }
    public String getNameOfUser(int yorum_id){
        String query = "SELECT USER_NAME,USER_SURNAME FROM USERS INNER JOIN YORUMLAR ON USERS.USER_ID = YORUMLAR.USER_ID WHERE YORUMLAR.YORUM_ID =  " + yorum_id ; 
        try{
        dbConnection = new DBConnection();
        connection  = dbConnection.createConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query) ; 
        String name =""  ;  
        while(resultSet.next()){
            name +=resultSet.getString(1)+" "+resultSet.getString(2);
        }
        return name ; 
        }catch(Exception e1){
            
        }
        return null ; 
    }
    
    public String getPathOfUser(int yorum_id){
        String query = "SELECT USER_PATH FROM USERS INNER JOIN YORUMLAR ON USERS.USER_ID = YORUMLAR.USER_ID WHERE YORUMLAR.YORUM_ID =  " + yorum_id ; 
        try{
        dbConnection = new DBConnection();
        connection  = dbConnection.createConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query) ; 
        String path  = null ;  
        while(resultSet.next()){
            path = resultSet.getString(1);
        }
        return path ; 
        }catch(Exception e1){
            
        }
        return null ; 
    }
    
    public void insertComment(int user_id , String user_content){
        String query = "INSERT INTO YORUMLAR VALUES (DEFAULT , ? , ? )" ; 
        try{
        dbConnection = new DBConnection();
        connection  = dbConnection.createConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setString(2,user_content) ; 
        preparedStatement.executeUpdate();
        
        }catch(Exception e1){
            
        }
    }


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public ArrayList<Yorum> getYorumArrayList() {
        return yorumArrayList;
    }

    public void setYorumArrayList(ArrayList<Yorum> yorumArrayList) {
        this.yorumArrayList = yorumArrayList;
    }
}
