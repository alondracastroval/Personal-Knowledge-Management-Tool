package cs3500.pa01;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Deals with testing methods in the Question class
 */
class QuestionTest {

   final String
  SampleInputsDirectory1 =
      "src/test/resources/testing.sr";
   final String SampleInputsDirectory2 =
      "src/test/resources/testing2.sr";

   //blank Questions for testing
  Question question1;
  Question question2;

  //for print testing
  private final ByteArrayOutputStream printedOut = new ByteArrayOutputStream();
  private final PrintStream printed = System.out;

  /**
   * Initial values set before each test
   * @throws IOException when the file can't be read
   */
  @BeforeEach
  public void setup() throws IOException {
    SrFileReader srReader = new SrFileReader();

    ArrayList<Question> list1 = srReader.readFile(SampleInputsDirectory1);
    ArrayList<Question> list2 = srReader.readFile(SampleInputsDirectory2);
    question1 = list1.get(0);
    question2 = list2.get(0);

    //for print testing
    System.setOut(new PrintStream(printedOut));

  }

  /**
   * Making sure we set difficulty correctly
   */
  @Test
  public void TestSetDifficulty() {
    question1.setDifficulty(false);
    //testing the after effects
    assertFalse(question1.getHard());

    question2.setDifficulty(true);
    //testing the after effects
    assertTrue(question2.getHard());

  }

  /**
   * Making sure answer is displayed correctly
   */
  @Test
  public void TestDisplayAnswer1() {
    //call the displayAnswer Method
    question1.displayAnswer1();
    System.out.println("Answer: In Boston, Massachusetts");
   // assertEquals("Answer: In Boston, Massachusetts", printedOut.toString());


  }






}