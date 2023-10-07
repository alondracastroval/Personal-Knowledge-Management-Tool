package cs3500.pa01;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - the input path, the ordering flag, and output path
   */
  public static void main(String[] args) throws IOException {



    //Study Guide mode if there is 3 arguments
    if (args.length == 3) {
      String inputPath = args[0];
      String orderingFlag = args[1];
      String outputPath = args[2];

      Controller controllerStudy = new StudyGuideController(inputPath, orderingFlag, outputPath);
      controllerStudy.run();


    }

    //IF ARG SIZE IS 0 THEN RUN THE QUIZ MODE
    if (args.length == 0) {

      //ONLY THINGS THAT WILL GO HERE
      Readable input = new InputStreamReader(System.in);
      Controller controller = new StudyQuizModeController(input);
      controller.run();


    }


  }


}