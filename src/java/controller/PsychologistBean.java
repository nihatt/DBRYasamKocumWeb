/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.faces.bean.ManagedBean ;
import javax.faces.bean.RequestScoped ; 
import entity.Psychologist;
import dao.PsychologistDAO;
import java.util.ArrayList ; 


@ManagedBean
@RequestScoped
public class PsychologistBean {
    private ArrayList<Psychologist> psychologistDao  = null ; 
    private PsychologistDAO psychologistDAO = null  ;
    //----------------------------------------------
    private Psychologist sPsychologist = null ; 

    public Psychologist getsPsychologist() {
        return sPsychologist;
    }

    public void setsPsychologist(Psychologist sPsychologist) {
        this.sPsychologist = sPsychologist;
    }
    
    public String firstSelecPsychologist(Psychologist psychologist){
       sPsychologist = psychologist ; 
       return null ; 
    }
    public String getTitlePsychologist(){
        if(sPsychologist == null){
           return null ;  
        }
        else{
            return sPsychologist.getPsych_name() +' ' +sPsychologist.getPsych_surname()  ; 
        }
    }
    
    //---------------------------------------

    public ArrayList<Psychologist> getPsychologistDao() {
        psychologistDAO = new PsychologistDAO();
        psychologistDao = psychologistDAO.getPsychologistList();
        return psychologistDao;
    }

    public void setPsychologistDao(ArrayList<Psychologist> psychologistDao) {
        this.psychologistDao = psychologistDao;
    }

    public PsychologistDAO getPsychologistDAO() {
        return psychologistDAO;
    }

    public void setPsychologistDAO(PsychologistDAO psychologistDAO) {
        this.psychologistDAO = psychologistDAO;
    }
    
}
