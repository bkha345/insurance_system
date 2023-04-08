package nz.ac.auckland.se281;

public abstract class Policy {
    
    protected int premium;
    
    //constructor for life policy
    public Policy(int sumInsured, int premiumPercentage){
        this.premium=(premiumPercentage/100)*sumInsured;
    }

    //constructor for car policy
    public Policy(int sumInsured, int age, String mechanicalBreakdown) {
        
        if(age<25){
            premium=(15/100)*sumInsured;
        }else{
            premium=(10/100)*sumInsured;
        }

        if (mechanicalBreakdown.equals("yes")){
            premium+=80;
        }
    }

    //constructor for home policy
    public Policy(int sumInsured, String Rental){

        if(Rental.equals("yes")){
            premium=(2/100)*sumInsured;
        }else{
            premium=(1/100)*sumInsured;
        }
    }
}
