package views;

import java.util.Scanner;

public class SentenceView {
  private Scanner scanner = new Scanner(System.in);

  public void displayMessage(String message) {
    System.out.println(message);
  }

  public void displayMenu() {
    System.out.println("1. Input sentence");
    System.out.println("2. Search word in input sentence");
    System.out.println("3. Average number of appearances per word for character");
    System.out.println("4. Exit");
  }

  public int readUserChoice() {
    System.out.printf("Your choice: ");

    while (!scanner.hasNextInt()) {
      System.out.printf("Invalid input. Please enter a valid integer: ");
      scanner.next();
    }

    int action = scanner.nextInt();
    scanner.nextLine();

    return action;
  }

  public String readInputSentence() {
    System.out.println("Enter input sentence:");
    return scanner.nextLine();
  }

  public String readInputWord() {
    System.out.println("Enter a word to search for:");
    return scanner.nextLine();
  }

  public Character readInputCharacter() {
    System.out.println("Enter a character to find the average number of its appearances per word:");
    String input = scanner.nextLine();

    while (input.length() != 1) {
      System.out.println("Invalid input. Please enter exactly one character:");
      input = scanner.nextLine();
    }

    return input.charAt(0);
  }

  public void displayInvalidMessage() {
    System.out.println("You must choose option 1 first");
  }
}