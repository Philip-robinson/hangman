package uk.co.rpl

import org.junit._
import org.junit.Assert._
/**
  * Created by philip on 15/11/2016.
  */
class HangingMenTest {
  @Test
  def countTest()={
    assertEquals(11, HangingMen.count())
  }
  def lastTest()={
    assertEquals(HangingMen.entry(11), HangingMen.last)
  }
  def entryTest()={
    for (i <- 0 to 9) {
      assertFalse(HangingMen.entry(i) == HangingMen.entry(i + 1))
      assertTrue(HangingMen.entry(i) == HangingMen.entry(i))
    }
  }

}
