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
public class PersonalTrainer {
    private int pt_id  ; 
    private String pt_name  ;
    private String pt_surname ; 
    private String pt_link ; 
    private String pt_number ; 
    private String pt_cv ; 
    private String pt_path ; 
    private String pt_gender ; 
    private int    pt_age ; 
    private boolean pt_state ;
    private int pt_count ; 
    private double pt_avg ; 
    private int pt_master ;
    private String description ; 
    
    public PersonalTrainer(){
        
    }

    public PersonalTrainer(int pt_id, String pt_name, String pt_surname, String pt_link, String pt_number, String pt_cv, String pt_path, String pt_gender, int pt_age, boolean pt_state, int pt_count, double pt_avg, int pt_master,
        String description) {
        this.pt_id = pt_id;
        this.pt_name = pt_name;
        this.pt_surname = pt_surname;
        this.pt_link = pt_link;
        this.pt_number = pt_number;
        this.pt_cv = pt_cv;
        this.pt_path = pt_path;
        this.pt_gender = pt_gender;
        this.pt_age = pt_age;
        this.pt_state = pt_state;
        this.pt_count = pt_count;
        this.pt_avg = pt_avg;
        this.pt_master = pt_master;
        this.description = description ; 
        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    public int getPt_id() {
        return pt_id;
    }

    public void setPt_id(int pt_id) {
        this.pt_id = pt_id;
    }

    public String getPt_name() {
        return pt_name;
    }

    public void setPt_name(String pt_name) {
        this.pt_name = pt_name;
    }

    public String getPt_surname() {
        return pt_surname;
    }

    public void setPt_surname(String pt_surname) {
        this.pt_surname = pt_surname;
    }

    public String getPt_link() {
        return pt_link;
    }

    public void setPt_link(String pt_link) {
        this.pt_link = pt_link;
    }

    public String getPt_number() {
        return pt_number;
    }

    public void setPt_number(String pt_number) {
        this.pt_number = pt_number;
    }

    public String getPt_cv() {
        return pt_cv;
    }

    public void setPt_cv(String pt_cv) {
        this.pt_cv = pt_cv;
    }

    public String getPt_path() {
        return pt_path;
    }

    public void setPt_path(String pt_path) {
        this.pt_path = pt_path;
    }

    public String getPt_gender() {
        return pt_gender;
    }

    public void setPt_gender(String pt_gender) {
        this.pt_gender = pt_gender;
    }

    public int getPt_age() {
        return pt_age;
    }

    public void setPt_age(int pt_age) {
        this.pt_age = pt_age;
    }

    public boolean isPt_state() {
        return pt_state;
    }

    public void setPt_state(boolean pt_state) {
        this.pt_state = pt_state;
    }

    public int getPt_count() {
        return pt_count;
    }

    public void setPt_count(int pt_count) {
        this.pt_count = pt_count;
    }

    public double getPt_avg() {
        return pt_avg;
    }

    public void setPt_avg(double pt_avg) {
        this.pt_avg = pt_avg;
    }

    public int getPt_master() {
        return pt_master;
    }

    public void setPt_master(int pt_master) {
        this.pt_master = pt_master;
    }
}
