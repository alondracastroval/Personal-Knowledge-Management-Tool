package cs3500.pa01;

import java.io.File;
import java.nio.file.attribute.FileTime;
import java.util.Comparator;

/**
 * Class that represents a comparator of the creationDate stamp
 */
public class CreationComparator implements Comparator<MyFile> {

  /**
   * Compares two MyFile objects based on the creation date
   * of the files
   *
   * @param o1 the first MyFile object to be compared.
   * @param o2 the second MyFile object to be compared.
   * @return an integer representing the value of the comparison
   */
  @Override
  public int compare(MyFile o1, MyFile o2) {
    FileTime firstDate = o1.getLastModifiedDate();
    FileTime secondDate = o2.getLastModifiedDate();
    return firstDate.compareTo(secondDate);
  }

}