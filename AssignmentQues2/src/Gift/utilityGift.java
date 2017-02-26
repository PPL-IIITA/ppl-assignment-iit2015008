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
public class utilityGift {
    public int cost , value ,utitValue , utitClass;
    public boolean isAvailable ;
    
    public utilityGift(int cost , int value , int utitValue , int utitClass){
        this.cost = cost ;
        this.value = value ;
        this.utitClass = utitClass ;
        this.utitValue = utitValue ;
        isAvailable = true ;
    }
    
    public void bought(boolean status){
        isAvailable = status ;
    }
}
