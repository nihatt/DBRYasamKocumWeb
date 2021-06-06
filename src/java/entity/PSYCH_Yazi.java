/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author YILMAZ
 */
public class PSYCH_Yazi {
    private int yazi_id ; 
    private int psych_id ; 
    private String yazi_name ; 
    private String yazi_link ; 

    public PSYCH_Yazi(int yazi_id, int psych_id, String yazi_name, String yazi_link) {
        this.yazi_id = yazi_id;
        this.psych_id = psych_id;
        this.yazi_name = yazi_name;
        this.yazi_link = yazi_link;
    }
    public PSYCH_Yazi(){
        
    }

    public int getYazi_id() {
        return yazi_id;
    }

    public void setYazi_id(int yazi_id) {
        this.yazi_id = yazi_id;
    }

    public int getPsych_id() {
        return psych_id;
    }

    public void setPsych_id(int psych_id) {
        this.psych_id = psych_id;
    }

    public String getYazi_name() {
        return yazi_name;
    }

    public void setYazi_name(String yazi_name) {
        this.yazi_name = yazi_name;
    }

    public String getYazi_link() {
        return yazi_link;
    }

    public void setYazi_link(String yazi_link) {
        this.yazi_link = yazi_link;
    }
}
