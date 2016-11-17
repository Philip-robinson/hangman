package uk.co.rpl

import org.junit._
import org.junit.Assert._


class WordHolderTest {


  @Before
  def setUp: Unit = {
  }

  @After
  def tearDown: Unit = {
  }

  @Test
  def init = {
    var inst = new WordHolder("abcdefGHJIKL")
    assertEquals(0, inst.getFailCount)
    assertEquals("------------", inst.toString)
    assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", inst.availableLetters)
  }
  @Test
  def not_found = {
    var inst = new WordHolder("abcdefGHJIKL")
    inst.put('X')
    assertEquals(1, inst.getFailCount)
    assertEquals("------------", inst.toString)
    assertEquals("ABCDEFGHIJKLMNOPQRSTUVW-YZ", inst.availableLetters)
    inst.put('z')
    assertEquals(2, inst.getFailCount)
    assertEquals("------------", inst.toString)
    assertEquals("ABCDEFGHIJKLMNOPQRSTUVW-Y-", inst.availableLetters)
  }

  @Test
  def found = {
    var inst = new WordHolder("abcdefGHJIKLghijkl")
    inst.put('a')
    assertEquals(0, inst.getFailCount)
    assertEquals("A-----------------", inst.toString)
    assertEquals("-BCDEFGHIJKLMNOPQRSTUVWXYZ", inst.availableLetters)
    inst.put('g')
    assertEquals(0, inst.getFailCount)
    assertEquals("A-----G-----G-----", inst.toString)
    assertEquals("-BCDEF-HIJKLMNOPQRSTUVWXYZ", inst.availableLetters)
  }
  @Test
  def full = {
    var inst = new WordHolder("abcdefGHJIKLghijkl")
    inst.put('a')
    inst.put('b')
    inst.put('c')
    inst.put('d')
    inst.put('e')
    inst.put('f')
    inst.put('g')
    inst.put('h')
    inst.put('i')
    inst.put('j')
    inst.put('k')
    inst.put('l')
    assertEquals(0, inst.getFailCount)
    assertEquals("ABCDEFGHJIKLGHIJKL", inst.toString)
    assertEquals("------------MNOPQRSTUVWXYZ", inst.availableLetters)
  }

}
