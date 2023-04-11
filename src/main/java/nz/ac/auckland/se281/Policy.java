package nz.ac.auckland.se281;

public abstract class Policy {
    
    private int premium;
    private int sumInsured;
    
    //constructor for life policy
    public Policy(int sumInsured, int premiumPercentage){
        this.premium=premiumPercentage*sumInsured/10000;
        this.sumInsured=sumInsured;
    }

    //constructor for car policy
    public Policy(int sumInsured, int age, String mechanicalBreakdown) {
        
        this.sumInsured=sumInsured;

        if(age<25){
            this.premium=15*sumInsured/100;
        }else{
            this.premium=10*sumInsured/100;
        }

        if (mechanicalBreakdown.equals("yes")){
            this.premium+=80;
        }
    }

    //constructor for home policy
    public Policy(int sumInsured, String Rental){

        this.sumInsured=sumInsured;

        if(Rental.equals("yes")){
            this.premium=2*sumInsured/100;
        }else{
            this.premium=1*sumInsured/100;
        }
    }

    public int getPremium(){
        return premium;
    }

    public String getSumInsured(){
        return Integer.toString(sumInsured);
    }
}
