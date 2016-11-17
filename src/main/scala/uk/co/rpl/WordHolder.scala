/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.rpl
/*
 * process a word for hangman
 * @Param word is the word to find
 * Wraps the word and provides functions to try a character
 * Also maintains list of unused characters and a string
 * with the same number of letters as the original word but with
 * characters not yet found to be replaced with '-' characters.
*/
class WordHolder(word: String) {
	private val master = word.toUpperCase
	private var entered = word.replaceAll(".", "-").toList
	private var failures: Int = 0
	private var lettersAvailable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

	override def toString: String = {
		entered.mkString
	}

	// Get the word we are looking for
	def getWord: String = {
		master
	}

	// true if all characters have been specified
	def isFound: Boolean = {
		!entered.contains('-')
	}

	// return a list of the alphabet with used characters replaced with - characters
	def availableLetters: String = {
		lettersAvailable
	}

	private def findReplace(letter: Char, base: String, entered: List[Char]): (List[Char], Boolean) = {
		if (entered.isEmpty) return (List(), false)
		val (next, found) = findReplace(letter, base.tail, entered.tail)
		if (base.head == letter) {
			return (letter :: next, true)
		}
		(entered.head :: next, found)
	}

	// Accept a character and test if it is in the word
	// @Returns (error, false, false) where error message  if there is an error
	// @Returns (null, true, false) if the given character has already been used
	// @Returns (null, false, true) if the entered character was accepted as as a new character in the word
	// @Returns (null, false, false) if the entered character was not found in the word
	//
	def put(letter: Char): (String, Boolean, Boolean) = {
		def ucLetter = letter.toUpper
		if (ucLetter>'Z' || ucLetter<'A') return ("Invalid character", false, false)
		if (!lettersAvailable.contains(ucLetter)) return (null, true, false)
		val (newEntered, found) = findReplace(ucLetter, master, entered)
		lettersAvailable = lettersAvailable.replaceAll("" + ucLetter, "-")
		if (!found) {
			failures += 1
			return (null, false, false)
		}
		entered = newEntered
		(null, false, true)
	}

	// @Return number of failures repeated characters are ignored as are invalid characters
	def getFailCount: Int = {
		failures
	}

	// @Return true if run out of lives
	def isFailed: Boolean = {
		failures >= HangingMen.count-1
	}

	// Generate an ascii art picture representing the current hangman state
	def picture: String = {
		if (isFailed) HangingMen.last()
		else HangingMen.entry(failures)
	}
}
