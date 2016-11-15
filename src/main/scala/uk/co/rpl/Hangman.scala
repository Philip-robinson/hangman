package uk.co.rpl

object Hangman {

  /**
    * @param args the command line arguments - not used
    */
  def main(args: Array[String]): Unit = {
    val wordList = new WordList("/Users/philip/dict/wordlist.txt")
    val output=new Out(System.out)
    while (true) {
      val word = new WordHolder(wordList.getRandom)

      while (!word.isFailed && !word.isFound) {
        output.prline("       Failures: " + word.getFailCount)
        output.prline(" Unused letters: " + word.availableLetters)
        output.prline()
        output.prline("           WORD: " + word.toString)
        output.prline("enter one leter or more followed by newline")
        val line = scala.io.StdIn.readLine("# > ")
        output.prline("Read " + line)

        if (line.equals("EXIT")) System.exit(1)
        for (char <- line.toUpperCase) {
          val (used, set) = word.put(char)
          if (used) output.prline("That letter " + char + " has already been used")
          else if (set) output.prline("The letter " + char + " was valid")
          else output.prline("The letter " + char + " is not in this word")
        }
        output.prline(word.picture)
      }
      if (word.isFound) output.prline("SUCCESS the word was " + word.getWord)
      if (word.isFailed) output.prline("SORRY the word was  not found it was " + word.getWord)
      output.prline("\n\n-----------------------------\n\n try a new word\n")
    }
  }
}
