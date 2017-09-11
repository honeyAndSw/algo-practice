package algostrategiesscala.dp08

import org.scalatest.FunSuite
import org.scalatest.Matchers._

class Tiling2Suites extends FunSuite {
  test("fill examples") {
    fill(1) should equal (1)
    fill(5) should equal (8)
    fill(100) should equal (782204094)
  }

  private def fill(n: Int): Int = {
    val cache = Array.fill(n + 1)(-1)
    Tiling2.fill(n, cache)
  }

}
