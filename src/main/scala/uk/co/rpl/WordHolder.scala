/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.rpl

class WordHolder(word: String) {
	private val master = word.toUpperCase
	private var entered = word.replaceAll(".", "-").toList
	private var failures:Int = 0
	private var lettersAvailable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

	override def toString:String = {
		return entered.mkString
	}

	def getWord: String = {
		return master
	}
	def isFound:Boolean ={
		return !entered.contains('-')
	}
	def availableLetters: String = {
		return lettersAvailable.toString
	}

	private def findReplace(letter: Char, base: String, entered: List[Char]):(List[Char], Boolean) ={
		if (entered.length==0) return (List(), false)
		var (next, found) = findReplace(letter, base.tail, entered.tail)
		if (base.head == letter){
			return (letter::next, true)
		}
		return (entered.head ::next, found)
	}
	
	def put(letter: Char): (Boolean, Boolean)= {
		def ucLetter = letter.toUpper
		if (!lettersAvailable.contains(ucLetter)) return (true, false)
		var (newEntered, found) = findReplace(ucLetter, master, entered)
		lettersAvailable = lettersAvailable.replaceAll(""+ucLetter, "-")
		if (!found){
			failures += 1
			return (false, false)
		}
		entered = newEntered
		return (false, true)
	}

	def getFailCount: Int= {
		return failures
	}
	def isFailed: Boolean = {
		return failures >= full.length-1
	}
	def picture: String = {
		if (isFailed) return full(full.length-1)
		else return full(failures)
	}
	def full = List(
	"""
  
  
  
  
   
  
   
""",
"""
  
  
  
   
  
   
 ----------  
""",  
"""  
    
    
    
    
    
 /  
 ----------  
""",  
"""  
    
    
    
    
    
 / \  
 ----------  
""",  
"""  
    
  |   
  |   
  |   
  |   
 /|\  
 ----------  
""",  
"""  
  +-----+  
  |  
  |  
  |  
  |  
 /|\  
 ----------  
""",  
"""  
  +-----+  
  |     |  
  |    
  |    
  |   
 /|\  
 ----------  
""",  
"""  
  +-----+  
  |     |  
  |    ( )  
  |  
  |  
 /|\  
 ----------  
""",  
"""  
  +-----+  
  |     |  
  |    ( )  
  |     |
  | 
 /|\
 ----------
""",
"""
  +-----+
  |     |
  |    ( )
  |     |
  |    / 
 /|\
 ----------
""",
"""
  +-----+
  |     |
  |    ( )
  |     |
  |    / \
 /|\
 ----------
	"""
		)
	
	
}
