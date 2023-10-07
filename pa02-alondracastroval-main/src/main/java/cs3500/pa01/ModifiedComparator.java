package cs3500.pa01;

import java.io.File;
import java.nio.file.attribute.FileTime;
import java.util.Comparator;

/**
 * Class that represents a comparator based on last modified date stamp
 */
public class ModifiedComparator implements Comparator<MyFile> {

  /**
   * Compares two MyFile objects based on modification date
   * @param o1 the first myFile object to be compared.
   * @param o2 the second myFile object to be compared.
   * @return an integer that signifies the comparison
   * of the value compared to the other
   */
  @Override
  public int compare(MyFile o1, MyFile o2) {
    FileTime firstDate = o1.getLastModifiedDate();
    FileTime secondDate = o2.getLastModifiedDate();
    return secondDate.compareTo(firstDate);
  }

}