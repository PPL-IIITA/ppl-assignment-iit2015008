/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ques1;
import Boy.* ;
import Girl.* ;
import couple.* ;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author rexxx
 */

public class main {
        static boy  b[] = new boy[100] ;
       static girl g[] = new girl[100] ;
       static couple c[] = new couple[100] ;
    public static void main(String args[]) throws IOException{
       //*******************************************************************************************//  
          
       
        int i = 0;
        int ng = 0;
        int nb = 0 ;
        
        String csvFile = "girls.csv";
        String line = "";
        String cvsSplitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] girl = line.split(cvsSplitBy);
                String name = girl[0];
                String type = girl[1] ;
                int attractive = Integer.parseInt(girl[2]);
                int maintanence = Integer.parseInt(girl[3]);
                int intelligence = Integer.parseInt(girl[4]);
                String criter = girl[5] ;
                //System.out.println(girl[0] + " " + girl[1] + " " + girl[2] + " " + girl[3] + " " + girl[4] + " " + girl[5]);
                g[ng++] = new girl(name,type , attractive, maintanence, intelligence , criter);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
       
        csvFile = "boys.csv";
        i = 0 ;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] boy = line.split(cvsSplitBy);
                String name = boy[0];
                String type = boy[1] ;
                int attractive = Integer.parseInt(boy[2]);
                int maintanence = Integer.parseInt(boy[3]);
                int intelligence = Integer.parseInt(boy[4]);
                int minAttraction = Integer.parseInt(boy[5]) ;
               
                b[nb++] = new boy(name, type , attractive, maintanence, intelligence , minAttraction);
                
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        
        //System.out.println(nb);
        //System.out.println(ng);
       coupleMake(nb,ng) ;
      
       
    }
        
    
    public static void coupleMake(int nb , int ng) throws FileNotFoundException, IOException{
            
            int couple_id = 0;
            
            DataOutputStream logFile = new DataOutputStream(new FileOutputStream("log_couple.txt"));
            
            for(int i = 0 ; i < ng ; i++){
              
                int remember = -1 ;
                int max1 = 0 ;
                
                for(int j = 0 ; j < nb ; j++){
                    
                   
                    
                    if( b[j].relationshipStatus == false && b[j].budgetLevel >= g[i].maintenanceBudget && g[i].attractiveness >= b[j].minimumAttractionRequirements){
                        
                        if(g[i].choosingCriterion.equals("Attractive") ){
                            if(b[j].attractiveness > max1){
                                max1 = b[j].attractiveness ;
                                remember = j ;
                            }
                        }
                        if(g[i].choosingCriterion.equals("Intelligence") ){
                            if(b[j].intelligence > max1){
                                max1 = b[j].intelligence ;
                                remember = j ;
                            }
                        }
                        if(g[i].choosingCriterion.equals("Luxury") ){
                            if(b[j].budgetLevel > max1){
                                max1 = b[j].budgetLevel ;
                                remember = j ;
                            }
                        }
                    }
                }
                if(remember != -1){
                    c[couple_id] = new couple(b[remember].name , g[i].name , b[remember].attractiveness , g[i].attractiveness , b[remember].intelligence , g[i].intelligence , b[remember].budgetLevel , g[i].maintenanceBudget , b[remember].happinessLevel , g[i].happinessLevel) ;
                    c[couple_id].setCompatibility();
                    b[remember].setGirlFriend(g[i].name);
                    g[i].setBoyFriend(b[remember].name);
                    b[remember].setRelationshipStatus();
                    g[i].setRelationshipStatus();
                    logFile.writeBytes(g[i].name + " is in relationShip with " + b[remember].name + " on " + LocalDate.now() + " " + LocalTime.now() + "\n");
                }
                couple_id++ ;
                
            }
    }
 /**********************************************************************************************************/       
}
