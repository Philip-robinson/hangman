package uk.co.rpl

import java.io.PrintStream

/**
  * Created by philip on 09/11/2016.
  */
class Out(printStream: PrintStream) {
  val MAX_LEN=50

  // print a blank line
  def prline(): Unit = prline("")
  // print a text string limit line to MAX_LEN characters
  def prline(lines: String) : Unit ={
    lines.split("\n").map(line => (line+(" " * MAX_LEN)).
      substring(0, MAX_LEN-4)).
      map(line => "# " + line + " #").
      foreach(printStream.println)
  }
}
