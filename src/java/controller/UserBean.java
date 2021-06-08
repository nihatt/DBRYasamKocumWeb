/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entity.User;
import dao.UserDAO;
import dao.YorumDAO;
import entity.NUT_Tarif;
import entity.Nutritionist;
import entity.PSYCH_Yazi;
import entity.PersonalTrainer;
import entity.Psychologist;
import java.util.ArrayList;
import entity.PT_Video;
import entity.Yorum;
import javax.servlet.http.Part;

/**
 *
 * @author YILMAZ
 */
@ManagedBean
@SessionScoped
public class UserBean {

    private int user_id;
    private String user_name;
    private String user_surname;
    private String user_mail;
    private String user_main_in;
    private String user_password;
    private String user_password_in;
    private String user_mail_reset ;
    private String user_password_reset ; 
    private String password_reset ; 
    private ArrayList<Yorum> yorumArrayList ; 
    private boolean likeBastin ; 
    private int char_counter ; 
    private  static Yorum staticYorum ; 
    public String tempYorum ; 
    
    public UserBean(){
        PersonalTrainerBean.setReset(true);
        UserBean.resetBooleanMessages();
    }
    
    public String ayarlaStaticYorum(Yorum tempYorum){
        staticYorum = tempYorum ; 
        return null ; 
    }
    
    public String getTempYorum() {
        if(staticYorum == null){
            
        }
        else{
            tempYorum = staticYorum.getYorum_content();
        }
        return tempYorum;
    }

    public void setTempYorum(String tempYorum) {
        this.tempYorum = tempYorum;
    }

    public int getChar_counter() {
        if(staticYorum == null){
            char_counter = 400 ; 
            return char_counter ; 
        }
        else if(staticYorum.getYorum_content() == null){
            return 400 ; 
        }
        else{
            return 400-(staticYorum.getYorum_content().length());
        }
        
    
    }
    public String düzenleYorumu(){
        UserDAO userDAO = new UserDAO();
        userDAO.düzenleYorum(tempYorum,staticYorum.getYorum_id());
        return null;
    }

    public void setChar_counter(int char_counter) {
        this.char_counter = char_counter;
    }

    public boolean likeBastinMi(Yorum tempYorum) {
        UserDAO userDAO = new UserDAO();
        return userDAO.kullaniciLikeAtmismi(user_id,tempYorum.getYorum_id());
    }

    public void setLikeBastin(boolean likeBastin) {
        this.likeBastin = likeBastin;
    }

    public ArrayList<Yorum> getYorumArrayList() {
        YorumDAO yorumDAO = new YorumDAO();
        yorumArrayList =  yorumDAO.getYorumlarById(user_id);
        return yorumArrayList;
    }

    public void setYorumArrayList(ArrayList<Yorum> yorumArrayList) {
        this.yorumArrayList = yorumArrayList;
    }
    public String getPassword_reset() {
        return password_reset;
    }

    public void setPassword_reset(String password_reset) {
        this.password_reset = password_reset;
    }

    public String getUser_mail_reset() {
        return user_mail_reset;
    }

    public void setUser_mail_reset(String user_mail_reset) {
        this.user_mail_reset = user_mail_reset;
    }

    public String getUser_password_reset() {
        return user_password_reset;
    }

    public void setUser_password_reset(String user_password_reset) {
        this.user_password_reset = user_password_reset;
    }
    private ArrayList<User> profileUser;
    private static boolean   girisYanlis = false;
    private static boolean  üyeYanlis = false;
    private static boolean üyeOldu = false ; 
    private static boolean sifreUnuttum = false ; 
    private static boolean sifreOldu = false ; 
    private static boolean sifreOlmadi = false ; 

    public static void setSifreOldu(boolean sifreOldu) {
        UserBean.sifreOldu = sifreOldu;
    }

    public static void setSifreOlmadi(boolean sifreOlmadi) {
        UserBean.sifreOlmadi = sifreOlmadi;
    }

    public static boolean isSifreOldu() {
        return sifreOldu;
    }

    public static boolean isSifreOlmadi() {
        return sifreOlmadi;
    }
    
    public static boolean getSifreUnuttum(){
        return sifreUnuttum ; 
    }
    
    public String actionSifreDegis(){
        UserDAO userDAO = new UserDAO() ; 
        if(user_password_reset == null || user_password_reset.equals("")){
              girisYanlis = false;
            üyeYanlis = false;
             üyeOldu = false ; 
            sifreUnuttum = false ; 
             sifreOldu = false ; 
            sifreOlmadi = false ; 
            return null ; 
        }
        userDAO.actionSifreDegis(user_mail_reset, user_password_reset);
         girisYanlis = false;
            üyeYanlis = false;
             üyeOldu = false ; 
            sifreUnuttum = false ; 
             
        return null; 
    }
    
    public String actionSifreReset(){
        UserDAO userDAO = new UserDAO() ;
        if(password_reset == null || password_reset.equals("")){
            return null ; 
        }
         userDAO.actionSifreDegis(user_mail, password_reset);
         return null ; 
    }
    
    public String actionYorumuSil(Yorum tempYorum){
        YorumDAO yorumDAO = new YorumDAO();
        yorumDAO.yorumuSil(tempYorum.getYorum_id());
        return null ; 
    }
    public String deneme(){
        return "index" ; 
    }
    private static int sUser_id ; 
    
    

    public static int getsUser_id() {
        return sUser_id;
    }

    public static void setsUser_id(int sUser_id) {
        UserBean.sUser_id = sUser_id;
    }
    
    private ArrayList<PersonalTrainer> personalTrainerHoca ; 
    private ArrayList<Nutritionist> nutritionistHoca ; 
    
    private static PT_Video sPt_video = null ; 

    public static PSYCH_Yazi getsPsych_yazi() {
        return sPsych_yazi;
    }

    public static void setsPsych_yazi(PSYCH_Yazi sPsych_yazi) {
        UserBean.sPsych_yazi = sPsych_yazi;
    }
    private static NUT_Tarif sNut_tarif  = null ;   ;
    private static PSYCH_Yazi sPsych_yazi = null ; 

    public static NUT_Tarif getsNut_tarif() {
        return sNut_tarif;
    }

    public static void setsNut_tarif(NUT_Tarif sNut_tarif) {
        UserBean.sNut_tarif = sNut_tarif;
    }
    
    public String getNameOfVideo(){
        if(sPt_video == null){
            return null ; 
        }
        return sPt_video.getPt_video_name();
    }
    public String getLinkOfVideo(){
        if(sPt_video == null){
            return null ; 
        }
        return sPt_video.getPt_video_link() ; 
    }
    public String actionForVideo(PersonalTrainer tempPT){
        UserDAO userDAO = new UserDAO();
        sPt_video = userDAO.getRandomVideo(tempPT.getPt_id()) ;
        return null ; 
    }
    public String actionForTarif(Nutritionist tempNut){
        UserDAO userDAO = new UserDAO();
        sNut_tarif = userDAO.getRandomTarif(tempNut.getNut_id());
        return null ; 
    }
    public String actionForYazi(Psychologist tempPsych){
        UserDAO userDAO = new UserDAO();
        sPsych_yazi = userDAO.getRandomYazi(tempPsych.getPsych_id()) ;  
        return null ; 
    }
    public String getNameOfTarif(){
        if(sNut_tarif == null){
            return null ; 
        }
        else{
            return sNut_tarif.getTarif_name();
        }
    }
    public String getLinkOfTarif(){
        if(sNut_tarif == null){
            return null ; 
        }
        else{
            return sNut_tarif.getTarif_link() ; 
        }
    }
    public String getNameOfYazi(){
        if(sPsych_yazi == null){
            return null ; 
        }
        return sPsych_yazi.getYazi_name()  ;
    }
    public String getLinkOfYazi(){
       if(sPsych_yazi == null){
            return null ; 
        } 
       return sPsych_yazi.getYazi_link() ; 
    }

    public static boolean isÜyeOldu() {
        return üyeOldu;
    }

    public static void setÜyeOldu(boolean üyeOldu) {
        UserBean.üyeOldu = üyeOldu;
    }

    public static PT_Video getsPt_video() {
        return sPt_video;
    }

    public static void setsPt_video(PT_Video sPt_video) {
        UserBean.sPt_video = sPt_video;
    }

    public static boolean isGirisYanlis() {
        return girisYanlis;
    }

    public static void setGirisYanlis(boolean girisYanlis) {
        UserBean.girisYanlis = girisYanlis;
    }

    public static boolean isÜyeYanlis() {
        return üyeYanlis;
    }

    public static void setÜyeYanlis(boolean üyeYanlis) {
        UserBean.üyeYanlis = üyeYanlis;
    }

    public ArrayList<PersonalTrainer> getPersonalTrainerHoca() {
        UserDAO userDAO = new UserDAO();
        return userDAO.getPTByUser_Id(user_id) ; 
    }

    public void setPersonalTrainerHoca(ArrayList<PersonalTrainer> personalTrainerHoca) {
        this.personalTrainerHoca = personalTrainerHoca;
    }

    public ArrayList<Nutritionist> getNutritionistHoca() {
        // buraya yazilacak.
        UserDAO userDAO = new UserDAO();
        return userDAO.getNutritionistByUser_Id(user_id) ; 
        
    }

    public void setNutritionistHoca(ArrayList<Nutritionist> nutritionistHoca) {
        this.nutritionistHoca = nutritionistHoca;
    }

    public ArrayList<Psychologist> getPsychologistHoca() {
        // buraya yazilacak.
        UserDAO userDAO = new UserDAO();
        return userDAO.getPsychologistByUser_Id(user_id) ; 
        
    }

    public void setPsychologistHoca(ArrayList<Psychologist> psychologistHoca) {
        this.psychologistHoca = psychologistHoca;
    }
    private ArrayList<Psychologist> psychologistHoca ; 
    
    public static void resetBooleanMessages(){
        girisYanlis = false ; 
        sifreOldu = false ; 
        sifreOlmadi = false ; 
        üyeYanlis = false ; 
        sifreUnuttum = false ; 
        üyeOldu = false ;
        
    }

    public static boolean booleanGirisYanlis(){
        return girisYanlis ; 
    }
    public static boolean booleanÜyeYanlis(){
        return üyeYanlis ; 
    }
    public static boolean booleanÜyeOldu(){
        return üyeOldu ; 
    }
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
    private String user_path;
    private String user_date;
    private int pt_id;
    private int nut_id;
    private int psych_id;
    // bu bolean ifade  data base de saklanmaz sadece bir user giris yapmis mi diye kontrol eder.
    private boolean loggedIn = false;
    //-------------------------------------------------------------------------------------------

    // for Sign-up
    public String actionSignUp() {
        if((new UserDAO().checkMailDuplicate(user_mail))){
             üyeYanlis = true;
            girisYanlis = false;
            sifreOldu = false ; 
            sifreOlmadi = false ; 
            üyeOldu = false ; 
            return null;
             
        }
        if (user_name == null || user_surname == null || user_mail == null || user_password == null || doc == null || user_date == null) {
            üyeYanlis = true;
            girisYanlis = false;
            sifreOldu = false ; 
            sifreOlmadi = false ; 
            üyeOldu = false ; 
            return null;
        }
        
         
        girisYanlis = false;
        üyeYanlis = false;
        üyeOldu = true  ; 
        sifreOldu = false ; 
            sifreOlmadi = false ; 
        UserDAO userDAO = new UserDAO();
        userDAO.createUser(user_name, user_surname, user_mail, user_password, doc, user_date);
        user_name = null;
        user_surname = null;
        user_mail = null;
        user_date = null;
        user_password = null;
        return null;
    }

    public String actionSignIn() {
        UserDAO userDAO = new UserDAO();
        User tempUser = userDAO.girisYap(user_main_in, user_password_in);
        if (tempUser == null) {
            üyeYanlis = false;
            girisYanlis = true;
           sifreOldu = false ; 
            sifreOlmadi = false ; 
            üyeOldu = false ; 
            user_main_in = null ; 
            user_password_in = null ;
            return null;
        } else {
            girisYanlis = false;
            üyeYanlis = false;
              sifreOldu = false ; 
            sifreOlmadi = false ; 
            üyeOldu = false ; 
            user_id = tempUser.getUser_id();
            sUser_id = user_id ; 
            user_name = tempUser.getUser_name();
            user_surname = tempUser.getUser_surname();
            user_mail = tempUser.getUser_mail();
            user_password = tempUser.getUser_password();
            user_path = tempUser.getUser_path();
            user_date = tempUser.getUser_date();
            pt_id = tempUser.getPt_id();
            nut_id = tempUser.getNut_id();
            psych_id = tempUser.getPsych_id();
            loggedIn = true;
            return "index";
        }

    }
    public String actionSifreUnuttum(){
        üyeYanlis = false;
        girisYanlis = false;
        üyeOldu = false ; 
        sifreOldu = false ; 
        sifreOlmadi = false ; 
        sifreUnuttum = true ; 
        return null ; 
    }

    //---------------------------------------
    //This segment is used for picture uploading
    private Part doc;

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    //------------------------------------------
    // cikis yap
    public String cikisYap() {
        user_id = 0;
        user_name = null;
        user_surname = null;
        user_mail = null;
        user_main_in = null;
        user_password = null;
        user_password_in = null;
        user_path = null;
        user_date = null;
        pt_id = 0;
        nut_id = 0;
        psych_id = 0;
        loggedIn = false;
        return "index";
    }
    
    public int getCommentLike(Yorum tempYorum){
        UserDAO userDAO = new UserDAO();
        return userDAO.getYorumLike(tempYorum.getYorum_id());
    }
    public String likeButtonActive(Yorum tempYorum){
        UserDAO userDAO = new UserDAO();
        userDAO.likeBas( user_id, tempYorum.getYorum_id());
        return null ; 
    }
    public String likeButtonDeactive(Yorum tempYorum){
        UserDAO userDAO = new UserDAO();
        userDAO.likeGeriAl( user_id, tempYorum.getYorum_id());
        return null ; 
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

    public String selectPt() {
        UserDAO userDAO = new UserDAO();
        userDAO.selectHoca(user_id, PersonalTrainerBean.getStaticPersonalTrainerId(), "s"); // s mean personal trainer
        return "profilepage";

    }

    public String selectPsych() {
        UserDAO userDAO = new UserDAO();
        userDAO.selectHoca(user_id, PsychologistBean.getStaticPsikologId(), "p"); // p mean psikolog
        return "profilepage";

    }

    public String selectNut() {
        UserDAO userDAO = new UserDAO();
        userDAO.selectHoca(user_id, NutritionistBean.getDiyetisyenId(), "d"); // d mean diyetisyen
        return "profilepage";

    }
}
