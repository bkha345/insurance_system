package nz.ac.auckland.se281;

import java.util.ArrayList;

public class User {
  private String userName;
  private String age;
  private boolean loaded;
  private Policy life;
  private ArrayList<Car> carPolicies = new ArrayList<Car>();
  private ArrayList<Home> homePolicies = new ArrayList<Home>();
  private boolean lifeInsured=false;

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

  public void newLife(String[] options){
    Life life=new Life(Integer.parseInt(options[0]), Integer.parseInt(this.age));
  }

  public void newCar(String[] options){

    Car car=new Car (options, Integer.parseInt(this.age));
    carPolicies.add(car);
  }

  public void newHouse(String[] options){
   
    Home home=new Home (options);
    homePolicies.add(home);
  }

  public boolean getlifeInsured(){
    return lifeInsured;
  }
}
