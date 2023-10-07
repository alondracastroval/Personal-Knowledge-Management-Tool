package cs3500.pa01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Deals with the individual functionalities of the study session
 */
public class StudySessionModel {

  private int hardToEasy;
  private int easyToHard;
  private int numberOfQuestions;
  boolean done;
  ArrayList<Question> questionSet;
  ArrayList<Question> hardQuestions;
  ArrayList<Question> easyQuestions;


  //for testing delete later
  StudySessionModel(int hardToEasy, int easyToHard, int numberOfQuestions,
                    boolean done, ArrayList<Question> questionSet) {

  }



  /**
   * Marks the status of the game as done
   */
  public void gameDone() {
    done = true;
  }


  /**
   * Adds 1 to the count of changes
   */
  public void updateHTECount() {
    hardToEasy = hardToEasy + 1;

  }

  /**
   * Updates the easy to hard count
   */
  public void updateETHCount() {
    easyToHard = easyToHard + 1;

  }

  /**
   * Gets the count of questions that went from hard to easy
   * @return the hard to easy count
   */
  public int getHardToEasy() {
    return hardToEasy;
  }

  /**
   * Gets the number of questions that went from easy to hard
   * @return the easy to hard count
   */
  public int getEasyToHard() {
    return easyToHard;
  }

  /**
   * Gets the number of questions from the user
   * @return the total number of questions displayed
   */
  public int getNumberOfQuestions() {
    return numberOfQuestions;
  }

  /**
   * Sets the number of user questions
   * @param num the number to be set
   */
  public void setNumberOfQuestions(int num){
    numberOfQuestions = num;
  }


  /**
   * Generates a list of questions that were previously marked hard
   * @param allQuestions all questions in bank
   */
  public void generateHardQuestionList(ArrayList<Question> allQuestions) {
    ArrayList<Question> hardQuestionList = new ArrayList<Question>();

    for(int i = 0; i < allQuestions.size(); i++) {
      Question current = allQuestions.get(i);
      //if its hard add it to the hard list
      if (current.getHard()) {
        hardQuestionList.add(current);
      }
    }
    hardQuestions = hardQuestionList;

  }

  /**
   * Generates a list of questions that were previously marked as easy
   * @param allQuestions all the questions in the bank
   */
  public void generateEasyQuestionList(ArrayList<Question> allQuestions) {
    ArrayList<Question> easyQuestionList = new ArrayList<Question>();

    for(int i = 0; i < allQuestions.size(); i++) {
      Question current = allQuestions.get(i);
      //if its hard add it to the hard list
      if (!current.getHard()) {
        easyQuestionList.add(current);
      }
    }
    easyQuestions = easyQuestionList;

  }

  /**
   * Shuffles a list to randomize the order
   * @param list the list to be shuffled
   */
  public void shuffleList(ArrayList<Question> list) {
    Collections.shuffle(list);
  }

  /**
   * Gets the question marked as hard
   * @return the list of hard questions
   */
  public ArrayList<Question> getHardQuestions() {
    return hardQuestions;
  }

  /**
   * Gets the list of easy Questions
   * @return the list of easy questions
   */
  public ArrayList<Question> getEasyQuestions() {
    return easyQuestions;
  }


  /**
   * Calculates how many hard questions will be displayed
   * @return the number of hard questions to be displayed
   */
  public int howManyHardQuestions(){

    if (numberOfQuestions > hardQuestions.size() + easyQuestions.size()) {
     return hardQuestions.size();
    }
    if (hardQuestions.size() > numberOfQuestions)  {
      return numberOfQuestions;
    }
    if (numberOfQuestions == hardQuestions.size() + easyQuestions.size()) {
      return numberOfQuestions - easyQuestions.size();
    }
    else if (hardQuestions.size() == 0) {
      return 0;}
    else {
      return numberOfQuestions - hardQuestions.size();
    }
  }


  /**
   * Calculates the number of easy questions to be displayed
   * @return the number of easy questions to be displayed
   */
  public int howManyEasyQuestions() {
    if (numberOfQuestions > hardQuestions.size() + easyQuestions.size()) {
      return easyQuestions.size();
    }else {
      return numberOfQuestions - this.howManyHardQuestions();
    }

  }




}







