package algostrategiesscala.dp08

import algostrategiesscala.dp08.Snail.Problem
import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * Created by honey.and.sw on 2017. 9. 16.
  * Problem(days, height)
  */
class SnailSuites extends FunSuite {
  test("basic cases") {
    Problem(1, 1).solve should equal (1)
    Problem(1, 2).solve should equal (0.25)
    Problem(2, 4).solve should equal (Math.pow(0.25, 2))
  }

  test("example1") {
    Problem(4, 5).solve should equal (0.99609375)
    Problem(3, 5).solve should equal (0.84375)
    Problem(2, 4).solve should equal (0.5625)
    Problem(2, 3).solve should equal (0.9375)
  }

  test("maximum input") {
    println(Problem(1000, 1000).solve)
  }

}
