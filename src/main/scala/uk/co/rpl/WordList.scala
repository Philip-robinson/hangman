

package uk.co.rpl

import java.util._

import scala.io.Source

// maintain a list of words to go into the hangman game
class WordList(file: String) {
	val words = Source.fromFile(file).getLines.toVector
	val rand = new Random(System.currentTimeMillis)

	// get a randomly selected word
	def getRandom: String = {
		words(rand.nextInt(words.length))
	}
}
