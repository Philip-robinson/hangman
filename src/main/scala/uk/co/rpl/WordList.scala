/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.rpl

import java.util._

import scala.io.Source

class WordList(file: String) {
	val words = Source.fromFile(file).getLines.toVector
	val rand = new Random(System.currentTimeMillis)

	def getRandom: String = {
		words(rand.nextInt(words.length))
	}
}
