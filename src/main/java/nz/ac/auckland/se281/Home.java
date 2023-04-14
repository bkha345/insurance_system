package nz.ac.auckland.se281;

public class Home extends Policy {

  private String Address;

  public Home(String[] options) {

    // returns rental and sumInsured to super constructor to find premium
    super(Integer.parseInt(options[0]), options[2]);
    Address = options[1];
  }

  public String getAddress() {
    return Address;
  }
}
