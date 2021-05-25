/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.Connection ; 
import java.sql.DriverManager ; 
public class DBConnection {
    private String dbUrl = "jdbc:derby://localhost:1527/DbDBR"  ;
    private String dbUser = "APP" ; 
    private String dbPassword = "APP" ; 
    
    public Connection createConnection(){
        Connection conn = null ; 
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            return conn ;
        }catch(Exception e1){
            e1.printStackTrace();
        }
        return null ; 
    }
}
