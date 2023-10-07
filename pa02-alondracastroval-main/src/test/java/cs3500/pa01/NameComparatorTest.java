package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests all method in nameComparator class
 */
class NameComparatorTest {



  static final String
      SampleInputsDirectory1 =
      "C:/Users/Alondra Castro/Desktop/CS3500/pa02-alondracastroval/src/test/resources/arrays.md";
  static final String
      SampleInputsDirectory2 =
      "C:/Users/Alondra Castro/Desktop/CS3500/pa02-alondracastroval/src/test/resources/vects.md";

  MyFile myFile1;
  MyFile myFile2;

  /**
   * Initial conditions
   * @throws IOException if file can't be read
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
   * Tests objects are being tested correctly
   * based on name
   */
  @Test
  public void TestCompare() {
    NameComparator comp = new NameComparator();

    assertEquals(-21, comp.compare(myFile1, myFile2));
    assertEquals(21, comp.compare(myFile2, myFile1));
    assertEquals(0, comp.compare(myFile2, myFile2));
    assertEquals(0, comp.compare(myFile1, myFile1));


  }


}