/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Girl;

/**
 *
 * @author rexxx
 */
public class girl {
   public String name , type ;
   public int attractiveness;
   public int intelligence ;
   public boolean relationshipStatus ;
   public String boyfriendName ;
   public int happinessLevel ;
   public int maintenanceBudget ;
   public String choosingCriterion ;
   
   public girl(String name , String type , int attractiveness , int maintenanceBudget , int intelligence , String choosingCriterion ){
       this.name = name ;
       this.attractiveness = attractiveness ;
       this.type = type ;
       this.relationshipStatus = false ;
       this.boyfriendName = "" ;
       this.happinessLevel = 0 ;
       this.intelligence = intelligence ;
       this.maintenanceBudget = maintenanceBudget ;
       this.choosingCriterion =  choosingCriterion ;
   }
   
   public void setRelationshipStatus(){
       this.relationshipStatus = true ;
   }
   
   public void setBoyFriend(String name ){
      this.boyfriendName = name ;
  
   }
   
}
