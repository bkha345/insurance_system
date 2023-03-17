package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  public InsuranceSystem() {}

  // initialises arraylist of users
  ArrayList<User> userList = new ArrayList<User>();

  public void printDatabase() {
    // checks how many profiles present
    int userCount = userList.size();

    switch (userCount) {
      case 1:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
        break;
      case 0:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
        break;
      default:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(userCount), "s", ":");
        break;
    }

    // initilialises position number for users to be listed
    int pos = 1;

    // Lists each user using for each loop
    for (User user : userList) {
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
          Integer.toString(pos), user.getUserName(), user.getAge());
      pos++;
    }
  }

  public void createNewProfile(String userName, String age) {

    // checks if age is positive interger, if not returns error message
    if (Integer.parseInt(age) <= 0) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
      return;
    }

    // removes all spaces in userName (for checking case where only spaces are added)
    String userNameWithoutSpace = userName.replaceAll(" ", "");

    // checks if username is more than 3 characters
    if (userNameWithoutSpace.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      return;
    }

    // checks if username is unique, if not returns error message
    for (User user : userList) {
      if (user.getUserName().toLowerCase() == userNameWithoutSpace.toLowerCase()) {
        MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
        return;
      }
    }

    // if age and username is valid, changes username to properly capitalised version, and puts
    // profile in arraylist
    String capitalisedUserName =
        userNameWithoutSpace.substring(0, 1).toUpperCase()
            + userNameWithoutSpace.substring(1).toLowerCase();
    User newUser = new User(capitalisedUserName, age);
    userList.add(newUser);
    MessageCli.PROFILE_CREATED.printMessage(capitalisedUserName, age);
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
