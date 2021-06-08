/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import entity.Yorum;
import dao.YorumDAO;

@ManagedBean
@RequestScoped
public class YorumBean {
    private ArrayList<Yorum> yorumArrayList  = null ; 
    private YorumDAO yorumDAO = null ; 
    
    public YorumBean(){
        PersonalTrainerBean.setReset(true);
        UserBean.resetBooleanMessages();
    }
    
    private String typeComment ; 

    public String getTypeComment() {
        return typeComment;
    }

    public void setTypeComment(String typeComment) {
        this.typeComment = typeComment;
    }
    
    private int char_counter ; 

    public int getChar_counter() {
        if(typeComment == null){
            char_counter = 400 ; 
            return char_counter ; 
        }
        else{
            return 400-(typeComment.length());
        }
        
    }
    public String actionGonder(){
        
        if(typeComment == null){
            return "yorumlar" ; 
        }
        
        yorumDAO.insertComment(UserBean.getsUser_id(), typeComment);
        typeComment = null ; 
        return "yorumlar" ; 
    }
 

    public void setChar_counter(int char_counter) {
        this.char_counter = char_counter;
    }
    

    public ArrayList<Yorum> getYorumArrayList() {
        yorumDAO = new YorumDAO();
        yorumArrayList = yorumDAO.getTümYorumlarList();
        return yorumArrayList;
    }

    public void setYorumArrayList(ArrayList<Yorum> yorumArrayList) {
        this.yorumArrayList = yorumArrayList;
    }

    public YorumDAO getYorumDAO() {
        return yorumDAO;
    }

    public void setYorumDAO(YorumDAO yorumDAO) {
        this.yorumDAO = yorumDAO;
    }
}
