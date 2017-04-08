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
public class essentialGift extends gift { //gift is parent class
    
    public essentialGift(int cost , int value ){
        this.cost = cost ;
        this.value = value ;
        isAvailable = true ;
    }
    
    public void bought(boolean status){ //abstract function definition
        isAvailable = status ; //availability of gift
    }
}
