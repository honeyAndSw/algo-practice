package algostrategiesscala.dp08

import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * Created by honey.and.sw on 2017. 9. 12.
  */
class TriPathCntSuites extends FunSuite {
  test("example 1") {
    val triangle = Array(
      Array(9),
      Array(5, 7),
      Array(1, 3, 2),
      Array(3, 5, 5, 6)
    )
    val cache = Array.fill(4)(Array.fill(4)((-1, -1)))

    TriPathCnt.pathCount(triangle, 0, 0, cache)._2 should equal (3)
  }

  test("example 2") {
    val triangle = Array(
      Array(1),
      Array(1, 1),
      Array(1, 1, 1),
      Array(1, 1, 1, 1)
    )
    val cache = Array.fill(4)(Array.fill(4)((-1, -1)))

    TriPathCnt.pathCount(triangle, 0, 0, cache)._2 should equal (8)
  }

}
