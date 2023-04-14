package nz.ac.auckland.se281;

import java.util.ArrayList;

public class User {
  private String userName;
  private String age;
  private boolean loaded;
  private ArrayList<Policy> Policies = new ArrayList<Policy>();
  private boolean lifeInsured=false;
  private int numberOfPolicies=0;
  private int discount=0;

  public User(String userName, String age) {
    this.userName = userName;
    this.age = age;
    loaded = false;
  }

  public String getUserName() {
    return userName;
  }

  public String getAge() {
    return age;
  }

  public static String clean(String userName) {
    // removes all spaces in userName (for checking case where only spaces are added)
    String userNameWithoutSpace = userName.replaceAll(" ", "");

    // changes username to properly capitalised version
    String capitalisedUserName =
        userNameWithoutSpace.substring(0, 1).toUpperCase()
            + userNameWithoutSpace.substring(1).toLowerCase();
    return capitalisedUserName;
  }

  public void load() {
    this.loaded = true;
  }

  public void unload() {
    this.loaded = false;
  }

  public boolean getLoaded() {
    return loaded;
  }


  //creates policies and add to policy arraylist of specific user
  public void newLife(String[] options){
    Life life=new Life(Integer.parseInt(options[0]), Integer.parseInt(this.age));
    Policies.add(life);
  }

  public void newCar(String[] options){

    Car car=new Car (options, Integer.parseInt(this.age));
    Policies.add(car);
  }

  public void newHome(String[] options){
   
    Home home=new Home (options);
    Policies.add(home);
  }

  //determines if user is already life insured
  public boolean getlifeInsured(){
    return lifeInsured;
  }
  
  public void printPolicies(){
    for (Policy policy:Policies){
      if (policy instanceof Life){
        MessageCli.PRINT_DB_LIFE_POLICY.printMessage(policy.getSumInsured(),Integer.toString(policy.getPremium()),Integer.toString(policy.getPremium()*(100-discount)/100));
      }

      if (policy instanceof Car){
        Car car=(Car) policy;
        MessageCli.PRINT_DB_CAR_POLICY.printMessage(car.getMakeAndModel(), car.getSumInsured(), Integer.toString(car.getPremium()), Integer.toString(car.getPremium()*(100-discount)/100));
      }

      if (policy instanceof Home){
        Home home=(Home) policy;
        MessageCli.PRINT_DB_HOME_POLICY.printMessage(home.getAddress(), home.getSumInsured(), Integer.toString(home.getPremium()),Integer.toString(home.getPremium()*(100-discount)/100));
      }
    }
  }
  
  //getters for printDB
  public String getPolicyNumber(){

    //converts life insured boolean to integer by returning 1 if true and 0 if false
    numberOfPolicies= Boolean.compare(lifeInsured,false)+Policies.size();

    //sets discount based on number of policies
    if (numberOfPolicies==2){
      discount=10;
    }else if(numberOfPolicies>=3){
      discount=20;
    }

    //returns string version in order to be printed
    return Integer.toString(numberOfPolicies);
  }

  public String getPluralisation(){
    
    //prints "policy" if only 1, "policies" otherwise
    switch(numberOfPolicies){
      case (1):
      return "y";

      default:
      return "ies";
    }
  }

  public String getTotal(){
    int totalBeforeDiscount=0;

    //adds all premiums of user together
    for (Policy policy:Policies){
      totalBeforeDiscount+= policy.getPremium();
    }


    //returns premium after discount
    return Integer.toString(totalBeforeDiscount*(100-discount)/100);
  }

  public int getDiscount(){
    return discount;
  }


}
