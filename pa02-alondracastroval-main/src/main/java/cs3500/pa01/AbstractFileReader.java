package cs3500.pa01;

import java.io.IOException;

/**
 * Deals with the general reading of files
 * @param <T> the type of output after reading the file
 */
public abstract class AbstractFileReader<T> {


  /**
   * Reads a file and looks for specific information
   * @param fileName the name of the file being read
   * @return the type of output for scenario
   * @throws IOException when the file can't be read
   */
  public abstract T readFile(String fileName) throws IOException;


}