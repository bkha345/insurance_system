package nz.ac.auckland.se281;

public class Car extends Policy {

  String makeAndModel;
  String licensePlate;
  boolean mechanicalBreakdown;

  public Car(String[] options, int age) {

    // returns breakdown and sumInsured to super constructor to find premium
    super(Integer.parseInt(options[0]), age, options[3]);
    this.makeAndModel = options[1];
    this.licensePlate = options[2];
  }

  public String getMakeAndModel() {
    return makeAndModel;
  }
}
