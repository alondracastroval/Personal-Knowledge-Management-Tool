package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class MdQuestionFileReader extends AbstractFileReader<MyFile> {



  /**
   * @param fileName the name of the file being read
   * @return a MyFile object that will have only the question information
   * @throws IOException when the file can't be read
   */
  @Override
  public MyFile readFile(String fileName) throws IOException {
    //only updating the stringBuilder and name
    // because that is all we need for the .sr file
    MyFile outputMyFile = new MyFile(null, null, null, null);
    StringBuilder information = new StringBuilder(10000);
    Path inputFile  = Path.of(fileName);
    Scanner scan = null;

    try {
      scan = new Scanner(inputFile);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(0);
    }
    //giving it a name
    String name = inputFile.getFileName().toString();
    outputMyFile.giveName(name);


    while (scan.hasNextLine()) {
      String line = scan.nextLine();

      if (line.contains(":::")) {
        int start = line.indexOf("[[") + 2;
        int end = line.indexOf("]]");
        //adding the questions into the information
        String question = line.substring(start, end);
        information.append(question);
        //marking it as hard initially
        information.append("Hard");
        information.append("\n");
      }
    }

    //updating the information field
    outputMyFile.mutateInformation(information);
    return outputMyFile;

  }




}