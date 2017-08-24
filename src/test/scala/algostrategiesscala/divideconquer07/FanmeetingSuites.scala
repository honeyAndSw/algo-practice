package algostrategiesscala.divideconquer07

import org.scalatest.FunSuite
import org.scalatest.Matchers._

import Fanmeeting._

/**
  * FanmeetingSuites
  *
  * @author naheon
  * @since 2017. 08. 24.
  */
class FanmeetingSuites extends FunSuite {
  val F: Int = 0
  val M: Int = 1

  test("hug1") {
    //hug(Array(F, F, F, M, M, M), Array(M, M, M, F, F, F)) should equal (1)
    //hug(Array(F, F, F, F, F), Array(F, F, F, F, F, F, F, F, F, F)) should equal (6)
    //hug(Array(F, F, F, F, M), Array(F, F, F, F, F, M, M, M, M, F)) should equal (2)
    hug(gendersToInts("MFMFMFFFMMMFMF"), gendersToInts("MMFFFFFMFFFMFFFFFFMFFFMFFFFMFMMFFFFFFF")) should equal (2)
  }

}
