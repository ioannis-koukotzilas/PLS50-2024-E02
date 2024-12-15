package services;

import java.util.ArrayList;
import java.util.List;
import models.entities.MyStrings;
import views.SentenceView;

public class SentenceService {
  private SentenceView sentenceView;
  private MyStrings inputSentence = null;

  public SentenceService() {
    this.sentenceView = new SentenceView();
  }

  public void initSentenceProcess() {
    MyStrings mySentence1 = new MyStrings("Two things are infinite:the universe and human stupidity;and I'm not sure about the universe.");
    MyStrings mySentence2 = new MyStrings("You've gotta dance like there's nobody watching,Love like you'll never be hurt,Sing like there's nobody listening,and Live like it's heaven on earth.");

    String[] mySentence1Strings = mySentence1.getStrings();
    String[] mySentence2Strings = mySentence2.getStrings();

    searchString("the", mySentence1Strings);
    searchString("like", mySentence1Strings);
    searchCharacter('t', mySentence1Strings);
    searchCharacter('e', mySentence1Strings);

    searchString("the", mySentence2Strings);
    searchString("like", mySentence2Strings);
    searchCharacter('t', mySentence2Strings);
    searchCharacter('e', mySentence2Strings);
  }

  public void initSentenceProcessWithUserMenu() {
    sentenceView.displayMenu();
    int inputChoice = sentenceView.readUserChoice();

    if (inputChoice == 1) {
      inputSentence = new MyStrings(sentenceView.readInputSentence());
      initSentenceProcessWithUserMenu();
    } else if (inputChoice == 2) {
      if (inputSentence == null) {
        sentenceView.displayInvalidMessage();
      } else {
        String inputWord = sentenceView.readInputWord();
        searchString(inputWord, inputSentence.getStrings());
      }
    } else if (inputChoice == 3) {
      if (inputSentence == null) {
        sentenceView.displayInvalidMessage();
      } else {
        Character inputCharacter = sentenceView.readInputCharacter();
        searchCharacter(inputCharacter, inputSentence.getStrings());
      }
    } else if (inputChoice == 4) {
      return;
    } else {
      initSentenceProcessWithUserMenu();
    }
  }

  private void searchString(String str, String[] stringsArr) {
    List<Integer> positions = new ArrayList<>();

    for (int index = 0; index < stringsArr.length; index++) {
      if (str.toLowerCase().equals(stringsArr[index])) {
        positions.add(index + 1);
      }
    }

    if (positions.size() > 0) {
      for (int index = 0; index < positions.size(); index++) {
        sentenceView.displayMessage("The word \"" + str + "\" has been found in position " + positions.get(index) + ".");
      }

      sentenceView.displayMessage("The word \"" + str + "\" has been found " + positions.size() + " times.");
    } else {
      sentenceView.displayMessage("The word \"" + str + "\" has not been found.");
    }
  }

  private void searchCharacter(Character character, String[] stringsArr) {
    int characterCounter = 0;
    int wordsWithCharacterCounter = 0;

    for (int strIndex = 0; strIndex < stringsArr.length; strIndex++) {
      String currentString = stringsArr[strIndex];

      if (!currentString.isEmpty()) {
        boolean foundCharacter = false;

        for (int charIndex = 0; charIndex < currentString.length(); charIndex++) {
          if (currentString.charAt(charIndex) == character) {
            foundCharacter = true;
            characterCounter++;
          }
        }

        if (foundCharacter) {
          wordsWithCharacterCounter++;
        }
      }
    }

    double averageOccurrences = (double) characterCounter / stringsArr.length;

    sentenceView.displayMessage("The character \"" + character + "\" has been found in " + wordsWithCharacterCounter + " words.");
    sentenceView.displayMessage("Average number of appearances per word for character \"" + character + "\" is " + averageOccurrences + ".");
  }
}