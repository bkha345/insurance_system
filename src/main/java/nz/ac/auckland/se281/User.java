package nz.ac.auckland.se281;

public class User {
  private String userName;
  private String age;
  private boolean loaded;
  private Policy life;
  private Policy car;
  private Policy home;


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
}
