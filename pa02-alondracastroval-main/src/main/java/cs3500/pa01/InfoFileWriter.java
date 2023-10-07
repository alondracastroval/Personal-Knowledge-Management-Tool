package cs3500.pa01;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Writes the information from the MyFiles into a study guide md file
 */
public class InfoFileWriter {

  public void fileWriter(ArrayList<MyFile> listofFiles, String outputPathName) {
    //using the filewriter to output the summary document
    try {
      FileWriter outputFile = new FileWriter(outputPathName);

      //iterating on each element of list of MyFile type
      for (int i = 0; i < listofFiles.size(); i++) {
        //getting the information field from each index
        // on the list of MyFiles
        MyFile current = listofFiles.get(i);
        StringBuilder info = current.getInformation();
        String infoStringVersion = String.valueOf(info);
        outputFile.write(info.toString());
      }
      outputFile.close();
    } catch (Exception e) {
      e.getStackTrace();
    }

  }

}