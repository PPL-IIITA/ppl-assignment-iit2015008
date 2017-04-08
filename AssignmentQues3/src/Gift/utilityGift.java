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
public class utilityGift extends gift{ //gift is parent class
    public int utitValue , utitClass; 
    
    public utilityGift(int cost , int value , int utitValue , int utitClass){
        this.cost = cost ; 
        this.value = value ;
        this.utitClass = utitClass ;
        this.utitValue = utitValue ;
        this.isAvailable = true ;
    }
    
    @Override
    public void bought(boolean status){ //abstract function definition
        isAvailable = status ; //availability of gift
    }
}
