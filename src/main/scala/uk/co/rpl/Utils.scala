package uk.co.rpl

/**
  * Created by philip on 09/11/2016.
  */
object Utils {
  val MAX_LEN=50

  // print a blank line
  def prline() = prline("")
  // print a text string limit line to 45 characters
  def prline(lines: String) : Unit ={
    lines.split("\n").map(line => (line+(" "*MAX_LEN)).substring(0,MAX_LEN)).map(line => "# "+line+" #").foreach(println)
  }
}
