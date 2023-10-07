package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class SrFileReader extends AbstractFileReader<ArrayList<Question>> {

  @Override
  public ArrayList<Question> readFile(String fileName) throws IOException {

    //blank list that will be updated as we go
    ArrayList<Question> outputList = new ArrayList<Question>();
    Path inputFile = Path.of(fileName);
    Scanner scan = null;

    try {
      scan = new Scanner(inputFile);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(0);
    }

    while (scan.hasNextLine()) {
      String line = scan.nextLine();

      //getting the information from file
      String answerContent = lookForAnswers(line);
      String questionContent = lookForQuestions(line);

      //making object for parsing into question
      Question questionMade = new Question(null, null, true, true);

      //updating the fields of the question object
      questionMade.setAnswer(answerContent);
      questionMade.setContent(questionContent);
      difficultyMarker(line, questionMade);
      questionMade.showAnswer(true);

      //adding that question to the arrayList of questions
      outputList.add(questionMade);
    }

    return outputList;
  }


  public String lookForQuestions(String line) {
    String questionContent = "";
    if (line.contains(":::")) {
      int start = 0;
      int end = line.indexOf(":::");
      questionContent = line.substring(start, end);

    }
    return questionContent;

  }


  public void difficultyMarker(String line, Question currentQuestion) {
    //if the line contains hard mark it as hard
    if (line.contains("Hard")) {
      currentQuestion.setDifficulty(true);
    }  if (line.contains("Easy")) {
      currentQuestion.setDifficulty(false);
    }
  }


  public String lookForAnswers (String line){
    String answerContent = "";
    if ((line.contains(":::"))) {
      //getting the answer content from the line
      int answerStart = line.indexOf(":::") + 3;
      int answerEnd = line.indexOf(".");
      answerContent = line.substring(answerStart, answerEnd);
    }
    return answerContent;
  }



}






