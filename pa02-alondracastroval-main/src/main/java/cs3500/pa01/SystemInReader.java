package cs3500.pa01;

import java.util.Objects;
import java.util.Scanner;

/**
 * Deals with reading the typed input from the user
 */
public class SystemInReader {

  private final Readable keyboardInput;

  public SystemInReader(Readable keyboardInput) {
    this.keyboardInput = Objects.requireNonNull(keyboardInput);
  }


  /**
   * Reads the input from the user
   * @param currentQuestion the current question displayed by the program
   * @param session the current study session
   * @param view instance of viewer to display the ending screen
   */
  public void readKeyboard(Question currentQuestion, StudySessionModel session, ViewSession view) {

    //making a scanner
    Scanner scanner = new Scanner(keyboardInput);

    //the int being typed by the person
    String line = scanner.nextLine();

    if (line.equals("1") ) {
      currentQuestion.setDifficulty(false);
      session.updateHTECount();
    } if (line.equals("2")) {
      currentQuestion.setDifficulty(true);
      session.updateETHCount();
    }  if (line.equals("3")) {
      currentQuestion.showAnswer(false);
      currentQuestion.displayAnswer1();
    } if (line.equals("4") || session.done) {
      view.displayEnd(session);
      System.exit(0);
    }

  }
}
