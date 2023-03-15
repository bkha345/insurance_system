package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  private String userName;
  private String age;

  public InsuranceSystem(String userName, String age) {
    this.userName = userName;
    this.age = age;
  }

  // initialises arraylist of users
  ArrayList<InsuranceSystem> userList = new ArrayList<InsuranceSystem>();

  public void printDatabase() {
    // checks how many profiles present
    int userCount = userList.size();

    switch (userCount) {
      case 1:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", " ", ":");
        break;
      case 0:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
      default:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(userCount), "s", ":");
        break;
    }

    // initilialises position number for users to be listed
    int pos = 0;

    // Lists each user using for each loop
    for (InsuranceSystem user : userList) {
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
          Integer.toString(pos), user.userName, user.age);
    }
  }

  public void createNewProfile(String userName, String age) {

    // checks if age is positive interger, if not returns error message
    if (Integer.parseInt(age) <= 0) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
      return;
    }

    // checks if username is more than 3 characters
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    }

    // checks if username is unique, if not returns error message
    for (InsuranceSystem user : userList) {
      if (user.userName.toLowerCase() == userName.toLowerCase()) {
        MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
      }
    }

    // if age and username is valid, puts profile in arraylist
    userList.add(new InsuranceSystem(userName, age));
  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
