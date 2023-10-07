package cs3500.pa01;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * Walks through a path of files
 */
public class MdFileWalker implements FileVisitor<Path> {

  // this list contains all of the file names that
  // are md files
  private ArrayList<String> listofNames;


  //constructor
  MdFileWalker(ArrayList<String> list) {
    listofNames = list;
  }

  /**
   * gets the list of Names the fileWalker gets
   *
   * @return list of all md files name paths.
   */
  public ArrayList<String> getList() {
    return listofNames;
  }


  /**
   * What is done in the beggining of processing
   *
   * @param dir a reference to the directory
   *
   * @param attrs
   *          the directory's basic attributes
   *
   * @return contines waling
   * @throws IOException when
   */
  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    System.out.format("Starting Directory: %s%n", dir);
    return CONTINUE;
  }

  /**
   * Gets called when the walker encounters a file
   * @param file
   *          a reference to the file
   * @param attrs
   *          the file's basic attributes
   *
   * @return a list of all the file names that are .md files
   */


  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)  {
    String nameOfFile = file.getFileName().toString();
    String pathOfFile = file.toAbsolutePath().toString();
    if (nameOfFile.endsWith(".md")) {
      listofNames.add(pathOfFile);
    }
    return CONTINUE;

  }

  /**
   * Gets called when the file could not be visited
   *
   * @param file
   *          a reference to the file
   *
   * @param exc
   *          the I/O exception that prevented the file from being visited
   *
   * @return continues walking
   */
  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) {
    System.err.println(exc);
    return CONTINUE;
  }

  /**
   * What is done after processing all items in the provided
   * directory
   *
   * @param dir
   *          a reference to the directory
   *
   * @param exc {@code null} if the iteration of the directory completes without
   *          an error; otherwise the I/O exception that caused the iteration
   *          of the directory to complete prematurely
   *
   * @return continues walking
   */

  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
    System.out.format("Finishing Directory: %s%n", dir);
    return CONTINUE;
  }
}