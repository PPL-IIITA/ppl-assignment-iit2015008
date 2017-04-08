/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentques3;

import Boy.boy;
import Gift.essentialGift;
import Gift.luxuryGift;
import Gift.utilityGift;
import Girl.girl;
import couple.couple;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author rexxx
 */
public class AssignmentQues3 {
        static boy  b[] = new boy[100] ;
        static girl g[] = new girl[100] ;
        static couple c[] = new couple[100] ; 
        static essentialGift eGift[] = new essentialGift[100] ;
        static luxuryGift lGift[] = new luxuryGift[100] ;
        static utilityGift uGift[] = new utilityGift[100] ;
        static int couple_id = 0;
        
        
         static void swap(couple couple[],int a,int b)
        {
            String boy_name=couple[a].boyName;
            String girl_name=couple[a].girlName;
            int happiness=couple[a].happinessLevel;
            int compatibility=couple[a].compatability;
            int attractiveness_diff=couple[a].attractivenessDifference;
            int intelligence_diff=couple[a].intelligentDifference;
            int budget_diff=couple[a].budgetDifference;
            int boyindex=couple[a].bIndex;
            int girlindex=couple[a].gIndex;
            couple[a].boyName=couple[b].boyName;
            couple[a].girlName=couple[b].girlName;
            couple[a].happinessLevel=couple[b].happinessLevel;
            couple[a].compatability=couple[b].compatability;
            couple[a].attractivenessDifference=couple[b].attractivenessDifference;
            couple[a].intelligentDifference=couple[b].intelligentDifference;
            couple[a].budgetDifference=couple[b].budgetDifference;
            couple[a].bIndex=couple[b].bIndex;
            couple[a].gIndex=couple[b].gIndex;
            couple[b].boyName=boy_name;
            couple[b].girlName=girl_name;
            couple[b].happinessLevel=happiness;
            couple[b].compatability=compatibility;
            couple[b].attractivenessDifference=attractiveness_diff;
            couple[b].intelligentDifference=intelligence_diff;
            couple[b].budgetDifference=budget_diff;
            couple[b].bIndex=boyindex;
            couple[b].gIndex=girlindex;
        }

        
    static void mostCompatible(int k) throws FileNotFoundException, IOException{
        for(int i = 0 ; i < couple_id ; i++){
            for(int j = 0 ; j < couple_id-i-1 ; j++){
                if(c[j].compatability < c[j+1].compatability){
                    swap(c , j , j+1) ;
                }   
            }
        }
        DataOutputStream logFile3 = new DataOutputStream(new FileOutputStream("log3_compatibleCouple.txt"));
        for(int i = 0 ; i < k ; i++){
            logFile3.writeBytes("Compatible Couple " + (i+1) + " Boys name: " + c[i].boyName + " and " + " Girl name:" + c[i].girlName +" has compatible value " + c[i].compatability+ " on " + LocalDate.now() + " " + LocalTime.now() + "\n");
        }
    } 
    
    static void happiestCompatible(int k) throws FileNotFoundException, IOException{
        for(int i = 0 ; i < couple_id-1 ; i++){
            for(int j = 0 ; j < couple_id-i-1 ; j++){
                if(c[j].happinessLevel < c[j+1].happinessLevel){
                    swap(c , j , j+1) ;
                }   
            }
        }
        
    DataOutputStream logFile3 = new DataOutputStream(new FileOutputStream("log4_happiestCouple.txt"));
        for(int i = 0 ; i < k ; i++){
            logFile3.writeBytes("Happiest Couple " + (i+1) + " Boys name: " + c[i].boyName + " and " + " Girl name:" + c[i].girlName +" has happiness level " + c[i].happinessLevel+ " on " + LocalDate.now() + " " + LocalTime.now() + "\n");
        }
    } 
        
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException{
       //*******************************************************************************************//  
         //System.out.println("Working Directory = " +
         //     System.getProperty("user.dir")); 
        
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
        
        csvFile = "essentialGift.csv";
        int essentialGiftCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] gift = line.split(cvsSplitBy);
                int cost = Integer.parseInt(gift[0]);
                int value = Integer.parseInt(gift[1]) ;
                eGift[essentialGiftCount++] = new essentialGift(cost, value);
                
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        csvFile = "luxuryGift.csv";
        int luxuryGiftCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] gift = line.split(cvsSplitBy);
                int cost = Integer.parseInt(gift[0]);
                int value = Integer.parseInt(gift[1]) ;
                int rating = Integer.parseInt(gift[2]) ;
                int obtain = Integer.parseInt(gift[3]) ;
                lGift[luxuryGiftCount++] = new luxuryGift(cost, value , rating , obtain);
                
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        csvFile = "utilityGift.csv";
        int utilityGiftCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] gift = line.split(cvsSplitBy);
                int cost = Integer.parseInt(gift[0]);
                int value = Integer.parseInt(gift[1]) ;
                int uValue = Integer.parseInt(gift[2]) ;
                int uClass = Integer.parseInt(gift[3]) ;
                uGift[utilityGiftCount++] = new utilityGift(cost, value , uValue , uClass);
                
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        
       int k = 4 ; //k most happiest couple
       coupleMake(nb,ng) ;
       exchangeGifts(nb,ng,essentialGiftCount , luxuryGiftCount , utilityGiftCount) ;
       mostCompatible(5) ;
       happiestCompatible(5) ;
       
    }
        
    /**
     *
     * @param nb
     * @param ng
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void coupleMake(int nb , int ng) throws FileNotFoundException, IOException{
            
            
            
            DataOutputStream logFile1 = new DataOutputStream(new FileOutputStream("log1_couple.txt"));
            
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
                    c[couple_id] = new couple(b[remember].name , g[i].name , b[remember].attractiveness , g[i].attractiveness , b[remember].intelligence , g[i].intelligence , b[remember].budgetLevel , g[i].maintenanceBudget , b[remember].happinessLevel , g[i].happinessLevel , remember , i) ;
                    c[couple_id].setCompatibility();
                    b[remember].setGirlFriend(g[i].name);
                    g[i].setBoyFriend(b[remember].name);
                    b[remember].setRelationshipStatus();
                    g[i].setRelationshipStatus();
                    couple_id++ ;
                    logFile1.writeBytes(g[i].name + " is in relationShip with " + b[remember].name + " on " + LocalDate.now() + " " + LocalTime.now() + "\n");
                }
                
                
            }
    }
    
    /**
     *
     * @param nb
     * @param ng
     * @param essentialGiftCount
     * @param luxuryGiftCount
     * @param utilityGiftCount
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void exchangeGifts(int nb , int ng ,  int essentialGiftCount ,int luxuryGiftCount ,int utilityGiftCount) throws FileNotFoundException, IOException {
        
        DataOutputStream logFile2 = new DataOutputStream(new FileOutputStream("log2_exchangeGifts.txt"));
        
        //System.out.println(couple_id);
        
        for(int i = 0 ; i < couple_id ; i++){
            
            int totalValue = 0;
            int bIndex = c[i].bIndex , gIndex = c[i].gIndex ;
            //System.out.print(c[i].boyName + " " + c[i].girlName);
            if( b[bIndex].type.equals("Miser") ){
                for(int j = 0 ; j < essentialGiftCount ; j++){
                    if(eGift[j].isAvailable == true && g[gIndex].maintenanceBudget - g[gIndex].giftCosts >= 0 && b[bIndex].budgetLevel - b[bIndex].costOfGifts >= eGift[j].cost){
                        logFile2.writeBytes(b[bIndex].name + " gifted to " + g[gIndex].name + " a essential gift of cost " + eGift[j].cost + " on "+ LocalDate.now() + " " + LocalTime.now() + "\n");
                        b[bIndex].costOfGifts = b[bIndex].costOfGifts + eGift[j].cost ;
                        g[gIndex].giftCosts = g[gIndex].giftCosts + eGift[j].cost ;
                        totalValue = totalValue + eGift[j].value ;
                        eGift[j].bought(false);
                        //System.out.print(eGift[j].isAvailable);
                    }
                }
                
                for(int j = 0 ; j < utilityGiftCount ; j++){
                    if(uGift[j].isAvailable == true && g[gIndex].maintenanceBudget - g[gIndex].giftCosts >= 0 && b[bIndex].budgetLevel - b[bIndex].costOfGifts >= uGift[j].cost){
                        logFile2.writeBytes(b[bIndex].name + " gifted to " + g[gIndex].name + " a utility gift of cost " + uGift[j].cost + " on "+ LocalDate.now() + " " + LocalTime.now() + "\n");
                        b[bIndex].costOfGifts = b[bIndex].costOfGifts + uGift[j].cost ;
                        g[gIndex].giftCosts = g[gIndex].giftCosts + uGift[j].cost ;
                        totalValue = totalValue + uGift[j].value ;
                        uGift[j].bought(false);
                    }
                }
                
                for(int j = 0 ; j < luxuryGiftCount ; j++){
                    if(lGift[j].isAvailable == true && g[gIndex].maintenanceBudget - g[gIndex].giftCosts >= 0 && b[bIndex].budgetLevel - b[bIndex].costOfGifts >= lGift[j].cost){
                        logFile2.writeBytes(b[bIndex].name + " gifted to " + g[gIndex].name + " a luxury gift of cost " + lGift[j].cost + " on "+ LocalDate.now() + " " + LocalTime.now() + "\n");
                        b[bIndex].costOfGifts = b[bIndex].costOfGifts + lGift[j].cost ;
                        g[gIndex].giftCosts = g[gIndex].giftCosts + lGift[j].cost ;
                        totalValue = totalValue + lGift[j].value ;
                        lGift[j].bought(false);
                    }
                }
                
                if(g[gIndex].type.equalsIgnoreCase("Choosy")){
                    g[gIndex].happinessLevel = (int)log(g[gIndex].giftCosts) ;
                }
                if(g[gIndex].type.equalsIgnoreCase("Desperate")){
                    g[gIndex].happinessLevel = (int)pow(1,g[gIndex].giftCosts) ;
                }
                if(g[gIndex].type.equalsIgnoreCase("Normal")){
                    g[gIndex].happinessLevel = g[gIndex].giftCosts + totalValue ;
                }
                
                b[bIndex].happinessLevel = b[bIndex].budgetLevel - b[bIndex].costOfGifts ; ; 
            }
            
            if( b[bIndex].type.equals("Generous") ){
                for(int j = 0 ; j < essentialGiftCount ; j++){
                    if(eGift[j].isAvailable == true && b[bIndex].budgetLevel - b[bIndex].costOfGifts >= eGift[j].cost){
                        logFile2.writeBytes(b[bIndex].name + " gifted to " + g[gIndex].name + " a essential gift of cost " + eGift[j].cost + " on "+ LocalDate.now() + " " + LocalTime.now() + "\n");
                        b[bIndex].costOfGifts = b[bIndex].costOfGifts + eGift[j].cost ;
                        g[gIndex].giftCosts = g[gIndex].giftCosts + eGift[j].cost ;
                        totalValue = totalValue + eGift[j].value ;
                        eGift[j].bought(false);
                    }
                }
                
                for(int j = 0 ; j < utilityGiftCount ; j++){
                    if(uGift[j].isAvailable == true && b[bIndex].budgetLevel - b[bIndex].costOfGifts >= uGift[j].cost){
                        logFile2.writeBytes(b[bIndex].name + " gifted to " + g[gIndex].name + " a utility gift of cost " + uGift[j].cost + " on "+ LocalDate.now() + " " + LocalTime.now() + "\n");
                        b[bIndex].costOfGifts = b[bIndex].costOfGifts + uGift[j].cost ;
                        g[gIndex].giftCosts = g[gIndex].giftCosts + uGift[j].cost ;
                        totalValue = totalValue + uGift[j].value ;
                        uGift[j].bought(false);
                    }
                }
                
                for(int j = 0 ; j < luxuryGiftCount ; j++){
                    if(lGift[j].isAvailable == true && b[bIndex].budgetLevel - b[bIndex].costOfGifts >= lGift[j].cost){
                        logFile2.writeBytes(b[bIndex].name + " gifted to " + g[gIndex].name + " a luxury gift of cost " + lGift[j].cost + " on "+ LocalDate.now() + " " + LocalTime.now() + "\n");
                        b[bIndex].costOfGifts = b[bIndex].costOfGifts + lGift[j].cost ;
                        g[gIndex].giftCosts = g[gIndex].giftCosts + lGift[j].cost ;
                        totalValue = totalValue + lGift[j].value ;
                        lGift[j].bought(false);
                    }
                }
                
                if(g[gIndex].type.equalsIgnoreCase("Choosy")){
                    g[gIndex].happinessLevel = (int)log(g[gIndex].giftCosts) ;
                }
                if(g[gIndex].type.equalsIgnoreCase("Desperate")){
                    g[gIndex].happinessLevel = (int)pow(1,g[gIndex].giftCosts) ;
                }
                if(g[gIndex].type.equalsIgnoreCase("Normal")){
                    g[gIndex].happinessLevel = g[gIndex].giftCosts + totalValue ;
                }
                
                b[bIndex].happinessLevel = g[gIndex].happinessLevel ;
            }
            
            if( b[bIndex].type.equals("Geeks") ){
                for(int j = 0 ; j < essentialGiftCount ; j++){
                    if(eGift[j].isAvailable == true && g[gIndex].maintenanceBudget - g[gIndex].giftCosts >= 0 && b[bIndex].budgetLevel - b[bIndex].costOfGifts >= eGift[j].cost){
                        logFile2.writeBytes(b[bIndex].name + " gifted to " + g[gIndex].name + " a essential gift of cost " + eGift[j].cost + " on "+ LocalDate.now() + " " + LocalTime.now() + "\n");
                        b[bIndex].costOfGifts = b[bIndex].costOfGifts + eGift[j].cost ;
                        g[gIndex].giftCosts = g[gIndex].giftCosts + eGift[j].cost ;
                        totalValue = totalValue + eGift[j].value ;
                        eGift[j].bought(false);
                    }
                }
                
                for(int j = 0 ; j < utilityGiftCount ; j++){
                    if(uGift[j].isAvailable == true && g[gIndex].maintenanceBudget - g[gIndex].giftCosts >= 0 && b[bIndex].budgetLevel - b[bIndex].costOfGifts >= uGift[j].cost){
                        logFile2.writeBytes(b[bIndex].name + " gifted to " + g[gIndex].name + " a utility gift of cost " + uGift[j].cost + " on "+ LocalDate.now() + " " + LocalTime.now() + "\n");
                        b[bIndex].costOfGifts = b[bIndex].costOfGifts + uGift[j].cost ;
                        g[gIndex].giftCosts = g[gIndex].giftCosts + uGift[j].cost ;
                        totalValue = totalValue + uGift[j].value ;
                        uGift[j].bought(false);
                    }
                }
                
                for(int j = 0 ; j < luxuryGiftCount ; j++){
                    if(lGift[j].isAvailable == true && g[gIndex].maintenanceBudget - g[gIndex].giftCosts >= 0 && b[bIndex].budgetLevel - b[bIndex].costOfGifts >= lGift[j].cost){
                        logFile2.writeBytes(b[bIndex].name + " gifted to " + g[gIndex].name + " a luxury gift of cost " + lGift[j].cost + " on "+ LocalDate.now() + " " + LocalTime.now() + "\n");
                        b[bIndex].costOfGifts = b[bIndex].costOfGifts + lGift[j].cost ;
                        g[gIndex].giftCosts = g[gIndex].giftCosts + lGift[j].cost ;
                        totalValue = totalValue + lGift[j].value ;
                        lGift[j].bought(false);
                    }
                }
                
                for(int j = 0 ; j < luxuryGiftCount ; j++){
                    if(lGift[j].isAvailable == true && b[bIndex].budgetLevel - b[bIndex].costOfGifts >= lGift[j].cost){
                        logFile2.writeBytes(b[bIndex].name + " gifted to " + g[gIndex].name + " a last luxury gift of cost " + lGift[j].cost + " on "+ LocalDate.now() + " " + LocalTime.now() + "\n");
                        b[bIndex].costOfGifts = b[bIndex].costOfGifts + lGift[j].cost ;
                        g[gIndex].giftCosts = g[gIndex].giftCosts + lGift[j].cost ;
                        totalValue = totalValue + lGift[j].value ;
                        lGift[j].bought(false);
                        break ;
                    }
                }
                if(g[gIndex].type.equalsIgnoreCase("Choosy")){
                    g[gIndex].happinessLevel = (int)log(g[gIndex].giftCosts) ;
                }
                if(g[gIndex].type.equalsIgnoreCase("Desperate")){
                    g[gIndex].happinessLevel = (int)pow(1,g[gIndex].giftCosts) ;
                }
                if(g[gIndex].type.equalsIgnoreCase("Normal")){
                    g[gIndex].happinessLevel = g[gIndex].giftCosts + totalValue;
                }
                
                b[bIndex].happinessLevel = g[gIndex].intelligence ;
            }
            
            c[i].happinessLevel = b[bIndex].happinessLevel + g[gIndex].happinessLevel ;
            //System.out.println(b[bIndex].name + " " +b[bIndex].happinessLevel + " " + g[gIndex].name + " "+ g[gIndex].happinessLevel);
        }
        
    }
    
}
