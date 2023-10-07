package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Deals with testing methods in the study session model class
 */
class StudySessionModelTest {

  final String
      SampleInputsDirectory1 =
      "src/test/resources/testing.sr";
  final String SampleInputsDirectory2 =
      "src/test/resources/testing2.sr";

  StudySessionModel testSession1;
  StudySessionModel testSession2;

  Question question1;
  Question question2;
  Question question3;
  ArrayList<Question> list1;
  ArrayList<Question> list2;


  /**
   * Initial values set before each test
   * @throws IOException when the file can't be read
   */
  @BeforeEach

  public void setup() throws IOException {
    //to get the list of questions
    SrFileReader srReader = new SrFileReader();
    list1 = srReader.readFile(SampleInputsDirectory1);
    list2 = srReader.readFile(SampleInputsDirectory2);

    question1 = list1.get(0);
    question2 = list2.get(0);
    question3 = list2.get(1);



    testSession1 = new StudySessionModel(0, 0,
        1, false, list1);

    testSession2 = new StudySessionModel(1, 1, 2,
        false, list2);

    //mutating values of the first session
    testSession1.setNumberOfQuestions(1);

    //mutating values of the second session
    testSession2.updateHTECount();
    testSession2.setNumberOfQuestions(2);


  }


  /**
   * Testing to see if we update HTE count
   */
  @Test
  public void testUpdateHTECount() {
    //first the count is 0
    assertEquals(0, testSession1.getHardToEasy());
    //then we call the update count
    testSession1.updateHTECount();
    //now its 1
    assertEquals(1, testSession1.getHardToEasy());

    //first the count is 1
    assertEquals(1, testSession2.getHardToEasy());
    //then we call the update count
    testSession2.updateHTECount();
    //now its 1
    assertEquals(2, testSession2.getHardToEasy());

  }

  /**
   * Testing to see if we get correct game done status
   */
  @Test void testGameDone() {
    //first the game isn't done
    assertFalse(testSession1.done);
    assertFalse(testSession2.done);

    //then we mark it as done
    testSession1.gameDone();
    testSession2.gameDone();

    //now the game is done
    assertTrue(testSession1.done);
    assertTrue(testSession2.done);

  }

  /**
   * Testing to see if we get the ETH count correctly
   */
  @Test
  public void testUpdateETHCount() {
    //first the count is 0
    assertEquals(0, testSession1.getEasyToHard());
    //then we call the update count
    testSession1.updateETHCount();
    //now its 1
    assertEquals(1, testSession1.getEasyToHard());

  }

  /**
   * Making sure we get the correct number of user questions
   */
  @Test
  public void TestGetNumberofQuestions()  {
    assertEquals(1, testSession1.getNumberOfQuestions());
    assertEquals(2, testSession2.getNumberOfQuestions());
  }

  /**
   * Making sure we set the correct number of user questions
   */
  @Test
  public void TestSetNumberOfQuestions() {
    //first the number of questions is 1
    assertEquals(1, testSession1.getNumberOfQuestions());
    //then we set it to 4
    testSession1.setNumberOfQuestions(4);
    //checking
    assertEquals(4, testSession1.getNumberOfQuestions());

  }


  /**
   * Making sure hard list is generated correctly
   */
  @Test
  public void TestGenerateHardQuestionList() {

    //mutating that hardList
    testSession1.generateHardQuestionList(list1);
    //should be a list of only one question
    assertEquals(1, testSession1.getHardQuestions().size());
    //checking if its the element i think
    assertEquals(question1, testSession1.getHardQuestions().get(0));

    testSession2.generateHardQuestionList(list2);
    //should be a list of 1 question too
    assertEquals(1, testSession2.getHardQuestions().size());
    //making sure its the right question in the list
    assertEquals(question2, testSession2.getHardQuestions().get(0));


  }

  /**
   * Making sure easy question list is generated correctly
   */
  @Test
  public void TestGenerateEasyQuestionList() {

    //mutating that easyList
    testSession1.generateEasyQuestionList(list1);
    //should be a list of no questions
    assertEquals(0, testSession1.getEasyQuestions().size());

    //generating easy questions on session2
    testSession2.generateEasyQuestionList(list2);
    //should be a list of 1 question
    assertEquals(1, testSession2.getEasyQuestions().size());
    //making sure its the right question in the list
    assertEquals(question3, testSession2.getEasyQuestions().get(0));


  }

  /**
   * Making sure list is randomized / shuffled correctly
   */
  @Test
  public void TestShuffleList() {

    //shuffling the list of all questions for session1
    testSession1.shuffleList(list1);
    assertEquals(question1, list1.get(0));

    //now we test it on a list of hard questions
    testSession2.generateHardQuestionList(list2);
    ArrayList<Question> hardList = testSession2.getHardQuestions();
    testSession2.shuffleList(hardList);
    assertEquals(question2, testSession2.getHardQuestions().get(0));
  }

  /**
   * Making sure we get the right amount of hard questions to be displayed
   */
  @Test
  public void howManyHardQuestions() {
    //generate the lists of hard and easy
    testSession2.generateHardQuestionList(list2);
    testSession2.generateEasyQuestionList(list2);

    assertEquals(1, testSession2.howManyHardQuestions());

    //now for the other session
    testSession1.generateHardQuestionList(list2);
    //should also be one
    assertEquals(1, testSession2.howManyHardQuestions());

  }

  /**
   * Making sure we get the correct number of easy questions to be displayed
   */
  @Test
  public void howManyEasyQuestions() {
    //generate the lists of hard and easy
    testSession2.generateHardQuestionList(list2);
    testSession2.generateEasyQuestionList(list2);

    testSession1.generateHardQuestionList(list2);
    testSession1.generateEasyQuestionList(list2);

    //for session 2 it should be 1
    assertEquals(1, testSession2.howManyEasyQuestions());

    //should be 0 for session 1
    assertEquals(0, testSession1.howManyEasyQuestions());

  }





}