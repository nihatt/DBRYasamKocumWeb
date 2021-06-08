/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author YILMAZ
 */
public class IstatistikYorum {

    private String user_name;
    private String user_surname;
    private String user_path;
    private String yorum_content;
    
    public IstatistikYorum(){
        
    }

    public IstatistikYorum(String user_name, String user_surname, String user_path, String yorum_content) {
        this.user_name = user_name;
        this.user_surname = user_surname;
        this.user_path = user_path;
        this.yorum_content = yorum_content;
    }
    
   

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public String getUser_path() {
        return user_path;
    }

    public void setUser_path(String user_path) {
        this.user_path = user_path;
    }

    public String getYorum_content() {
        return yorum_content;
    }

    public void setYorum_content(String yorum_content) {
        this.yorum_content = yorum_content;
    }
}
