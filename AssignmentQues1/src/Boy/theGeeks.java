/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boy;

/**
 *
 * @author rexxx
 */
public class theGeeks {
   public String name ;
   public  int attractiveness;
   int intelligence ;
   boolean relationshipStatus ;
   String girlfriendName ;
   int happinessLevel = 0;
   int budgetLevel ;
   int minimumAttractionRequirements ;
    int costOfGifts ;
   
   theGeeks(String name , int attractiveness , int budgetLevel , int minimumAttractionRequirements , int intelli){
       this.name = name ;
       this.attractiveness = attractiveness ;
       this.relationshipStatus = false ;
       this.girlfriendName = "" ;
       this.happinessLevel = 0 ;
       this.budgetLevel = budgetLevel ;
       this.minimumAttractionRequirements = minimumAttractionRequirements ;
       this.costOfGifts = 0;
       this.intelligence = intelli ;
   }
   
   void setRelationshipStatus(boolean status){
       this.relationshipStatus = true ;
   }
   
    void setGirlFriend(String name ){
      this.girlfriendName = name ;
  }
   
}
