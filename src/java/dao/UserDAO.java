/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.DBConnection ; 
import entity.User ; 
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

import java.sql.Connection ; 
import java.sql.Statement ; 
import java.sql.ResultSet ; 
import java.util.ArrayList ;
import java.sql.PreparedStatement ; 
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author YILMAZ
 */
public class UserDAO {
    Connection connection = null ; 
    DBConnection dbConnection = null  ;
    Statement statement = null ; 
    PreparedStatement preparedStatement = null ; 
    ResultSet resultSet = null ; 
    ArrayList<User> user = null ; 
    // this segment is used for picture uploading
    //private final String uploadTo ="./web/resources/images/USERS/" ; 
    private final String uploadTo =FacesContext.getCurrentInstance().getExternalContext().getRealPath("")+"\\..\\..\\web\\resources\\images\\USERS\\" ; 
    //private final String uploadTo = "C:\\Users\\YILMAZ\\Documents\\NetBeansProjects\\dbrsyasamkoc\\web\\resources\\images\\USERS\\" ; 
    public String getUploadTo() {
        return uploadTo;
    }
    //-----------------------------------------------
    
    

    // for mail check-up
    public  boolean checkMailDuplicate(String user_mail){
        try{
            int counter = 0 ; 
            String query = "select * from USERS where USER_MAIL = '  "+user_mail+"  ' " ; 
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                counter++  ;
            }
            if(counter == 0 ){
                return false ; 
            }
            else{
                return true ; 
            }
        
        }catch(Exception e1){
            System.out.println(e1.getMessage());
        }
        return true  ;
    }
    
    //--------------------------------------------
    
    // for create User
    public void createUser(String user_name,String user_surname,String user_mail,String user_password,Part doc , String user_date){
        try{
            int fileName = getLastId();
            InputStream input = doc.getInputStream() ;
            File file = new File(uploadTo+String.valueOf(fileName)+".png");
            Files.copy(input,file.toPath()) ; 
            //---------------------------------
            // above section we uploaded the picture
            String query = "insert into USERS VALUES ( DEFAULT,?,?,?,?,?,?,0,0,0 )" ; 
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            preparedStatement = connection.prepareStatement(query) ; 
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, user_surname);
            preparedStatement.setString(3, user_mail);
            preparedStatement.setString(4, user_password);
            preparedStatement.setString(5, String.valueOf(fileName)+".png");
            preparedStatement.setString(6, user_date);
            preparedStatement.executeUpdate();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public int getLastId(){
        try{
            int counter = 0 ; 
            String query = "select * from USERS order by USER_ID DESC FETCH FIRST 1 ROWS ONLY " ; 
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                counter = resultSet.getInt(1);
            }
            return (counter+1) ; 
        }    
        catch(Exception e1){
            System.out.println(e1.getMessage());
        }
        return 0 ;
    }
    
    public User girisYap(String user_mail,String user_password){
        String query = " Select * from USERS WHERE USER_MAIL = ? AND USER_PASSWORD = ? " ; 
        try{
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            preparedStatement = connection.prepareStatement(query) ;
            preparedStatement.setString(1, user_mail);
            preparedStatement.setString(2, user_password);
            resultSet = preparedStatement.executeQuery() ;
            User tempUser = null ; 
            while(resultSet.next()){
                tempUser = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),
                resultSet.getInt(8),resultSet.getInt(9),resultSet.getInt(10));
            }
            return tempUser ; 
        }catch(Exception e){
            System.out.println(e.getMessage()) ; 
        }
        return null ; 
    }
    
    
    //-------------------------------------
    

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

    public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }
}
