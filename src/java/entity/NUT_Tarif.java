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
public class NUT_Tarif {
    private int nut_tarif_id ; 
    private int nut_id ; 
    private String tarif_name ; 
    private String tarif_link ; 

    public NUT_Tarif(int nut_tarif_id, int nut_id, String tarif_name, String tarif_link) {
        this.nut_tarif_id = nut_tarif_id;
        this.nut_id = nut_id;
        this.tarif_name = tarif_name;
        this.tarif_link = tarif_link;
    }
    public NUT_Tarif(){
        
    }

    public int getNut_tarif_id() {
        return nut_tarif_id;
    }

    public void setNut_tarif_id(int nut_tarif_id) {
        this.nut_tarif_id = nut_tarif_id;
    }

    public int getNut_id() {
        return nut_id;
    }

    public void setNut_id(int nut_id) {
        this.nut_id = nut_id;
    }

    public String getTarif_name() {
        return tarif_name;
    }

    public void setTarif_name(String tarif_name) {
        this.tarif_name = tarif_name;
    }

    public String getTarif_link() {
        return tarif_link;
    }

    public void setTarif_link(String tarif_link) {
        this.tarif_link = tarif_link;
    }
}
