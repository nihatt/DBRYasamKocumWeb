/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import dao.YorumDAO ; 
/**
 *
 * @author YILMAZ
 */
public class Yorum {
    private int yorum_id ;
    private int user_id ;
    private String yorum_content ; 
    private String user_name ; 
 

    
    public Yorum(int yorum_id, int user_id, String yorum_content) {
         
        this.yorum_id = yorum_id;
        this.user_id = user_id;
        this.yorum_content = yorum_content;
    }
    public Yorum(){
        
    }
   

    public String getUser_name() {
        YorumDAO yorumDAO = new YorumDAO();
        return yorumDAO.getNameOfUser(yorum_id);
        
    }
    public String getUser_image(){
        YorumDAO yorumDAO = new YorumDAO();
        return yorumDAO.getPathOfUser(yorum_id);
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    
    public int getYorum_id() {
        return yorum_id;
    }

    public void setYorum_id(int yorum_id) {
        this.yorum_id = yorum_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getYorum_content() {
        return yorum_content;
    }

    public void setYorum_content(String yorum_content) {
        this.yorum_content = yorum_content;
    }
}
