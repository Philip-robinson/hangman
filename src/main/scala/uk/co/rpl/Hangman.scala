package uk.co.rpl

object Hangman {
  val wordList = new WordList("/Users/philip/dict/wordlist.txt")
  val output=new Out(System.out)

  /**
    * @param args the command line arguments - not used
    */
  def main(args: Array[String]): Unit = {

    // Infinite loop this loop is exited with a System.exit call
    while (true) {
      val word = new WordHolder(wordList.getRandom)

      while (!word.isFailed && !word.isFound) {
        summary(word)
        val line = scala.io.StdIn.readLine("# > ")
        output.prline("Read " + line)
        processInputLine(line, word)
        if (line.equals("EXIT")) System.exit(1)
        output.prline(word.picture)
      }
      output.prline("       Failures: " + word.getFailCount)
      output.prline(" Unused letters: " + word.availableLetters)
      if (word.isFound) output.prline("SUCCESS the word was " + word.getWord)
      if (word.isFailed) output.prline("SORRY the word was  not found it was " + word.getWord)
      output.prline("\n\n-----------------------------\n\n try a new word\n")
    }
  }

  def processInputLine(line: String, word: WordHolder):Unit = {
    var skip = false
    for (char <- line.toUpperCase) {
      if (!skip) {
        val (error, used, set) = word.put(char)
        if (used) output.prline("That letter " + char + " has already been used")
        else if (error!=null) output.prline("That letter " + char + " is not allowed "+error)
        else if (set) output.prline("The letter " + char + " was valid")
        else output.prline("The letter " + char + " is not in this word")
        if (word.isFailed || word.isFound) skip = true
      }
    }
  }

  private def summary(word: WordHolder): Unit = {
    output.prline("       Failures: " + word.getFailCount)
    output.prline(" Unused letters: " + word.availableLetters)
    output.prline()
    output.prline("           WORD: " + word.toString)
    output.prline("enter one leter or more followed by newline")
  }
}
