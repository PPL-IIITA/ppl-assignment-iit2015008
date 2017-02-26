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
public class boy {
   public String name , type ;
   public int attractiveness;
   public int intelligence ;
   public boolean relationshipStatus ;
   public String girlfriendName ;
   public int happinessLevel = 0;
   public int budgetLevel ;
   public int minimumAttractionRequirements ;
   public int costOfGifts ;
   
   public boy(String name , String type , int attractiveness , int budgetLevel ,int intelli, int minimumAttractionRequirements  ){
       this.name = name ;
       this.type = type ;
       this.attractiveness = attractiveness ;
       this.relationshipStatus = false ;
       this.girlfriendName = "" ;
       this.happinessLevel = 0 ;
       this.budgetLevel = budgetLevel ;
       this.minimumAttractionRequirements = minimumAttractionRequirements ;
       this.costOfGifts = 0;
       this.intelligence = intelli ;
   }
   
   public void setRelationshipStatus(){
       this.relationshipStatus = true ;
   }
   
   public void setGirlFriend(String name ){
      this.girlfriendName = name ;
  }
   
}
