package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Checks all the methods inside of the MyFile class
 */
class MyFileTest {

  static final String
      SampleInputsDirectory1 =
      "src/test/resources/arrays.md";
  static final String
      SampleInputsDirectory2 =
      "src/test/resources/vects.md";


  //blank myFile examples that will be used for testing
  MyFile myFile1;
  MyFile myFile2;

  /**
   * Initial conditions, here we set a date that won't change, a mock value
   * @throws IOException if the file can't be read
   */
  @BeforeEach
  public void setup() throws IOException {
    MdFileReader fr = new MdFileReader();
    myFile1 = fr.readFile(SampleInputsDirectory1);
    myFile2 = fr.readFile(SampleInputsDirectory2);

    //putting mockData so the tests run
    FileTime knownCreationTime1 =
        FileTime.from(Instant.parse("2023-05-16T19:41:11.3282682Z"));
    //mutate this
    myFile1.mutateCreationDate(knownCreationTime1);

    //putting MockData for the second file
    FileTime knownCreationTime2 =
        FileTime.from(Instant.parse("2023-05-16T19:41:33.1102138Z"));
    myFile2.mutateCreationDate(knownCreationTime2);

    //putting mockData on the last modified
    FileTime knownModifiedTime1 =
        FileTime.from(Instant.parse("2023-05-16T19:42:37.0418159Z"));

    //mutating this
    myFile1.mutateModifiedDate(knownModifiedTime1);

    FileTime knownModifiedTime2 =
        FileTime.from(Instant.parse("2023-05-16T19:42:54.7571679Z"));

    //mutating this
    myFile2.mutateModifiedDate(knownModifiedTime2);




  }

  /**
   * Tests if we get the correct file name
   */
  @Test
  public void TestGetName() {
    assertEquals("arrays.md", myFile1.getName());
    assertEquals("vects.md", myFile2.getName());

  }

  @Test
  public void TestGetInformation() {
    //ask how to test this
    StringBuilder file1Info = myFile1.getInformation();
    StringBuilder file2Info = myFile2.getInformation();
    assertEquals(file1Info, myFile1.getInformation());
    assertEquals(file2Info, myFile2.getInformation());

  }

  @Test
  public void TestGetCreationDate() {

    //for file 1
    assertEquals("2023-05-16T19:41:11.3282682Z",
        myFile1.getCreationDate().toString());

    assertEquals("2023-05-16T19:41:33.1102138Z",
        myFile2.getCreationDate().toString());

  }

  @Test
  public void TestGetLastModifiedDate() {

    assertEquals("2023-05-16T19:42:37.0418159Z",
        myFile1.getLastModifiedDate().toString());

    assertEquals("2023-05-16T19:42:54.7571679Z",
        myFile2.getLastModifiedDate().toString());

  }

  @Test
  public void TestGiveName() {

    //mutating the fields
    myFile1.giveName("newName.md");
    myFile2.giveName("newName2.md");

    //checking the effects of the mutation
    assertEquals("newName.md",
        myFile1.getName());

    assertEquals("newName2.md",
        myFile2.getName());

  }

  @Test
  public void TestMutateInformation() {
    StringBuilder newInfo1 = new StringBuilder("hi");
    StringBuilder newInfo2 = new StringBuilder("lol");

    //mutating the fields
    myFile1.mutateInformation(newInfo1);
    myFile2.mutateInformation(newInfo2);

    //checking the effect of the mutation
    assertEquals(newInfo1, myFile1.getInformation());
    assertEquals(newInfo2, myFile2.getInformation());


  }

  @Test
  public void testMutateModifiedDate() {
    String  modifiedDateInString = "2023-04-16T19:42:37.0418159Z";
    //  FileTime newDate = <2023-04-16T19:42:37.0418159Z>
    //mutating the fields

  }

  /**
   * Checking if the CompareTo method compares MyFile objects correctly
   */
  @Test
  public void testCompareTo() {

    assertEquals(-1, myFile1.compareTo(myFile2));
    assertEquals(1, myFile2.compareTo(myFile1));
    assertEquals(0, myFile2.compareTo(myFile2));
    assertEquals(0, myFile1.compareTo(myFile1));

  }








}