package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class StudyGuideController implements Controller{

  String inputPath;
  String orderingFlag;
  String outputPath;

  StudyGuideController(String inputPath, String orderingFlag, String outputPath) {
    this.inputPath = inputPath;
    this.orderingFlag = orderingFlag;
    this.outputPath = outputPath;
  }
  @Override
  public void run() throws IOException {
    //THIS WHOLE CHUNK IS USING THE FILEWALKER TO GET
    ArrayList<String> initialList = new ArrayList<>();

    //making the path the first argument
    Path p = Path.of(inputPath);

    MdFileWalker walkerInstance = new MdFileWalker(initialList);

    Files.walkFileTree(p, walkerInstance);

    //getting the list of names from the walker
    ArrayList<String> allNames = walkerInstance.getList();


    //creating fileReader instance
    MdFileReader fileReader = new MdFileReader();
    ArrayList<MyFile> myFilesList = new ArrayList<MyFile>();

    //looping the scanner through all the names of the files
    //that we got from the file walker
    for (String s : allNames) {
      MyFile fileCreated = fileReader.readFile(s);
      myFilesList.add(fileCreated);
    }

    //calling the sort method on the list of MyFile
    Sorting sorting = new Sorting();
    sorting.sortBy(orderingFlag, myFilesList);

    //instance of filewriter for .MdStudyGuide
    InfoFileWriter fileWriterInstance = new InfoFileWriter();
    fileWriterInstance.fileWriter(myFilesList, outputPath + "studyGuide.md");

    ///////////////////////////////////////////////

    //NOW IN THIS CHUNK WE ARE READING THE MD FILE for Questions
    MdQuestionFileReader questionFinder = new MdQuestionFileReader();
    ArrayList<MyFile> filesArrayList = new ArrayList<>();

    //looping the scanner through all the names of the files
    //that we got from the file walker
    for (String s : allNames) {
      //make a stringreader instance
      MyFile questionsFile = questionFinder.readFile(s);
      filesArrayList.add(questionsFile);
    }

    //using the file writer to write the questions into an .sr file
    //instance of filewriter for .MdStudyGuide
    InfoFileWriter fileWriterSr = new InfoFileWriter();
    fileWriterSr.fileWriter(filesArrayList, outputPath + "questions.sr");
  }
}
