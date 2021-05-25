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
import java.util.ArrayList ; 


@ManagedBean
@RequestScoped
public class PersonalTrainerBean {
    private ArrayList<PersonalTrainer> personalTrainerDao = null ;  // arraylist.
    private PersonalTrainerDAO personalTrainerDAO = null ;         // personaltrainer DAO object.

    public ArrayList<PersonalTrainer> getPersonalTrainerDao() {
        personalTrainerDAO = new PersonalTrainerDAO();
        personalTrainerDao =personalTrainerDAO.getPersonalTrainerList(); 
        return personalTrainerDao;
    }
    
}
