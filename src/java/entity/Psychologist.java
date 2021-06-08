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
public class Psychologist {
    private int psych_id ; 
    private String psych_name ; 
    private String psych_surname ; 
    private String psych_link ; 
    private String psych_number ; 
    private String psych_cv ; 
    private String psych_path ; 
    private String psych_gender ; 
    private int psych_age ; 
    private boolean psych_state ; 
    private int psych_count ; 
    private double psych_avg  ;
    private String psych_description ; 
    public Psychologist(){
        
    }

    public Psychologist(int psych_id, String psych_name, String psych_surname, String psych_link, String psych_number, String psych_cv, String psych_path, String psych_gender, int psych_age, boolean psych_state, int psych_count, double psych_avg, String psych_description) {
        this.psych_id = psych_id;
        this.psych_name = psych_name;
        this.psych_surname = psych_surname;
        this.psych_link = psych_link;
        this.psych_number = psych_number;
        this.psych_cv = psych_cv;
        this.psych_path = psych_path;
        this.psych_gender = psych_gender;
        this.psych_age = psych_age;
        this.psych_state = psych_state;
        this.psych_count = psych_count;
        this.psych_avg = psych_avg;
        this.psych_description = psych_description;
    }
    public Psychologist(String psych_name,String psych_surname,String psych_path){
        this.psych_name = psych_name;
        this.psych_surname = psych_surname;
        this.psych_path = psych_path;
    }

    public int getPsych_id() {
        return psych_id;
    }

    public void setPsych_id(int psych_id) {
        this.psych_id = psych_id;
    }

    public String getPsych_name() {
        return psych_name;
    }

    public void setPsych_name(String psych_name) {
        this.psych_name = psych_name;
    }

    public String getPsych_surname() {
        return psych_surname;
    }

    public void setPsych_surname(String psych_surname) {
        this.psych_surname = psych_surname;
    }

    public String getPsych_link() {
        return psych_link;
    }

    public void setPsych_link(String psych_link) {
        this.psych_link = psych_link;
    }

    public String getPsych_number() {
        return psych_number;
    }

    public void setPsych_number(String psych_number) {
        this.psych_number = psych_number;
    }

    public String getPsych_cv() {
        return psych_cv;
    }

    public void setPsych_cv(String psych_cv) {
        this.psych_cv = psych_cv;
    }

    public String getPsych_path() {
        return psych_path;
    }

    public void setPsych_path(String psych_path) {
        this.psych_path = psych_path;
    }

    public String getPsych_gender() {
        return psych_gender;
    }

    public void setPsych_gender(String psych_gender) {
        this.psych_gender = psych_gender;
    }

    public int getPsych_age() {
        return psych_age;
    }

    public void setPsych_age(int psych_age) {
        this.psych_age = psych_age;
    }

    public boolean isPsych_state() {
        return psych_state;
    }

    public void setPsych_state(boolean psych_state) {
        this.psych_state = psych_state;
    }

    public int getPsych_count() {
        return psych_count;
    }

    public void setPsych_count(int psych_count) {
        this.psych_count = psych_count;
    }

    public double getPsych_avg() {
        return psych_avg;
    }

    public void setPsych_avg(double psych_avg) {
        this.psych_avg = psych_avg;
    }

    public String getPsych_description() {
        return psych_description;
    }

    public void setPsych_description(String psych_description) {
        this.psych_description = psych_description;
    }
    
}
