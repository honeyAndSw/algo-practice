package algostrategiesscala.dp08

import algostrategiesscala.dp08.Numb3rs.Problem
import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * Created by honey.and.sw on 2017. 9. 24.
  */
class Numb3rsSuites extends FunSuite {
  test("example1") {
    val town = Array(
      Array(0, 1, 1, 1, 0, 0, 0, 0), // 0
      Array(1, 0, 1, 0, 0, 0, 0, 0), // 1
      Array(1, 0, 1, 0, 0, 0, 0, 0), // 2
      Array(1, 1, 1, 0, 1, 1, 0, 0), // 3
      Array(0, 0, 0, 1, 0, 0, 1, 1), // 4
      Array(0, 0, 0, 1, 0, 0, 0, 1), // 5
      Array(0, 0, 0, 0, 1, 0, 0, 0), // 6
      Array(0, 0, 0, 0, 1, 1, 0, 0) // 7
    )

    Problem(town, 3, 0, 1).solve should equal (0.2)
    Problem(town, 3, 6, 1).solve should equal (0)

    Problem(town, 3, 1, 2).solve should equal (1 / 15.0)
  }

  test("example2") {
    val town = Array(
      Array(0, 1, 1, 1, 0),
      Array(1, 0, 0, 0, 1),
      Array(1, 0, 0, 0, 0),
      Array(1, 0, 0, 0, 0),
      Array(0, 1, 0, 0, 0)
    )

    // Problem(town: Array[Array[Int]], prison: Int, village: Int, day: Int)
    Problem(town, 0, 0, 2).solve.formatted("%,.8f") should equal ("0.83333333")
    Problem(town, 0, 2, 2).solve.formatted("%,.8f") should equal ("0.00000000")
    Problem(town, 0, 4, 2).solve.formatted("%,.8f") should equal ("0.16666667")
  }

  test("example3") {
    val town = Array(
      Array(0, 1, 1, 1, 0, 0, 0, 0),
      Array(1, 0, 0, 1, 0, 0, 0, 0),
      Array(1, 0, 0, 1, 0, 0, 0, 0),
      Array(1, 1, 1, 0, 1, 1, 0, 0),
      Array(0, 0, 0, 1, 0, 0, 1, 1),
      Array(0, 0, 0, 1, 0, 0, 0, 1),
      Array(0, 0, 0, 0, 1, 0, 0, 0),
      Array(0, 0, 0, 0, 1, 1, 0, 0)
    )

    println(Problem(town, 3, 3, 50).solve)

    // Problem(town: Array[Array[Int]], prison: Int, village: Int, day: Int)
    Problem(town, 3, 3, 2).solve.formatted("%.8f") should equal ("0.43333333")
    Problem(town, 3, 1, 2).solve.formatted("%.8f") should equal ("0.06666667")
    Problem(town, 3, 2, 2).solve.formatted("%.8f") should equal ("0.06666667")
    Problem(town, 3, 2, 2).solve.formatted("%.8f") should equal ("0.06666667")
  }

}
