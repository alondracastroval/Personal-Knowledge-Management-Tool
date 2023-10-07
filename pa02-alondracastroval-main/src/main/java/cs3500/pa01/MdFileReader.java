package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;


/**
 * Represents a class that will read and scan through one file
 */
public class MdFileReader extends AbstractFileReader<MyFile> {




  /**
   * Reads and scans the information inside one file,
   * keeping only the desired information
   *
   * @param fileName the name of the file being scanned
   * @return a My File object that contains the needed information from the original
   * @throws IOException when the file can't be found/read
   */
  @Override
  public MyFile readFile(String fileName) throws IOException {

    //initial information that will get updated as we go
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

    //creating a BasicFileAttributes to get what we need from the file
    BasicFileAttributes attributes = Files.readAttributes(inputFile,
        BasicFileAttributes.class);

    //getting the creation time, modification time, and name
    //from the file
    FileTime creationTime = attributes.creationTime();
    FileTime lastModified = attributes.lastModifiedTime();
    String name = inputFile.getFileName().toString();

    //while there is a next line we will look for
    //instances of # (headers) and [[ ]] (important info)
    while (scan.hasNextLine()) {
      String line = scan.nextLine();

      if (line.contains("#")) {
        information.append(line);
        information.append("\n");

      }
      if (line.contains("[[") && (line.contains("]]"))
          && (!(line.contains(":::")))) {
        int start = line.indexOf("[[") + 2;
        int end = line.indexOf("]]");//
        String info = line.substring(start, end);
        information.append("- ");
        information.append(info);
        information.append("\n");
        //updating line
        line = line.substring(end, line.length());
        if( (line.contains("[[")) && (!(line.contains(":::"))) ) {
          int newStart = line.indexOf("[[") + 2;
          int newEnd = line.length();
          String moreInfo = line.substring(newStart, newEnd);
          information.append("- ");
          information.append(moreInfo);
          information.append("\n");
        }
      }
      //handles the case where the brackets aren't on same line
      if ((line.contains("[[") && (!line.contains("]]")))
          && (!(line.contains(":::")))) {
        int start = line.indexOf("[[")  + 2;
        int end = line.length();
        String info = line.substring(start, end);
        information.append("- ");
        information.append(info);
        information.append("\n");

      }

      //handles the case where the brackets aren't on same line
      if ((line.contains("]]") && (!line.contains("[[")))
          && (!(line.contains(":::")))) {
        int start = 0;
        int end = line.indexOf("]]");
        String info = line.substring(start, end);
        information.append(info);
        information.append("\n");

      }


    }

    //updating the fields of the MyFile object that will be returned
    outputMyFile.mutateCreationDate(creationTime);
    outputMyFile.mutateModifiedDate(lastModified);
    outputMyFile.mutateInformation(information);
    outputMyFile.giveName(name);
    return outputMyFile;

  }




}





