package cs3500.pa01;

import java.io.File;
import java.util.Comparator;

/**
 * Class that represents comparator based on the file name
 * in alphabetical order
 */
public class NameComparator implements Comparator<MyFile> {

  /**
   * Compares two MyFile objects in alphabetical order
   * @param o1 the first myFile object to be compared.
   * @param o2 the second myFile object to be compared.
   * @return the integer based on comparison
   */
  @Override
  public int compare(MyFile o1, MyFile o2) {
    return o1.getName().compareToIgnoreCase(o2.getName());
  }
}


