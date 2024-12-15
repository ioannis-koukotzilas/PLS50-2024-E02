package models.entities;

public class MyStrings {
  private String[] strings;

  public MyStrings(String str) {
    this.strings = splitString(str);
  }

  public String[] getStrings() {
    return strings;
  }

  private String[] splitString(String str) {
    if (str.isEmpty()) {
      return new String[0];
    }

    String[] splitStr = str.split("[ ,:;]+");
    String[] strings = new String[splitStr.length];

    for (int i = 0; i < splitStr.length; i++) {
      strings[i] = splitStr[i].toLowerCase();
    }

    return strings;
  }
}