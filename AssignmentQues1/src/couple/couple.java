/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package couple;

/**
 *
 * @author rexxx
 */
public class couple {
    String boyName , girlName ;
    int happinessLevel , compatability , attractivenessDifference , intelligentDifference , budgetDifference ;
    
    public couple(String bName , String gName , int boyAttractiveness , int girlAttractiveness , int boyIntelligence , int girlIntelligence , int boyBudget , int girlBudget , int boyHappiness , int girlHappiness){
        this.boyName = bName ;
        this.girlName = gName ;
        int temp = (boyAttractiveness - girlAttractiveness);
        
        if(temp > 0)
            this.attractivenessDifference = temp ;
        else
            this.attractivenessDifference = (-1)*temp ;
        
        temp = (boyIntelligence - girlIntelligence);
        
        if(temp > 0)
            this.intelligentDifference = temp ;
        else
            this.intelligentDifference = (-1)*temp ;
        
        temp = boyBudget - girlBudget ;
        
        if(temp > 0)
            this.budgetDifference = temp ;
        else
            this.budgetDifference = (-1)*temp ;
        
        this.happinessLevel = boyHappiness + girlHappiness ;
    }
    
    public int getCompatibility(){
        return (this.attractivenessDifference + this.budgetDifference + this.intelligentDifference) ;
    }
    
    public void setCompatibility(){
        this.compatability = getCompatibility() ;
    }
}
