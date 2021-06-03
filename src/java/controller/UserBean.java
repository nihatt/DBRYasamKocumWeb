/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean ;
import javax.faces.bean.SessionScoped ;
import entity.User;
import dao.UserDAO;
import java.util.ArrayList;
import javax.servlet.http.Part;

/**
 *
 * @author YILMAZ
 */
@ManagedBean
@SessionScoped
public class UserBean {
     private int user_id  ; 
    private String user_name ; 
    private String user_surname ; 
    private String user_mail ; 
    private String user_main_in ;
    private String user_password ; 
    private String user_password_in ; 
    private ArrayList<User> profileUser ; 

    public ArrayList<User> getProfileUser() {
        UserDAO userDAO = new UserDAO();
        User tempUser = userDAO.getUserById(user_id);
        profileUser = new ArrayList<>();
        profileUser.add(tempUser);
        return profileUser;
    }

    public void setProfileUser(ArrayList<User> profileUser) {
        this.profileUser = profileUser;
    }

 
    public String getUser_main_in() {
        return user_main_in;
    }

    public void setUser_main_in(String user_main_in) {
        this.user_main_in = user_main_in;
    }

    public String getUser_password_in() {
        return user_password_in;
    }

    public void setUser_password_in(String user_password_in) {
        this.user_password_in = user_password_in;
    }
    private String user_path ; 
    private String user_date ; 
    private int pt_id ; 
    private int nut_id ; 
    private int psych_id ; 
    // bu bolean ifade  data base de saklanmaz sadece bir user giris yapmis mi diye kontrol eder.
    private boolean loggedIn = false ; 
    //-------------------------------------------------------------------------------------------
    
    // for Sign-up

    
    public String actionSignUp(){
//        if((new UserDAO().checkMailDuplicate(user_mail))){
//            
//             return "index" ; 
//        }
       UserDAO userDAO = new UserDAO();
       userDAO.createUser(user_name, user_surname, user_mail, user_password, doc, user_date) ; 
       user_name = null ; 
       user_surname = null ; 
       user_mail = null ; 
       user_date = null ; 
       user_password = null ; 
       return null ; 
    }
    
    public String actionSignIn(){
        UserDAO userDAO = new UserDAO();
        User tempUser = userDAO.girisYap(user_main_in, user_password_in) ; 
        if(tempUser == null){
            return null ; 
        }
        else{
            user_id = tempUser.getUser_id();
            user_name = tempUser.getUser_name();
            user_surname = tempUser.getUser_surname();
            user_mail = tempUser.getUser_mail();
            user_password = tempUser.getUser_password();
            user_path = tempUser.getUser_path();
            user_date = tempUser.getUser_date();
            pt_id = tempUser.getPt_id();
            nut_id=tempUser.getNut_id();
            psych_id = tempUser.getPsych_id();
            loggedIn = true ; 
            return "index"  ;
        }
        
        
        
    }
    
    
    //---------------------------------------
    
    
    
        
    //This segment is used for picture uploading
    private Part doc ;
    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    //------------------------------------------
    
    // cikis yap
        public String cikisYap(){
            user_id = 0 ; 
            user_name = null ; 
            user_surname = null ; 
            user_mail = null ; 
            user_main_in = null ; 
            user_password = null ; 
            user_password_in = null ;
            user_path = null ; 
            user_date = null ; 
            pt_id = 0 ; 
            nut_id = 0 ; 
            psych_id = 0 ; 
            loggedIn=false ; 
            return "index" ; 
        }
    
    //----------------

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
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
