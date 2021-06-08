/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.IstatistikYorum;
import entity.Nutritionist;
import entity.PersonalTrainer;
import entity.Psychologist;
import entity.User;
import util.DBConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class IstatistikDAO {

    public ArrayList<PersonalTrainer> getEnFazlaSecilenPT() {
        try {
            String query ="SELECT PT_NAME , PT_SURNAME,PT_PATH,VIRTUAL.SAYI FROM PTS INNER JOIN (\n" +
                "\n" +
                "    SELECT PT_ID, COUNT(*) AS SAYI FROM USERS GROUP BY PT_ID HAVING COUNT(*) = \n" +
                "        (SELECT COUNT(*) FROM USERS GROUP BY PT_ID HAVING PT_ID != 0 \n" +
                "		ORDER BY COUNT(*) DESC FETCH FIRST 1 ROWS ONLY)\n" +
                "\n" +
                ") AS VIRTUAL ON VIRTUAL.PT_ID = PTS.PT_ID" ; 
            ArrayList<PersonalTrainer> tempArrayList = new ArrayList<>();
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                tempArrayList.add(new PersonalTrainer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4)));
                
            }
            
            return tempArrayList;

        }catch(Exception e1){
            
        }
        return null ;

    }
    
    public ArrayList<Nutritionist> getEnFazlaSecilenNut(){
        try{
            String query = "SELECT NUT_NAME , NUT_SURNAME,NUT_PATH FROM NUTS INNER JOIN (\n" +
                            "\n" +
                            "    SELECT NUT_ID, COUNT(*) AS SAYI FROM USERS GROUP BY NUT_ID HAVING COUNT(*) = \n" +
                            "        (SELECT COUNT(*) FROM USERS GROUP BY NUT_ID HAVING NUT_ID != 0 \n" +
                            "		ORDER BY COUNT(*) DESC FETCH FIRST 1 ROWS ONLY)\n" +
                            "\n" +
                            ") AS VIRTUAL ON VIRTUAL.NUT_ID = NUTS.NUT_ID";
            ArrayList<Nutritionist> tempArrayList = new ArrayList<>();
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                tempArrayList.add(new Nutritionist(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            return tempArrayList ; 
            
        }catch(Exception e1){
            
        }
        return null ; 
    }
    
    public ArrayList<Psychologist> getEnFazlaSecilenPsych(){
        try{
            String query = "SELECT PSYCH_NAME , PSYCH_SURNAME,PSYCH_PATH FROM PSYCHS INNER JOIN (\n" +
                    "\n" +
                    "    SELECT PSYCHS_ID, COUNT(*) AS SAYI FROM USERS GROUP BY PSYCHS_ID HAVING COUNT(*) = \n" +
                    "        (SELECT COUNT(*) FROM USERS GROUP BY PSYCHS_ID HAVING PSYCHS_ID != 0 \n" +
                    "		ORDER BY COUNT(*) DESC FETCH FIRST 1 ROWS ONLY)\n" +
                    "\n" +
                    ") AS VIRTUAL ON VIRTUAL.PSYCHS_ID = PSYCHS.PSYCH_ID";
            ArrayList<Psychologist> tempArrayList = new ArrayList<>();
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                tempArrayList.add(new Psychologist(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            return tempArrayList; 
            
        }catch(Exception e1){
            
        }
        
        
        return null ; 
    }
    
    public ArrayList<Psychologist> getHicSecilmeyePsych(){
        try{
            String query = "SELECT PSYCH_NAME,PSYCH_SURNAME,PSYCH_PATH FROM PSYCHS WHERE \n" +
                                "PSYCH_ID NOT IN \n" +
                                "(\n" +
                                "SELECT PSYCHS_ID FROM (SELECT PSYCHS_ID,COUNT(*) AS SAYI FROM USERS GROUP BY PSYCHS_ID HAVING PSYCHS_ID != 0 AND COUNT(*) > 0 ) AS VIRTUAL1\n" +
                                ")";
            ArrayList<Psychologist> tempArrayList = new ArrayList<>();
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                tempArrayList.add(new Psychologist(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            return tempArrayList; 
            
        }catch(Exception e1){
            
        }
        
        
        return null ;
    }
    
    public ArrayList<Nutritionist> getHicSecilmeyenNut(){
        try{
            String query = "SELECT NUT_NAME,NUT_SURNAME,NUT_PATH FROM NUTS WHERE \n" +
                                "NUT_ID NOT IN \n" +
                                "(\n" +
                                "SELECT NUT_ID FROM (SELECT NUT_ID,COUNT(*) AS SAYI FROM USERS GROUP BY NUT_ID HAVING NUT_ID != 0 AND COUNT(*) > 0 ) AS VIRTUAL1\n" +
                                ")";
            ArrayList<Nutritionist> tempArrayList = new ArrayList<>();
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                tempArrayList.add(new Nutritionist(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            return tempArrayList; 
            
        }catch(Exception e1){
            
        }
        
        
        return null ;
    }
    
    public ArrayList<PersonalTrainer> getHicSecilmeyenPt(){
        try{
            String query = "SELECT PT_NAME,PT_SURNAME , PT_PATH FROM PTS WHERE \n" +
                                "PT_ID NOT IN \n" +
                                "(\n" +
                                "SELECT PT_ID FROM (SELECT PT_ID,COUNT(*) AS SAYI FROM USERS GROUP BY PT_ID HAVING PT_ID != 0 AND COUNT(*) > 0 ) AS VIRTUAL1\n" +
                                ")";
            ArrayList<PersonalTrainer> tempArrayList = new ArrayList<>();
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                tempArrayList.add(new PersonalTrainer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),0));
            }
            return tempArrayList; 
            
        }catch(Exception e1){
            
        }
        
        
        return null ;
    }
    
    public ArrayList<IstatistikYorum> getEnFazlaLikeAlanYorum(){
        try{
            String query = "SELECT USER_NAME,USER_SURNAME,USER_PATH,VIRTUAL3.YORUM_CONTENT FROM USERS INNER JOIN\n" +
                                "(SELECT USER_ID , YORUM_CONTENT,VIRTUAL2.SAYI FROM YORUMLAR INNER JOIN\n" +
                                " (SELECT YORUM_ID,SAYI FROM (SELECT YORUM_ID,COUNT(*) AS SAYI FROM LIKES GROUP BY YORUM_ID HAVING COUNT(*)=\n" +
                                "(SELECT COUNT(*) FROM LIKES GROUP BY YORUM_ID ORDER BY COUNT(*) DESC FETCH FIRST 1 ROWS ONLY))\n" +
                                "AS VIRTUAL1 ORDER BY YORUM_ID DESC) AS VIRTUAL2 ON VIRTUAL2.YORUM_ID  = YORUMLAR.YORUM_ID) AS VIRTUAL3 ON VIRTUAL3.USER_ID = USERS.USER_ID";
            ArrayList<IstatistikYorum> tempArrayList = new ArrayList<>();
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                tempArrayList.add(new IstatistikYorum(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
            }
            return tempArrayList; 
            
        }catch(Exception e1){
            
        }
        return null  ;
    }
    
    public ArrayList<User> getEnFazlaLikeAlanUser(){
        try{
            String query = "SELECT USER_NAME,USER_SURNAME,USER_PATH FROM USERS INNER JOIN\n" +
                                "(\n" +
                                "\n" +
                                "SELECT USER_ID,SUM(SAYI) AS TOPLAM FROM \n" +
                                "(SELECT USER_ID,VIRTUAL1.SAYI FROM YORUMLAR INNER JOIN \n" +
                                "(SELECT YORUM_ID , COUNT(*) AS SAYI FROM LIKES GROUP BY YORUM_ID) AS VIRTUAL1 ON VIRTUAL1.YORUM_ID = YORUMLAR.YORUM_ID) AS VIRTUAL2\n" +
                                "GROUP BY USER_ID HAVING SUM(SAYI) = \n" +
                                "(\n" +
                                "\n" +
                                "SELECT SUM(SAYI) AS TOPLAM FROM \n" +
                                "(SELECT USER_ID,VIRTUAL1.SAYI FROM YORUMLAR INNER JOIN \n" +
                                "(SELECT YORUM_ID , COUNT(*) AS SAYI FROM LIKES GROUP BY YORUM_ID) AS VIRTUAL1 ON VIRTUAL1.YORUM_ID = YORUMLAR.YORUM_ID) AS VIRTUAL2\n" +
                                "GROUP BY USER_ID ORDER BY TOPLAM DESC FETCH FIRST 1 ROWS ONLY\n" +
                                "\n" +
                                ")\n" +
                                ") AS VIRTUAL3 ON VIRTUAL3.USER_ID = USERS.USER_ID";
            ArrayList<User> tempArrayList = new ArrayList<>();
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                tempArrayList.add(new User(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            return tempArrayList; 
            
        }catch(Exception e1){
            
        }
        return null  ;
    }
    
    public ArrayList<User> getEnSadikUser(){
        try{
            String query = "SELECT USER_NAME,USER_SURNAME,USER_PATH FROM USERS INNER JOIN \n" +
                                "(SELECT USER_ID FROM \n" +
                                "(SELECT USER_ID,COUNT(*) FROM CHOOSE GROUP BY USER_ID HAVING\n" +
                                "COUNT(*) = (\n" +
                                "\n" +
                                "SELECT COUNT(*) AS SAYI FROM CHOOSE GROUP BY USER_ID ORDER BY COUNT(*) ASC FETCH FIRST 1 ROWS ONLY\n" +
                                ")) AS VIRTUAL) AS VIRTUAL2 ON VIRTUAL2.USER_ID = USERS.USER_ID";
            ArrayList<User> tempArrayList = new ArrayList<>();
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                tempArrayList.add(new User(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            return tempArrayList; 
            
        }catch(Exception e1){
            
        }
        return null  ;
    }
    
    
}
