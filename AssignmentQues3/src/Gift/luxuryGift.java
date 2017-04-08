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
public class luxuryGift extends gift{ //gift is parent class
    public int  luxuryRating , difficultyInObtaining ;
    
    public luxuryGift(int cost , int value  , int rating , int obtain){
        this.cost = cost ; 
        this.value = value ;
        this.luxuryRating = rating ;
        this.difficultyInObtaining = obtain ;
        isAvailable = true ;
    }
     
    public void bought(boolean status){ //abstract function definition
        isAvailable = status ; //availability of gift
    }
}
