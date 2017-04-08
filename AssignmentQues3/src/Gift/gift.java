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
public abstract class gift {
    public int cost , value ;
    public boolean isAvailable ;
    
    /**
     *
     * @param status
     */
    public abstract void  bought(boolean status); //abstract function declaration 
}
