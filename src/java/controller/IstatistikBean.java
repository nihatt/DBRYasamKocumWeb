/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.IstatistikDAO;
import entity.IstatistikYorum;
import entity.Nutritionist;
import entity.PersonalTrainer;
import entity.Psychologist;
import entity.User;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class IstatistikBean {
    private ArrayList<PersonalTrainer> ptEnFazlaSecilen = null ; 
    private ArrayList<Nutritionist> nutEnFazlaSecilen = null ; 
    private ArrayList<Psychologist> psychEnFazlaSecilen = null ; 
    //---------------------------------------------------------
    private ArrayList<Psychologist> psychEnAzSecilen = null ; 
    private ArrayList<Nutritionist> nutEnAzSecilen = null ; 
    private ArrayList<PersonalTrainer> ptEnAzSecilen = null ; 
    //----------------------------------------------------------
    private ArrayList<IstatistikYorum> yorumEnFazlaLikeAlan = null ; 
    private ArrayList<User> yorumlarıEnFazlaLikeAlanUser = null  ; 
    private ArrayList<User> enSadikUser = null ; 
    
    public IstatistikBean(){
        PersonalTrainerBean.setReset(true);
        UserBean.resetBooleanMessages();
    }


    public ArrayList<PersonalTrainer> getPtEnFazlaSecilen() {
        IstatistikDAO istatistikDAO = new IstatistikDAO();
        ptEnFazlaSecilen = istatistikDAO.getEnFazlaSecilenPT();
        return ptEnFazlaSecilen;
    }

    public void setPtEnFazlaSecilen(ArrayList<PersonalTrainer> ptEnFazlaSecilen) {
        this.ptEnFazlaSecilen = ptEnFazlaSecilen;
    }

    public ArrayList<Nutritionist> getNutEnFazlaSecilen() {
        IstatistikDAO istatistikDAO = new IstatistikDAO();
        nutEnFazlaSecilen = istatistikDAO.getEnFazlaSecilenNut();
        return nutEnFazlaSecilen;
    }

    public void setNutEnFazlaSecilen(ArrayList<Nutritionist> nutEnFazlaSecilen) {
        this.nutEnFazlaSecilen = nutEnFazlaSecilen;
    }

    public ArrayList<Psychologist> getPsychEnFazlaSecilen() {
        IstatistikDAO istatistikDAO = new IstatistikDAO();
        psychEnFazlaSecilen = istatistikDAO.getEnFazlaSecilenPsych();
        return psychEnFazlaSecilen;
    }

    public void setPsychEnFazlaSecilen(ArrayList<Psychologist> psychEnFazlaSecilen) {
        this.psychEnFazlaSecilen = psychEnFazlaSecilen;
    }

    public ArrayList<Psychologist> getPsychEnAzSecilen() {
        IstatistikDAO istatistikDAO = new IstatistikDAO();
        psychEnAzSecilen = istatistikDAO.getHicSecilmeyePsych();
        return psychEnAzSecilen;
    }

    public void setPsychEnAzSecilen(ArrayList<Psychologist> psychEnAzSecilen) {
        this.psychEnAzSecilen = psychEnAzSecilen;
    }

    public ArrayList<Nutritionist> getNutEnAzSecilen() {
        IstatistikDAO istatistikDAO = new IstatistikDAO();
        nutEnAzSecilen = istatistikDAO.getHicSecilmeyenNut();
        return nutEnAzSecilen;
    }

    public void setNutEnAzSecilen(ArrayList<Nutritionist> nutEnAzSecilen) {
        this.nutEnAzSecilen = nutEnAzSecilen;
    }

    public ArrayList<PersonalTrainer> getPtEnAzSecilen() {
        IstatistikDAO istatistikDAO = new IstatistikDAO();
        ptEnAzSecilen = istatistikDAO.getHicSecilmeyenPt();
        return ptEnAzSecilen;
    }

    public void setPtEnAzSecilen(ArrayList<PersonalTrainer> ptEnAzSecilen) {
        this.ptEnAzSecilen = ptEnAzSecilen;
    }

    public ArrayList<IstatistikYorum> getYorumEnFazlaLikeAlan() {
        IstatistikDAO istatistikDAO = new IstatistikDAO();
        yorumEnFazlaLikeAlan = istatistikDAO.getEnFazlaLikeAlanYorum();
        return yorumEnFazlaLikeAlan;
    }

    public void setYorumEnFazlaLikeAlan(ArrayList<IstatistikYorum> yorumEnFazlaLikeAlan) {
        this.yorumEnFazlaLikeAlan = yorumEnFazlaLikeAlan;
    }

    public ArrayList<User> getYorumlarıEnFazlaLikeAlanUser() {
        IstatistikDAO istatistikDAO = new IstatistikDAO();
        yorumlarıEnFazlaLikeAlanUser = istatistikDAO.getEnFazlaLikeAlanUser();
        return yorumlarıEnFazlaLikeAlanUser;
    }

    public void setYorumlarıEnFazlaLikeAlanUser(ArrayList<User> yorumlarıEnFazlaLikeAlanUser) {
        this.yorumlarıEnFazlaLikeAlanUser = yorumlarıEnFazlaLikeAlanUser;
    }

    public ArrayList<User> getEnSadikUser() {
        IstatistikDAO istatistikDAO = new IstatistikDAO();
        enSadikUser = istatistikDAO.getEnSadikUser();
        return enSadikUser;
    }

    public void setEnSadikUser(ArrayList<User> enSadikUser) {
        this.enSadikUser = enSadikUser;
    }
    
    
    
}
