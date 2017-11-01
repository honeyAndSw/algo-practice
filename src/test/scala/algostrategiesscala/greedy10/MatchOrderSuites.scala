package algostrategiesscala.greedy10

import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * MatchOrderSuites
  */
class MatchOrderSuites extends FunSuite {
  test("examples") {
    MatchOrder.win(
      Array(3000, 2700, 2800, 2200, 2500, 1900),
      Array(2800, 2750, 2995, 1800, 2600, 2000)
    ) should equal (5)

    MatchOrder.win(Array(1, 2, 3), Array(3, 2, 1)) should equal (3)
    MatchOrder.win(Array(2, 3, 4, 5), Array(1, 2, 3, 4)) should equal (3)
  }

  test("examples2") {
    MatchOrder.win(Array(2, 3, 4, 5), Array(1, 2, 3, 5)) should equal (3)
  }
}
