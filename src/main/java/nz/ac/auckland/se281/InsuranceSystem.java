package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  public InsuranceSystem() {}

  // initialises arraylist of users
  private ArrayList<User> userList = new ArrayList<User>();

  // Stores address of currently loaded user
  private User currentlyLoaded;

  // checks if any user is loaded, set to false initially
  private boolean loaded = false;

  public void printDatabase() {
    // checks how many profiles present
    int userCount = userList.size();

    // prints appropiate message
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
      if (user.getLoaded()) {
        MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
            "*** ",
            Integer.toString(pos),
            user.getUserName(),
            user.getAge(),
            user.getPolicyNumber(),
            user.getPluralisation(),
            user.getTotal());
      } else {
        MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
            "",
            Integer.toString(pos),
            user.getUserName(),
            user.getAge(),
            user.getPolicyNumber(),
            user.getPluralisation(),
            user.getTotal());
      }

      // prints each policy of user
      user.printPolicies();
      pos++;
    }
  }

  public void createNewProfile(String userName, String age) {

    String cleanedUsername = User.clean(userName);

    // checks if there is currently loaded profile
    if (loaded) {
      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(currentlyLoaded.getUserName());
      return;
    }

    // checks if age is positive interger, if not returns error message
    if (Integer.parseInt(age) <= 0) {
      MessageCli.INVALID_AGE.printMessage(age, cleanedUsername);
      return;
    }

    // checks if username is more than 3 characters
    if (cleanedUsername.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(cleanedUsername);
      return;
    }

    // checks if username is unique, if not returns error message
    for (User user : userList) {
      if (user.getUserName().toLowerCase().equals(cleanedUsername.toLowerCase())) {
        MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(cleanedUsername);
        return;
      }
    }

    // if age and username is valid puts profile in arraylist
    User newUser = new User(cleanedUsername, age);
    userList.add(newUser);
    MessageCli.PROFILE_CREATED.printMessage(cleanedUsername, age);
  }

  public void loadProfile(String userName) {

    // Puts input in title case
    String cleanedInput = User.clean(userName);

    // checks if desired profile exists
    for (User user : userList) {
      if (user.getUserName().equals(cleanedInput)) {
        MessageCli.PROFILE_LOADED.printMessage(cleanedInput);

        // unloads current loaded user
        if (loaded) {
          currentlyLoaded.unload();
        }
        // loads selected user and stores in variable
        user.load();
        currentlyLoaded = user;
        loaded = true;
        return;
      }
    }
    MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(cleanedInput);
  }

  public void unloadProfile() {

    // checks if any user is loaded, if yes unloads user
    if (loaded) {
      MessageCli.PROFILE_UNLOADED.printMessage(currentlyLoaded.getUserName());
      currentlyLoaded.unload();
      loaded = false;
    } else {
      MessageCli.NO_PROFILE_LOADED.printMessage();
    }
  }

  public void deleteProfile(String userName) {

    // Puts input in title case
    String cleanedInput = User.clean(userName);

    // checks if desired profile exists
    for (User user : userList) {
      if (user.getUserName().equals(cleanedInput)) {

        // checks if user is loaded, if yes returns error message
        if (user.getLoaded()) {
          MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(cleanedInput);
          return;
        }

        // removes user from arraylist
        userList.remove(user);
        MessageCli.PROFILE_DELETED.printMessage(cleanedInput);
        return;
      }
    }

    MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(cleanedInput);
  }

  public void createPolicy(PolicyType type, String[] options) {

    // does not create policy if profile is not loaded
    if (!loaded) {
      MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();
      return;
    }

    // checks if user is within age limit and no prior life policy is created
    switch (type) {
      case LIFE:
        if (currentlyLoaded.getlifeInsured()) {
          MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(currentlyLoaded.getUserName());
          return;
        } else if (Integer.parseInt(currentlyLoaded.getAge()) > 100) {
          MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(currentlyLoaded.getUserName());
          return;
        } else {
          currentlyLoaded.newLife(options);
          MessageCli.NEW_POLICY_CREATED.printMessage("life", currentlyLoaded.getUserName());
        }
        break;

      case CAR:
        currentlyLoaded.newCar(options);
        MessageCli.NEW_POLICY_CREATED.printMessage("car", currentlyLoaded.getUserName());
        break;

      case HOME:
        currentlyLoaded.newHome(options);
        MessageCli.NEW_POLICY_CREATED.printMessage("home", currentlyLoaded.getUserName());
        break;
    }
  }
}
