/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projepaketi;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author niyobaskan
 */
@SessionScoped
@Named(value = "projebean1")

public class projebean1 implements Serializable {

    private String name;
    private String surname;
    private int age;
    private String mail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
    
    public projebean1() {
    }
    
        public ArrayList fonk(){
        ArrayList  <String> abc= new ArrayList<>();
        
      try {
            Connection con = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/projedb",
                    "admin", "admin");
            PreparedStatement p = con.prepareStatement("SELECT * FROM USERS");

            ResultSet rs;
            rs = p.executeQuery();
            while(rs.next()){
               abc.add(rs.getString("name")+" "+rs.getString("surname"));
            }
}
catch (SQLException ex) {
            Logger.getLogger(projebean1.class.getName()).log(Level.SEVERE, null, ex);
        }  
      return abc;
    }
        
            public String getTime(){
        
        return DateFormat.getTimeInstance(DateFormat.MEDIUM).format(new Date());
    }
}
