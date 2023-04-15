package nz.ac.auckland.se281;

public class Home extends Policy {

  private String address;

  public Home(String[] options) {

    // returns rental and sumInsured to super constructor to find premium
    super(Integer.parseInt(options[0]), options[2]);
    address = options[1];
  }

  public String getAddress() {
    return address;
  }
}
