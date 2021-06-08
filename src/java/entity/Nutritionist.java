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
public class Nutritionist {
    private int nut_id ; 
    private String nut_name ; 
    private String nut_surname  ;
    private String nut_link ; 
    private String nut_number ; 
    private String nut_cv     ;
    private String nut_path  ;
    private String nut_gender  ;
    private int    nut_age   ; 
    private boolean nut_state ; 
    private int nut_count  ; 
    private double nut_avg  ;
    private String nut_description ;
    
    public Nutritionist(){
        
    }

    public Nutritionist(int nut_id, String nut_name, String nut_surname, String nut_link, String nut_number, String nut_cv, String nut_path, String nut_gender, int nut_age, boolean nut_state, int nut_count, double nut_avg, String nut_description) {
        this.nut_id = nut_id;
        this.nut_name = nut_name;
        this.nut_surname = nut_surname;
        this.nut_link = nut_link;
        this.nut_number = nut_number;
        this.nut_cv = nut_cv;
        this.nut_path = nut_path;
        this.nut_gender = nut_gender;
        this.nut_age = nut_age;
        this.nut_state = nut_state;
        this.nut_count = nut_count;
        this.nut_avg = nut_avg;
        this.nut_description = nut_description;
    }
    public Nutritionist(String nut_name, String nut_surname, String nut_path){
        this.nut_name = nut_name;
        this.nut_surname = nut_surname;
        this.nut_path = nut_path;
        
    }
    
    
    public int getNut_id() {
        return nut_id;
    }

    public void setNut_id(int nut_id) {
        this.nut_id = nut_id;
    }

    public String getNut_name() {
        return nut_name;
    }

    public void setNut_name(String nut_name) {
        this.nut_name = nut_name;
    }

    public String getNut_surname() {
        return nut_surname;
    }

    public void setNut_surname(String nut_surname) {
        this.nut_surname = nut_surname;
    }

    public String getNut_link() {
        return nut_link;
    }

    public void setNut_link(String nut_link) {
        this.nut_link = nut_link;
    }

    public String getNut_number() {
        return nut_number;
    }

    public void setNut_number(String nut_number) {
        this.nut_number = nut_number;
    }

    public String getNut_cv() {
        return nut_cv;
    }

    public void setNut_cv(String nut_cv) {
        this.nut_cv = nut_cv;
    }

    public String getNut_path() {
        return nut_path;
    }

    public void setNut_path(String nut_path) {
        this.nut_path = nut_path;
    }

    public String getNut_gender() {
        return nut_gender;
    }

    public void setNut_gender(String nut_gender) {
        this.nut_gender = nut_gender;
    }

    public int getNut_age() {
        return nut_age;
    }

    public void setNut_age(int nut_age) {
        this.nut_age = nut_age;
    }

    public boolean isNut_state() {
        return nut_state;
    }

    public void setNut_state(boolean nut_state) {
        this.nut_state = nut_state;
    }

    public int getNut_count() {
        return nut_count;
    }

    public void setNut_count(int nut_count) {
        this.nut_count = nut_count;
    }

    public double getNut_avg() {
        return nut_avg;
    }

    public void setNut_avg(double nut_avg) {
        this.nut_avg = nut_avg;
    }

    public String getNut_description() {
        return nut_description;
    }

    public void setNut_description(String nut_description) {
        this.nut_description = nut_description;
    }
}
