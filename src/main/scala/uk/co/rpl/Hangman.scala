/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.rpl

object Hangman {

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
	  var wordList = new WordList("/Users/philip/dict/wordlist.txt")
	  while (true){
	  	var word = new WordHolder(wordList.getRandom)

		while (!word.isFailed && !word.isFound){
			println("       failures "+word.getFailCount)
			println(" unused letters "+word.availableLetters)
			println
			println(word.toString)
			var line = scala.io.StdIn.readLine("> ")
			println("Read "+line)
			
			if (line.equals("EXIT")) System.exit(1)
			for (char <- line.toUpperCase){
				var(used, set) = word.put(char)
				if (used) println("That letter "+char+" has already been used")
				else if (set) println("The letter "+char+" was valid")
				else println("The letter "+char+" is not in this word")
			}
			println(word.picture)
		}
		if (word.isFound) println("SUCCESS the word was "+word.getWord)
		if (word.isFailed) println("SORRY the word was  not found it was "+word.getWord)
		println("\n\n-----------------------------\n\n try a new word\n")
	  }
  }

}
