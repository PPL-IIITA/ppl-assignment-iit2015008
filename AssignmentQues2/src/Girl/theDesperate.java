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
public class theDesperate {
   String name ;
   int attractiveness;
   int intelligence ;
   boolean relationshipStatus ;
   String boyfriendName ;
   int happinessLevel ;
   int maintenanceBudget ;
   String choosingCriterion ;
   
   theDesperate(String name , int attractiveness , int maintenanceBudget , String choosingCriterion ){
       this.name = name ;
       this.attractiveness = attractiveness ;
       this.relationshipStatus = false ;
       this.boyfriendName = "" ;
       this.happinessLevel = 0 ;
       this.maintenanceBudget = maintenanceBudget ;
       this.choosingCriterion = choosingCriterion ; 
   }
   
   void setRelationshipStatus(boolean status){
       this.relationshipStatus = status ;
   }
   
    void setBoyFriend(String name ){
      this.boyfriendName = name ;
  }
   
}
