package cs3500.pa01;

import java.nio.file.attribute.FileTime;
import java.util.ArrayList;

/**
 * Represents a class of an accepted file
 * storing information that will be used in the
 * finalized studyGuide
 */
public class MyFile implements Comparable<MyFile> {

  private FileTime creationDate;
  private FileTime lastModified;
  private StringBuilder information;
  private String name;

  public MyFile(FileTime creationDate,FileTime lastModified, StringBuilder information, String Name) {

  }

  /**
   * Gets the name field of the file
   * @return name of file;
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the information of a file
   * @return the information field of MyFile
   */
  public StringBuilder getInformation() {
    return this.information;
  }

  /**
   * Gets creation date
   * @return creation date of a file
   */
  public FileTime getCreationDate() {
    return this.creationDate;
  }

  /**
   * Gets last modified date
   * @return last modified date of file
   */
  public FileTime getLastModifiedDate() {
    return this.lastModified;
  }


  /**
   * Mutates the name field of a myFile
   * @param newName desired new name
   */
  //giving it a new name if needed
  public void giveName(String newName) {
    this.name = newName;
  }

  /**
   * Compares a myFile to another myFile
   * based on creation Date
   * @param otherFile the object to be compared.
   * @return an integer representing the comparison
   */
  @Override
  public int compareTo(MyFile otherFile) {
    return this.creationDate.compareTo(otherFile.creationDate);
  }

  /**
   * Mutates the information field
   * @param newInfo desired new information
   */


  public void mutateInformation(StringBuilder newInfo) {
    information = newInfo;
  }

  /**
   * Mutates creation date field
   * @param newTime desired new creation date
   */
  public void mutateCreationDate(FileTime newTime) {
    creationDate = newTime;
  }

  /**
   * Mutates modified date field
   * @param newTime desired new time
   */
  public void mutateModifiedDate(FileTime newTime) {
    lastModified = newTime;
  }




}