/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import util.DBConnection ; 
import entity.PersonalTrainer ; 

import java.sql.Connection ; 
import java.sql.PreparedStatement ; 
import java.sql.ResultSet ; 
import java.util.ArrayList ; 

public class PersonalTrainerDAO {
    Connection connection = null ; 
    DBConnection dbConnection = null ; 
    PreparedStatement preparedStatement = null ; 
    ResultSet resultSet = null  ; 
    private ArrayList<PersonalTrainer> personalTrainer = null ; 

    public ArrayList<PersonalTrainer> getPersonalTrainer() {
        return personalTrainer;
    }

    public void setPersonalTrainer(ArrayList<PersonalTrainer> personalTrainer) {
        this.personalTrainer = personalTrainer;
    }
    
    public ArrayList<PersonalTrainer> getPersonalTrainerList(boolean female, boolean male,boolean age25P,boolean age30P,boolean age35P,
            boolean age40P, boolean age45P,boolean highLicense, boolean license , boolean strong,boolean strength,
            boolean sedanter,boolean fitness,boolean star5,boolean star4,boolean star3,boolean star2,boolean star1){
        String query = "select * from PTS " ;
        if(female || male || age25P || age30P || age35P || age40P || age45P || 
                highLicense || license || strong || strength || sedanter || fitness || star5 || star4 ||
                star3 || star2 || star1){
            query +=" where ( " ;
            
            if(female || male){
                query +=" ( " ;
                
                if(female){
                    query += "( PT_GENDER = 'female' )  " ;
                    if(male){
                        query +=" or  " ; 
                    }
                }
                if(male){
                    query +=" ( PT_GENDER = 'male'  ) " ; 
                }
                query += " ) " ; 
            }
            if(age25P || age30P || age35P || age40P || age45P){
              if(female || male ){
                  query +=" and  " ; 
              } 
              query +=" ( " ;
              if(age25P){
                  query += " ( PT_AGE >= 25  )" ; 
              }
              else{
                  if(age30P){
                      query += " ( PT_AGE >= 30 )  " ; 
                  }
                  else{
                      if(age35P){
                          query+=" ( PT_AGE >= 35 )  " ; 
                      }
                      else{
                          if(age40P){
                              query+= " ( PT_AGE >=40  ) " ; 
                          }
                          else{
                              if(age45P){
                                  query += "  ( PT_AGE >=45 )  "  ; 
                              }
                          }
                      }
                  }
                  
              }
              
              query += "  )  " ; 
              
            }
            if(highLicense || license){
              if(!(age25P || age30P || age35P || age40P || age45P) && !(female || male)  ){
                    
              }
              else{
                  query += " and " ; 
              }
              query += " ( "  ;
              
              if(highLicense){
                  query += " ( PT_STATE = true  ) " ;
                  if(license){
                      query += " or "  ;
                  }
              }
              if(license){
                  query += " ( PT_STATE = false   ) " ; 
              }
              
              query +="   ) " ; 
                
            }
            if(strong || strength || sedanter || fitness){
                if(!(age25P || age30P || age35P || age40P || age45P) && !(female || male) && !(highLicense || license)){
                    
                }
                else{
                    query += " and " ; 
                }
                query += " ( "  ;
                if(strong){
                    query += " ( PT_MASTER = 1   ) "  ;
                    if(strength || sedanter || fitness){
                        query += " or  " ; 
                    }
                }
                if(strength){
                    query += " ( PT_MASTER = 2  ) "  ;
                    if(sedanter || fitness){
                        query += " or " ; 
                    }
                }
                if(sedanter){
                    query += " ( PT_MASTER = 3 ) " ; 
                    if(fitness){
                    query += " or " ; 
                }
                }

                if(fitness){
                    query += " ( PT_MASTER = 4  )  " ; 
                }
                query += "  ) " ; 
            }
            if( star5 || star4 ||star3 || star2 || star1){
                if(!(age25P || age30P || age35P || age40P || age45P) && !(female || male) && !(highLicense || license) && !(strong || strength || sedanter || fitness) ){
                    
                }
                else{
                    query +=" and " ; 
                }
                query += " ( "  ; 
                if(star1){
                    query += " ( PT_AVG >= 1  ) " ; 
                }
                else{
                    if(star2){
                        query += " ( PT_AVG >= 2  ) " ; 
                    }
                    else{
                        if(star3){
                            query += " ( PT_AVG >= 3  ) " ; 
                        }
                        else{
                            if(star4){
                                query += " ( PT_AVG >= 4  ) " ; 
                            }
                            else{
                                if(star5){
                                    query += " ( PT_AVG >= 5  ) " ; 
                                }
                                else{
                                    
                                }
                            }
                        }
                    }
                }
                
                
                query += "   )  " ; 
            }
            
                
            query +=" )" ;     
        }
        
        dbConnection = new DBConnection();
        connection = dbConnection.createConnection() ; 
        try{
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery() ; 
            personalTrainer = new ArrayList<>();
            while(resultSet.next()){
                personalTrainer.add(new PersonalTrainer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),
                resultSet.getInt(9),resultSet.getBoolean(10),resultSet.getInt(11),resultSet.getDouble(12),resultSet.getInt(13),
                        resultSet.getString(14)));
            }
            return personalTrainer ; 
            
            
        }catch(Exception e1){
            e1.printStackTrace();
        }
        return null ; 
    }
}
