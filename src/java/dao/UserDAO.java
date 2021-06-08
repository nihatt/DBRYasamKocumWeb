/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.UserBean;
import entity.NUT_Tarif;
import entity.Nutritionist;
import entity.PSYCH_Yazi;
import entity.PT_Video;
import entity.PersonalTrainer;
import entity.Psychologist;
import util.DBConnection;
import entity.User;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author YILMAZ
 */
public class UserDAO {

    Connection connection = null;
    DBConnection dbConnection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ArrayList<User> user = null;
    // this segment is used for picture uploading
    //private final String uploadTo ="./web/resources/images/USERS/" ; 
    private final String uploadTo = FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + "\\..\\..\\web\\resources\\images\\USERS\\";

    //private final String uploadTo = "C:\\Users\\YILMAZ\\Documents\\NetBeansProjects\\dbrsyasamkoc\\web\\resources\\images\\USERS\\" ; 
    public String getUploadTo() {
        return uploadTo;
    }
    //-----------------------------------------------

    public ArrayList<PersonalTrainer> getPTByUser_Id(int user_id) {
        int pt_id = 0;
        try {
            String query = "select PT_ID FROM USERS WHERE USER_ID =  " + user_id;
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                pt_id = resultSet.getInt(1);
            }
            if (pt_id == 0) {
                return null;
            }
            // pt_id'yi aldik simdi sira bu id'ye sahip pt'nin bilgilerini almakta.
            query = "SELECT * FROM PTS WHERE PT_ID = " + pt_id;
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ArrayList<PersonalTrainer> tempList = null;
            while (resultSet.next()) {
                tempList = new ArrayList<>();
                tempList.add(new PersonalTrainer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(9), resultSet.getBoolean(10), resultSet.getInt(11),
                        resultSet.getDouble(12), resultSet.getInt(13), resultSet.getString(14)));
            }
            return tempList;

        } catch (Exception e1) {

        }
        return null;
    }

    public int getYorumLike(int yorum_id) {
        int like_counter = 0;
        String query = "SELECT COUNT(*) FROM LIKES GROUP BY YORUM_ID HAVING YORUM_ID = " + yorum_id;//SELECT COUNT(*) FROM LIKES GROUP BY YORUM_ID HAVING YORUM_ID = 1
        try {
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                like_counter = resultSet.getInt(1);
            }
            return like_counter;
        } catch (Exception e1) {

        }
        return 0;
    }
    public void düzenleYorum(String yeniYorum,int yorum_id){
        // String query = "UPDATE YORUMLAR SET YORUM_CONTENT = ' "+ yeniYorum+" ' WHERE YORUM_ID = "+yorum_id ; 
        String query="UPDATE YORUMLAR SET YORUM_CONTENT = ? WHERE YORUM_ID = ?" ; 
        try{
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,yeniYorum);
            preparedStatement.setInt(2, yorum_id);
            preparedStatement.executeUpdate();
        }catch(Exception e1){
            
        }
    }
    public void likeBas(int user_id, int yorum_id) {
        String query = "INSERT INTO LIKES VALUES (?,?)";
        try {
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, yorum_id);
            preparedStatement.executeUpdate();

        } catch (Exception e1) {

        }
    }
    public void likeGeriAl(int user_id, int yorum_id){
      String query = "DELETE FROM LIKES WHERE USER_ID = "+ user_id+"AND YORUM_ID = " +yorum_id;
      try {
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (Exception e1) {

        }
      
    }
    
    public boolean kullaniciLikeAtmismi(int user_id, int yorum_id){
        String query= "SELECT * FROM LIKES WHERE USER_ID = " + user_id + "AND YORUM_ID = " + yorum_id ; 
        try {
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                return true ; 
            }

        } catch (Exception e1) {

        }
        return false;
    }

    public ArrayList<Nutritionist> getNutritionistByUser_Id(int user_id) {
        int nut_id = 0;
        try {
            String query = "select NUT_ID FROM USERS WHERE USER_ID =  " + user_id;
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                nut_id = resultSet.getInt(1);
            }
            if (nut_id == 0) {
                return null;
            }
            query = "SELECT * FROM NUTS WHERE NUT_ID = " + nut_id;
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ArrayList<Nutritionist> tempList = null;
            while (resultSet.next()) {
                tempList = new ArrayList<>();
                tempList.add(new Nutritionist(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(9), resultSet.getBoolean(10), resultSet.getInt(11),
                        resultSet.getDouble(12), resultSet.getString(13)));
            }
            return tempList;
        } catch (Exception e1) {

        }

        return null;
    }

    public void actionSifreDegis(String email, String password) {
        //UPDATE USERS SET USER_PASSWORD = '1234' WHERE USER_MAIL = 'alperenyilmaz@gmail.com'
        String query = "UPDATE USERS SET USER_PASSWORD = ? WHERE USER_MAIL = ?";
        try {
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            UserBean.setSifreOldu(true);
        } catch (Exception e1) {
            UserBean.setSifreOlmadi(true);
        }
    }

    public ArrayList<Psychologist> getPsychologistByUser_Id(int user_id) {
        int psych_id = 0;
        try {
            String query = "select PSYCHS_ID FROM USERS WHERE USER_ID =  " + user_id;
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                psych_id = resultSet.getInt(1);
            }
            if (psych_id == 0) {
                return null;
            }
            query = "SELECT * FROM PSYCHS WHERE PSYCH_ID = " + psych_id;
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ArrayList<Psychologist> tempList = null;
            while (resultSet.next()) {
                tempList = new ArrayList<>();
                tempList.add(new Psychologist(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(9), resultSet.getBoolean(10), resultSet.getInt(11),
                        resultSet.getDouble(12), resultSet.getString(13)));
            }
            return tempList;

        } catch (Exception e1) {

        }

        return null;
    }

    // for mail check-up
    public boolean checkMailDuplicate(String user_mail) {
        try {
            int counter = 0;
            //String query = "select * from USERS where USER_MAIL = '  " + user_mail + "  ' ";
            String query = "SELECT * FROM USERS WHERE USER_MAIL = ?" ; 
            
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            preparedStatement = connection.prepareCall(query);
            preparedStatement.setString(1, user_mail);
            resultSet=preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                counter++;
            }
            if (counter == 0) {
                return false;
            } else {
                return true;
            }

        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
        return true;
    }

    //--------------------------------------------
    public void selectHoca(int user_id, int hoca_id, String hoca_type) {
        try {
            String query = "update USERS SET ";
            String query2 = "insert into CHOOSE VALUES ( DEFAULT, ? , ? , ? )  ";
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, hoca_id);

            if (hoca_type.equals("s")) {
                query += "PT_ID =  " + String.valueOf(hoca_id) + " where USER_ID  =  " + String.valueOf(user_id);
                statement.executeUpdate(query);
                preparedStatement.setString(2, "s");
                preparedStatement.setInt(3, hoca_id);

            } else if (hoca_type.equals("d")) {
                query += "NUT_ID =  " + String.valueOf(hoca_id) + " where USER_ID  =  " + String.valueOf(user_id);
                statement.executeUpdate(query);
                preparedStatement.setString(2, "d");
                preparedStatement.setInt(3, hoca_id);

            } else {  // psikolog.
                query += "PSYCHS_ID =  " + String.valueOf(hoca_id) + " where USER_ID  =  " + String.valueOf(user_id);
                statement.executeUpdate(query);
                preparedStatement.setString(2, "p");
                preparedStatement.setInt(3, hoca_id);

            }
            preparedStatement.executeUpdate();

        } catch (Exception e1) {

        }
    }

    // for create User
    public void createUser(String user_name, String user_surname, String user_mail, String user_password, Part doc, String user_date) {
        try {
            int fileName = getLastId();
            InputStream input = doc.getInputStream();
            File file = new File(uploadTo + String.valueOf(fileName) + ".png");
            Files.copy(input, file.toPath());
            //---------------------------------
            // above section we uploaded the picture
            String query = "insert into USERS VALUES ( DEFAULT,?,?,?,?,?,?,0,0,0 )";
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, user_surname);
            preparedStatement.setString(3, user_mail);
            preparedStatement.setString(4, user_password);
            preparedStatement.setString(5, String.valueOf(fileName) + ".png");
            preparedStatement.setString(6, user_date);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getLastId() {
        try {
            int counter = 0;
            String query = "select * from USERS order by USER_ID DESC FETCH FIRST 1 ROWS ONLY ";
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                counter = resultSet.getInt(1);
            }
            return (counter + 1);
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
        return 0;
    }

    public User getUserById(int user_id) {
        String query = "select * from USERS WHERE USER_ID =  " + user_id + " ";
        try {
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            User tempUser = null;
            while (resultSet.next()) {
                tempUser = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10));
            }
            return tempUser;

        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
        return null;
    }

    public User girisYap(String user_mail, String user_password) {
        String query = " Select * from USERS WHERE USER_MAIL = ? AND USER_PASSWORD = ? ";
        try {
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user_mail);
            preparedStatement.setString(2, user_password);
            resultSet = preparedStatement.executeQuery();
            User tempUser = null;
            while (resultSet.next()) {
                tempUser = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10));
            }
            return tempUser;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //-------------------------------------
    public PT_Video getRandomVideo(int pt_id) {
        String query = "SELECT * FROM PT_VIDEOS WHERE PT_ID =  " + pt_id;
        try {
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ArrayList<PT_Video> tempArrayList = new ArrayList<>();
            while (resultSet.next()) {
                tempArrayList.add(new PT_Video(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4)));
            }
            int size = tempArrayList.size();
            java.util.Random rand = new java.util.Random();
            int index = rand.nextInt(size);
            return tempArrayList.get(index);

        } catch (Exception e1) {

        }
        return null;
    }

    public NUT_Tarif getRandomTarif(int nut_id) {
        String query = "SELECT * FROM TARIFLER WHERE NUT_ID = " + nut_id;
        try {
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ArrayList<NUT_Tarif> tempArrayList = new ArrayList<>();
            while (resultSet.next()) {
                tempArrayList.add(new NUT_Tarif(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4)));
            }
            int size = tempArrayList.size();
            java.util.Random rand = new java.util.Random();
            int index = rand.nextInt(size);
            return tempArrayList.get(index);
        } catch (Exception e1) {

        }
        return null;
    }

    public PSYCH_Yazi getRandomYazi(int psych_id) {
        String query = "SELECT * FROM YAZILAR WHERE PSYCH_ID = " + psych_id;
        try {
            dbConnection = new DBConnection();
            connection = dbConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            ArrayList<PSYCH_Yazi> tempArrayList = new ArrayList<>();
            while (resultSet.next()) {
                tempArrayList.add(new PSYCH_Yazi(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4)));
            }
            int size = tempArrayList.size();
            java.util.Random rand = new java.util.Random();
            int index = rand.nextInt(size);
            return tempArrayList.get(index);

        } catch (Exception e1) {

        }
        return null;
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

    public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }
}
