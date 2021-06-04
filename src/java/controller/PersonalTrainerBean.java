/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PersonalTrainerDAO ; 
import entity.PersonalTrainer ; 

import javax.faces.bean.ManagedBean ; 
import javax.faces.bean.RequestScoped ; 
import javax.faces.bean.SessionScoped ; 
import java.util.ArrayList ; 


@ManagedBean
@RequestScoped


public class PersonalTrainerBean {
    private ArrayList<PersonalTrainer> personalTrainerDao = null ;  // arraylist.
    private PersonalTrainerDAO personalTrainerDAO = null ;         // personaltrainer DAO object.
    // baska bir sayfaya gittigi zaman burayı true yapip tüm boolean ifadeler sıfırlanmalı.
    private static boolean reset = false  ;
    // these methods for bootstrap modal.
    private static PersonalTrainer sPersonalTrainer = null   ;
    public String getTitleOfPersonalTrainer(){
        if(sPersonalTrainer==null){
            return "" ; 
        }
        return  sPersonalTrainer.getPt_name()+" "+sPersonalTrainer.getPt_surname() ; 
    }
    public static int getStaticPersonalTrainerId(){
        return sPersonalTrainer.getPt_id() ; 
    }
    
    public String getContentOfPersonalTrainer(){
        if(sPersonalTrainer == null){
            return "" ; 
        }
        else{
           return sPersonalTrainer.getPt_cv() ; 
        }
    }
    
    public PersonalTrainerBean(){
        if(reset){
            female = false ; 
            male = false  ;
            age25P = false ; 
            age30P = false ; 
            age35P = false ; 
            age40P = false;
            age45P = false ; 
            highLicense = false ; 
            license = false ; 
            strong = false ; 
            strength = false ; 
            sedanter = false ; 
            fitness = false ; 
            star5 = false ; 
            star4 = false ; 
            star3 = false ; 
            star2 = false ; 
            star1 = false ; 
            reset = false ; 
        }
    }

    public static boolean isReset() {
        return reset;
    }

    public static void setReset(boolean reset) {
        PersonalTrainerBean.reset = reset;
    }
     //  Cinsiyet
    private static boolean female = false ;
    private static boolean male = false ; 
    //  Yas
    private static boolean age25P = false ; 
    private static boolean age30P = false ; 
    private static boolean age35P = false ; 
    private static boolean age40P = false ;
    private static boolean age45P = false ; 
    //  Egitim Durumu
    private static boolean highLicense = false ; 
    private static boolean license = false ;
    //  Uzmanlık
    private static boolean strong = false ;
    private static boolean strength = false ; 
    private static boolean sedanter = false ; 
    private static boolean fitness = false ; 
    //  Derecelendirme
    private static boolean star5 = false ; 
    private static boolean star4 = false ; 
    private static boolean star3 = false ; 
    private static boolean star2 = false ; 
    private static boolean star1 = false ; 

    
    public PersonalTrainerDAO getPersonalTrainerDAO() {
        return personalTrainerDAO;
    }

    public void setPersonalTrainerDAO(PersonalTrainerDAO personalTrainerDAO) {
        this.personalTrainerDAO = personalTrainerDAO;
    }

    public boolean isFemale() {
        return female;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isAge25P() {
        return age25P;
    }

    public void setAge25P(boolean age25P) {
        this.age25P = age25P;
    }

    public boolean isAge30P() {
        return age30P;
    }

    public void setAge30P(boolean age30P) {
        this.age30P = age30P;
    }

    public boolean isAge35P() {
        return age35P;
    }

    public void setAge35P(boolean age35P) {
        this.age35P = age35P;
    }

    public boolean isAge40P() {
        return age40P;
    }

    public void setAge40P(boolean age40P) {
        this.age40P = age40P;
    }

    public boolean isAge45P() {
        return age45P;
    }

    public void setAge45P(boolean age45P) {
        this.age45P = age45P;
    }

    public boolean isHighLicense() {
        return highLicense;
    }

    public void setHighLicense(boolean highLicense) {
        this.highLicense = highLicense;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    public boolean isStrong() {
        return strong;
    }

    public void setStrong(boolean strong) {
        this.strong = strong;
    }

    public boolean isStrength() {
        return strength;
    }

    public void setStrength(boolean strength) {
        this.strength = strength;
    }

    public boolean isSedanter() {
        return sedanter;
    }

    public void setSedanter(boolean sedanter) {
        this.sedanter = sedanter;
    }

    public boolean isFitness() {
        return fitness;
    }

    public void setFitness(boolean fitness) {
        this.fitness = fitness;
    }

    public boolean isStar5() {
        return star5;
    }

    public void setStar5(boolean star5) {
        this.star5 = star5;
    }

    public boolean isStar4() {
        return star4;
    }

    public void setStar4(boolean star4) {
        this.star4 = star4;
    }

    public boolean isStar3() {
        return star3;
    }

    public void setStar3(boolean star3) {
        this.star3 = star3;
    }

    public boolean isStar2() {
        return star2;
    }

    public void setStar2(boolean star2) {
        this.star2 = star2;
    }

    public boolean isStar1() {
        return star1;
    }

    public void setStar1(boolean star1) {
        this.star1 = star1;
    }

    public String firstSelectPT(PersonalTrainer personalTrainer){
       sPersonalTrainer = personalTrainer ; 
        return null  ;
    }

    public String filtreleme(){
        // to do something.
        return null ; 
    }

    public ArrayList<PersonalTrainer> getPersonalTrainerDao() {
        personalTrainerDAO = new PersonalTrainerDAO();
        personalTrainerDao =personalTrainerDAO.getPersonalTrainerList(isFemale(),isMale(),isAge25P(),isAge30P(),isAge35P(),
                isAge40P(),isAge45P(),isHighLicense(),isLicense(),isStrong(),isStrength(),isSedanter(),isFitness(),isStar5(),isStar4(),
                isStar3(),isStar2(),isStar1()); 
        return personalTrainerDao;
    }
    
   
    
}
