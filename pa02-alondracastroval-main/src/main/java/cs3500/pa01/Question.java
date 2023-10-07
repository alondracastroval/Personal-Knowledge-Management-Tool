package cs3500.pa01;

/**
 * Represents one single question from the study session
 */
public class Question {

  private String content;
  private String answer;
  private boolean hard;;
  private boolean answerHidden;

  Question(String content, String answer, boolean hard, boolean answerHidden) {

  }

  /**
   * Sets the difficulty of a question
   * @param newDifficulty the new difficulty
   */
  public void setDifficulty(Boolean newDifficulty) {
    hard = newDifficulty;
  }

  /**
   * Changes the status of answer from hidden to shown
   * @param newStatus of the answer
   */
  public void showAnswer(Boolean newStatus) {
    answerHidden = newStatus;
  }

  /**
   * Gets the question content from a question
   * @return the question content
   */
  public String getContent() {
    return content;
  }

  /**
   * Gets the answer part from a question
   * @return the answer
   */
  public String getAnswer() {
    return answer;
  }

  /**
   * Gets the difficulty from a question
   * @return the difficulty, true if hard, false, if easy
   */
  public boolean getHard() {
    return hard;
  }

  /**
   * Gets whether an answer is hidden or not
   * @return the hidden status of an answer
   */
  public boolean getAnswerHidden() {
    return answerHidden;
  }

  /**
   * Sets the question content of a question
   * @param newContent the new content
   */
  public void setContent(String newContent) {
    content = newContent;
  }

  /**
   * Sets the answer content of the question
   * @param newAnswer the new answer
   */
  public void setAnswer(String newAnswer) {
    answer = newAnswer;
  }

  /**
   * Displays the answer on the terminal when the answer isn't hidden
   */
  public void displayAnswer1() {
    if (!this.answerHidden) {
      System.out.println("Answer: " + answer);
    }
  }




}