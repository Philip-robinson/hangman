package uk.co.rpl

object Hangman {
  import Utils._

  /**
    * @param args the command line arguments - not used
    */
  def main(args: Array[String]): Unit = {
    val wordList = new WordList("/Users/philip/dict/wordlist.txt")
    while (true) {
      val word = new WordHolder(wordList.getRandom)

      while (!word.isFailed && !word.isFound) {
        prline("       Failures: " + word.getFailCount)
        prline(" Unused letters: " + word.availableLetters)
        prline()
        prline("           WORD: " + word.toString)
        prline("enter one leter or more followed by newline")
        val line = scala.io.StdIn.readLine("# > ")
        prline("Read " + line)

        if (line.equals("EXIT")) System.exit(1)
        for (char <- line.toUpperCase) {
          val (used, set) = word.put(char)
          if (used) prline("That letter " + char + " has already been used")
          else if (set) prline("The letter " + char + " was valid")
          else prline("The letter " + char + " is not in this word")
        }
        prline(word.picture)
      }
      if (word.isFound) prline("SUCCESS the word was " + word.getWord)
      if (word.isFailed) prline("SORRY the word was  not found it was " + word.getWord)
      prline("\n\n-----------------------------\n\n try a new word\n")
    }
  }
}
