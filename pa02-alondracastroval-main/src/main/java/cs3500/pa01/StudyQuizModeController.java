package cs3500.pa01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


/**
 * Deals with using the input from the user to create a successful quiz
 */
public class StudyQuizModeController implements Controller {
  //gets the input from the user
  //knows what to do with it

  private final Readable keyboardInput;

  public StudyQuizModeController(Readable keyboardInput) {
    this.keyboardInput = Objects.requireNonNull(keyboardInput);
  }


  /**
   * Runs the quiz study session
   * @throws IOException when the session fails or is interrupted
   */
  @Override
  public void run() throws IOException {
    //instance of viewer class
    ViewSession viewInstance = new ViewSession(keyboardInput);

    //getting the path and number of questions from person
    String path = viewInstance.welcomeScreenGetPath();
    int numQuestions = viewInstance.welcomeScreenGetQuestions();

    //calling the file reader
    SrFileReader srReader = new SrFileReader();
    ArrayList<Question> questions = srReader.readFile(path);

    //now that we have a set of questions generated we can make a study session!
    StudySessionModel userSession = new StudySessionModel(0, 0, 0,
        false, questions);
    //updating them
    userSession.setNumberOfQuestions(numQuestions);

    //shuffling all the questions (for random effect)
    userSession.shuffleList(questions);

    //make the hard questions first

    userSession.generateHardQuestionList(questions);
    //making the easy questions
    userSession.generateEasyQuestionList(questions);

    //making them variables
    ArrayList<Question> hardList = userSession.getHardQuestions();
    ArrayList<Question> easyList = userSession.getEasyQuestions();


    int numOfHardQuestions = userSession.howManyHardQuestions();
    int numOfEasyQuestions = userSession.howManyEasyQuestions();

    //displaying questions from hard list and then easy list

    displayOneQuestion(hardList, viewInstance, userSession, numOfHardQuestions);
    displayOneQuestion(easyList, viewInstance, userSession, numOfEasyQuestions);


    //displaying the game
    ViewSession.displayEnd(userSession);

    //updating the file
    SrUpdatedWriter srWriter = new SrUpdatedWriter();
    srWriter.writeUpdatedFile(questions, path);

  }

  /**
   * Displays all the questions from the bank in a loop
   * @param list of questions to be displayed
   * @param view instance to display end when needed
   * @param session the current user session
   * @param numQuestions the number of questions displayed
   */
  public void displayOneQuestion(ArrayList<Question> list,
                                 ViewSession view, StudySessionModel session, int numQuestions) {
    SystemInReader r = new SystemInReader(keyboardInput);

    if (list.size() > 1) {
      //make sure the number is greater than 0
      for (int i = 0; i < numQuestions; i++) {
        Question currentQuestion = list.get(i);
        view.displayQuestion(currentQuestion);
        //have a reader
        r.readKeyboard(currentQuestion, session, view);
        //when i is = to the size - 1 game is done
        if (i == session.getNumberOfQuestions() - 1) {
          session.gameDone();
        }
      }
    }
    if (list.size() == 1) {
      //the only element in the list
      Question onlyQuestion = list.get(0);
      view.displayQuestion(onlyQuestion);
      r.readKeyboard(onlyQuestion, session, view);
    }


  }
}





