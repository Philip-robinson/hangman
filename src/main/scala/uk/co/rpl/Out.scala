package uk.co.rpl

import java.io.PrintStream

/**
  * Created by philip on 09/11/2016.
  */
class Out(printStream: PrintStream) {
  val MAX_LEN=50

  // print a blank line
  def prline(): Unit = prline("")

  // print a text string padded with spaces to MAX_LEN characters
  // and wrap with # characters i.e.
  // # some text         #
  // if the line exceeds MAX_LEN then print as is
  def prline(lines: String) : Unit ={
    lines.split("\n").map(line => (if (line.length>=MAX_LEN-4)line else line+(" " * MAX_LEN)).
      substring(0, MAX_LEN-4)).
      map(line => "# " + line + " #").
      foreach(printStream.println)
  }
}
