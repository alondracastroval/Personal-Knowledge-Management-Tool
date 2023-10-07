package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * Tests of all methods in fileWalker class
 */
class MdFileWalkerTest {

  static final String
      SampleInputsDirectory1 =
      "src/test/resources/arrays.md";
  static final String
      SampleInputsDirectory2 =
      "src/test/resources/vects.md";


  /**
   * Testing if we get the desired list of names
   * @throws IOException when the file can't be walked
   */
  @Test
  public void testGetList() throws IOException {

    ArrayList<String> initialList = new ArrayList<>();

    //making the path the first argument
    Path p = Path.of("src/test/resources");

    MdFileWalker mfw = new MdFileWalker(initialList);

    //walking the tree
    Files.walkFileTree(p, mfw);

    ArrayList<String> namesList = new ArrayList<String>();

    //My fileWalker gives back the absolute path which is why i use it here
    namesList.add("C:\\Users\\Alondra Castro\\Desktop" +
        "\\CS3500\\pa02-alondracastroval\\src\\test\\resources\\arrays.md");
    namesList.add("C:\\Users\\Alondra Castro\\Desktop" +
        "\\CS3500\\pa02-alondracastroval\\src\\test\\resources\\vects.md");

    assertEquals(namesList, mfw.getList());



  }






}