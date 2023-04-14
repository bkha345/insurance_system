package nz.ac.auckland.se281;

public class Life extends Policy {

  // returns percentage of sum insured for base premium
  public Life(int sumInsured, int age) {
    super(sumInsured, (100 + age));
  }
}
