/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.faces.bean.ManagedBean ; 
import javax.faces.bean.RequestScoped ; 

@ManagedBean
@RequestScoped
public class PersonalTrainerPageBean {
    //  Cinsiyet
    private boolean female = false ;
    private boolean male = false ; 
    //  Yas
    private boolean age25P = false ; 
    private boolean age30p = false ; 
    private boolean age35p = false ; 
    private boolean age40P = false ;
    private boolean age45P = false ; 
    //  Egitim Durumu
    private boolean highLicense = false ; 
    private boolean license = false ;
    //  Uzmanlık
    private boolean strong = false ;
    private boolean strength = false ; 
    private boolean sedanter = false ; 
    //  Derecelendirme
    private boolean star5 = false ; 
    private boolean star4 = false ; 
    private boolean star3 = false ; 
    private boolean star2 = false ; 
    private boolean star1 = false ; 

    public boolean isFemale() {
        return female;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isAge25P() {
        return age25P;
    }

    public void setAge25P(boolean age25P) {
        this.age25P = age25P;
    }

    public boolean isAge30p() {
        return age30p;
    }

    public void setAge30p(boolean age30p) {
        this.age30p = age30p;
    }

    public boolean isAge35p() {
        return age35p;
    }

    public void setAge35p(boolean age35p) {
        this.age35p = age35p;
    }

    public boolean isAge40P() {
        return age40P;
    }

    public void setAge40P(boolean age40P) {
        this.age40P = age40P;
    }

    public boolean isAge45P() {
        return age45P;
    }

    public void setAge45P(boolean age45P) {
        this.age45P = age45P;
    }

    public boolean isHighLicense() {
        return highLicense;
    }

    public void setHighLicense(boolean highLicense) {
        this.highLicense = highLicense;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    public boolean isStrong() {
        return strong;
    }

    public void setStrong(boolean strong) {
        this.strong = strong;
    }

    public boolean isStrength() {
        return strength;
    }

    public void setStrength(boolean strength) {
        this.strength = strength;
    }

    public boolean isSedanter() {
        return sedanter;
    }

    public void setSedanter(boolean sedanter) {
        this.sedanter = sedanter;
    }

    public boolean isStar5() {
        return star5;
    }

    public void setStar5(boolean star5) {
        this.star5 = star5;
    }

    public boolean isStar4() {
        return star4;
    }

    public void setStar4(boolean star4) {
        this.star4 = star4;
    }

    public boolean isStar3() {
        return star3;
    }

    public void setStar3(boolean star3) {
        this.star3 = star3;
    }

    public boolean isStar2() {
        return star2;
    }

    public void setStar2(boolean star2) {
        this.star2 = star2;
    }

    public boolean isStar1() {
        return star1;
    }

    public void setStar1(boolean star1) {
        this.star1 = star1;
    }
    public String filtreleme(){
        // to do something.
        return null ; 
    }
    
}
