package uk.co.rpl

/**
  * Created by philip on 15/11/2016.
  */
object HangingMen {

  // how many hanging man stages are there
  def count():Int = hangedMenList.size

  // get the last (hanged) entry of the hanging man list
  def last():String = hangedMenList.last

  def entry(number: Int): String = {
    if (number<0 || number >=hangedMenList.size) null
    else hangedMenList(number)
  }
  // List of hanging man images as character art
  private def hangedMenList = List(
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
