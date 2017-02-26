/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gift;

/**
 *
 * @author rexxx
 */
public class luxuryGift {
    public int cost , value , luxuryRating , difficultyInObtaining ;
    public boolean isAvailable ;
    
    public luxuryGift(int cost , int value  , int rating , int obtain){
        this.cost = cost ; 
        this.value = value ;
        this.luxuryRating = rating ;
        this.difficultyInObtaining = obtain ;
        isAvailable = true ;
    }
    
    public void bought(boolean status){
        isAvailable = status ;
    }
}
