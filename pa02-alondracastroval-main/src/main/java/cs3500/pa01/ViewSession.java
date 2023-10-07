package cs3500.pa01;

import java.util.Objects;
import java.util.Scanner;

/**
 * Deals with the displaying of the quiz session
 */
public class ViewSession {
  // you use view to test the controller
  private final Readable keyboardInput;

  public ViewSession(Readable keyboardInput) {
    this.keyboardInput = Objects.requireNonNull(keyboardInput);
  }


  /**
   * Shows the welcome screen and asks for .sr file from user
   * @return the .sr path from the user
   */
  public String welcomeScreenGetPath() {
    Scanner scanner = new Scanner(keyboardInput);
    //creating object of scanner to ask for path
    System.out.println("Welcome to the Quiz Mode of your session! " +
        "please input your .sr file below:");
    //taking the input from the user
    return scanner.nextLine();

  }

  /**
   * Shows the second part of the welcome screen and gets number of questions
   * @return the number of questions the user wants
   */
  public int welcomeScreenGetQuestions() {
    Scanner scanner = new Scanner(keyboardInput);
    System.out.println("How many questions would you like to practice?");
    return scanner.nextInt();

  }

  /**
   * Displays a question with the available menu options for the user
   * @param currentQuestion the current question displayed
   */
  public static void displayQuestion(Question currentQuestion) {
    String question = currentQuestion.getContent();
    String answer = currentQuestion.getAnswer();
    System.out.println("-------------------------------------------------");
    System.out.println(question);
    System.out.println("");

    //print the answer if the user printed it out
    if (!currentQuestion.getAnswerHidden()) {
      System.out.println("Answer: " + currentQuestion.getAnswer());
    }

    System.out.println(" ");
    System.out.println("Menu Options:");
    System.out.println("Press 1 on the keyboard to mark question as easy :D");
    System.out.println("Press 2 on the keyboard to mark question as hard :(");
    System.out.println("Press 3 on the keyboard to reveal the answer :0");
    System.out.println("Press 4 on the keyboard to exit the session and see your stats");

  }


  /**
   * Displays the ending screen of a game including stats of the session
   * @param session the current study session and its properties
   */
  public static void displayEnd(StudySessionModel session) {

    System.out.println("-------------------------------------------------");
    System.out.println("Congratulations you finished studying for today!");
    System.out.println("");
    System.out.println("Here are your stats for the session: ");
    System.out.println("You changed " + session.getHardToEasy() + " questions from hard to easy");
    System.out.println("You changed " + session.getEasyToHard() + " questions from easy to hard");
    System.out.println(
        "You studied a total of " + session.getNumberOfQuestions() + " questions!");
    System.out.println("There was " + session.howManyHardQuestions() + " hard questions in total");
    System.out.println("There was " + session.howManyEasyQuestions() + " easy questions in total");
    System.out.println("");
    System.out.println("Pat yourself on the back, you did an awesome job :D");
  }
}