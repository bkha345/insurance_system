package nz.ac.auckland.se281;

public class User {
  private String userName;
  private String age;

  public User(String userName, String age) {
    this.userName = userName;
    this.age = age;
  }

  public String getUserName() {
    return userName;
  }

  public String getAge() {
    return age;
  }
}
