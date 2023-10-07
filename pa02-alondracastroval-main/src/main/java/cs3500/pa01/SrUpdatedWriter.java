package cs3500.pa01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Deals with updating the given .sr file from user after the session
 */
public class SrUpdatedWriter {

  //replace the metadata and write file
  public void writeUpdatedFile(ArrayList<Question> questions, String fileName) {

    try {
      FileWriter outputFile = new FileWriter(fileName);

      for (int i = 0; i < questions.size(); i++) {
        //getting the questions from it
        StringBuilder allLine = new StringBuilder(10000);
        Question currentQuestion = questions.get(i);
        String question = currentQuestion.getContent();
        String answer = currentQuestion.getAnswer();
        String difficulty = "";

        if (currentQuestion.getHard()) {
          difficulty = "Hard";
        } else {
          difficulty = "Easy";
        }
        //appending all to the string builder
        allLine.append(question);
        allLine.append(":::");
        allLine.append(answer + ".");
        allLine.append(difficulty);
        allLine.append("\n");

        //writting it
        outputFile.write(allLine.toString());
      }
      outputFile.close();

    } catch (Exception e) {
      e.getStackTrace();
    }

  }

}