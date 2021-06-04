/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean ;
import javax.faces.bean.RequestScoped ;
import entity.Nutritionist;
import dao.NutritionistDAO;
import java.util.ArrayList;


@ManagedBean
@RequestScoped
public class NutritionistBean {
    private ArrayList<Nutritionist> nutritionistDao ;
    private NutritionistDAO nutritionistDAO ; 


    //------------------------------------------
    private static Nutritionist sNutritionist ; 
    
    public String firstSelectNutritionist(Nutritionist nutritionist){
        sNutritionist = nutritionist ; 
        return null ; 
    }
    
    public String getTitleOfNutritionist(){
        if(sNutritionist == null){
            return null ; 
        }
        else{
            return sNutritionist.getNut_name() +" " +sNutritionist.getNut_surname() ; 
        }
    }
    
    public String getCvOfNutritionist(){
        if(sNutritionist == null){
            return null ; 
        }
        else{
            return sNutritionist.getNut_cv();
        }
    }

    public static Nutritionist getsNutritionist() {
        return sNutritionist;
    }

    public static void setsNutritionist(Nutritionist sNutritionist) {
        NutritionistBean.sNutritionist = sNutritionist;
    }
    

    
    //--------------------------------------------------

    public ArrayList<Nutritionist> getNutritionistDao() {
        nutritionistDAO = new NutritionistDAO();
        nutritionistDao = nutritionistDAO.getNutritionistList();
        return nutritionistDao;
    }

    public void setNutritionistDao(ArrayList<Nutritionist> nutritionistDao) {
        this.nutritionistDao = nutritionistDao;
    }

    public NutritionistDAO getNutritionistDAO() {
        return nutritionistDAO;
    }

    public void setNutritionistDAO(NutritionistDAO nutritionistDAO) {
        this.nutritionistDAO = nutritionistDAO;
    }
    
    public static int getDiyetisyenId(){
        return sNutritionist.getNut_id() ; 
    }
    
}
