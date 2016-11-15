/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.rpl

class WordHolder(word: String) {
	private val master = word.toUpperCase
	private var entered = word.replaceAll(".", "-").toList
	private var failures: Int = 0
	private var lettersAvailable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

	override def toString: String = {
		entered.mkString
	}

	def getWord: String = {
		master
	}

	def isFound: Boolean = {
		!entered.contains('-')
	}

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

	def put(letter: Char): (Boolean, Boolean) = {
		def ucLetter = letter.toUpper
		if (!lettersAvailable.contains(ucLetter)) return (true, false)
		val (newEntered, found) = findReplace(ucLetter, master, entered)
		lettersAvailable = lettersAvailable.replaceAll("" + ucLetter, "-")
		if (!found) {
			failures += 1
			return (false, false)
		}
		entered = newEntered
		(false, true)
	}

	def getFailCount: Int = {
		failures
	}

	def isFailed: Boolean = {
		failures >= HangingMen.count-1
	}

	def picture: String = {
		if (isFailed) HangingMen.last()
		else HangingMen.entry(failures)
	}
}
