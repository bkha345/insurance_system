package nz.ac.auckland.se281;

public class Home extends Policy{
    
    private String Address;

    public Home(String[] options){
        
        super(Integer.parseInt(options[0]),options[2]);
        Address=options[2];
    
    }

}
