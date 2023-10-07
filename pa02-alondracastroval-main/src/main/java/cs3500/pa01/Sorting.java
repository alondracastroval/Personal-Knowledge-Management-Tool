package cs3500.pa01;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Deals with the sorting of class based on ordering flag
 */
public class Sorting {
  /**
   * Sorts a list of MyFiles based on the ordering flag given
   * by the user
   *
   * @param orderingFlag a flag to indicate order of info in summary document
   *
   * @param filesList Array list of MyFile type that will be sorted
   */
  public static void sortBy(String orderingFlag, ArrayList<MyFile> filesList) {

    if (orderingFlag.equals("filename")) {
      NameComparator nameComp = new NameComparator();
      Collections.sort(filesList, nameComp);
    }
    if (orderingFlag.equals("created")) {
      CreationComparator creationComp = new CreationComparator();
      Collections.sort(filesList, creationComp);
    }
    if (orderingFlag.equals("modified")) {
      ModifiedComparator modifiedComp = new ModifiedComparator();
      Collections.sort(filesList, modifiedComp);
    }

  }
}
