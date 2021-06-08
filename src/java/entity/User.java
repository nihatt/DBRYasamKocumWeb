/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class User {
    private int user_id  ; 
    private String user_name ; 
    private String user_surname ; 
    private String user_mail ; 
    private String user_password ; 
    private String user_path ; 
    private String user_date ; 
    private int pt_id ; 
    private int nut_id ; 
    private int psych_id ; 
    
    public User(){
        
    }

    public User(int user_id, String user_name, String user_surname,String user_mail ,String user_password, String user_path, String user_date, int pt_id, int nut_id, int psych_id) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_surname = user_surname;
        this.user_mail = user_mail ; 
        this.user_password = user_password;
        this.user_path = user_path;
        this.user_date = user_date;
        this.pt_id = pt_id;
        this.nut_id = nut_id;
        this.psych_id = psych_id;
    }
    public User(String user_name ,String user_surname, String user_path){
        this.user_name = user_name;
        this.user_surname = user_surname;
        this.user_path = user_path;
    }
    

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
     public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_path() {
        return user_path;
    }

    public void setUser_path(String user_path) {
        this.user_path = user_path;
    }

    public String getUser_date() {
        return user_date;
    }

    public void setUser_date(String user_date) {
        this.user_date = user_date;
    }

    public int getPt_id() {
        return pt_id;
    }

    public void setPt_id(int pt_id) {
        this.pt_id = pt_id;
    }

    public int getNut_id() {
        return nut_id;
    }

    public void setNut_id(int nut_id) {
        this.nut_id = nut_id;
    }

    public int getPsych_id() {
        return psych_id;
    }

    public void setPsych_id(int psych_id) {
        this.psych_id = psych_id;
    }
    
}
