/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.faces.bean.ManagedBean ; 
import javax.faces.bean.RequestScoped ; 
import java.text.DateFormat ; 
import java.util.Date;

@ManagedBean
@RequestScoped
public class HomePageBean {
    public String getTime(){
        
        return DateFormat.getTimeInstance(DateFormat.MEDIUM).format(new Date());
    }
}
