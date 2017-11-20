package algostrategiesscala.combisearch11

import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * Kakuro2Suites
  *
  * @author naheon
  * @since 2017. 11. 20.
  */
class Kakuro2Suites extends FunSuite {

  val BOARD = Array(
    Array(0, 0, 0, 0, 0, 0, 0, 0),
    Array(0, 1, 1, 0, 0, 1, 1, 1),
    Array(0, 1, 1, 0, 1, 1, 1, 1),
    Array(0, 1, 1, 1, 1, 1, 0, 0),
    Array(0, 0, 1, 1, 0, 1, 1, 0),
    Array(0, 0, 0, 1, 1, 1, 1, 1),
    Array(0, 1, 1, 1, 1, 0, 1, 1),
    Array(0, 1, 1, 1, 0, 0, 1, 1)
  )

  val HINTS = Array(
    Array(2, 1, 0, 16), // horizontal sum
    Array(2, 5, 0, 24),
    Array(3, 1, 0, 17),
    Array(3, 4, 0, 29),
    Array(4, 1, 0, 35),
    Array(5, 2, 0, 7),
    Array(5, 5, 0, 8),
    Array(6, 3, 0, 16),
    Array(7, 1, 0, 21),
    Array(7, 6, 0, 5),
    Array(8, 1, 0, 6),
    Array(8, 6, 0, 3),
    Array(1, 2, 1, 23), // vertical sum
    Array(1, 3, 1, 30),
    Array(1, 6, 1, 27),
    Array(1, 7, 1, 12),
    Array(1, 8, 1, 16),
    Array(2, 5, 1, 17),
    Array(3, 4, 1, 15),
    Array(4, 7, 1, 12),
    Array(5, 5, 1, 7),
    Array(5, 8, 1, 7),
    Array(6, 2, 1, 11),
    Array(6, 3, 1, 10)
  )

  test("initialize") {
    Kakuro2.initialize(BOARD, HINTS)

    val boardHhint = Kakuro2.BOARD_HHINT.clone()
    val boardVhint = Kakuro2.BOARD_VHINT.clone()

    HINTS.foreach { arr =>
      arr(2) match {
        case Kakuro2.HORIZONTAL => boardHhint(arr(0) - 1)(arr(1) - 1) should equal (arr(3))
        case Kakuro2.VERTICAL => boardVhint(arr(0) - 1)(arr(1) - 1) should equal (arr(3))
      }
    }
  }

  test("findNextYX") {
    Kakuro2.initialize(BOARD, HINTS)
    Kakuro2.findNextYX(1, 2) should equal (Some((1, 5)))
    Kakuro2.findNextYX(1, 6) should equal (Some((1, 7)))
    Kakuro2.findNextYX(1, 7) should equal (Some((2, 1)))
    Kakuro2.findNextYX(7, 6) should equal (Some(7, 7))
    Kakuro2.findNextYX(7, 7) should equal (None)
  }

  test("solve") {
    val expected = Array(
      Array(0, 0, 0, 0, 0, 0, 0, 0),
      Array(0, 9, 7, 0, 0, 8, 7, 9),
      Array(0, 8, 9, 0, 8, 9, 5, 7),
      Array(0, 6, 8, 5, 9, 7, 0, 0),
      Array(0, 0, 6, 1, 0, 2, 6, 0),
      Array(0, 0, 0, 4, 6, 1, 3, 2),
      Array(0, 8, 9, 3, 1, 0, 1, 4),
      Array(0, 3, 1, 2, 0, 0, 2, 1)
    )

    val answer = Kakuro2.solve(BOARD, HINTS)
    Kakuro2.print
//    0,0,0,0,0,0,0,0
//    0,9,7,0,0,8,7,9
//    0,8,9,0,8,9,5,7
//    0,6,8,5,9,7,0,0
//    0,0,6,1,0,2,6,0
//    0,0,0,4,6,1,2,3
//    0,8,9,3,1,0,1,4
//    0,3,1,2,0,0,3,-1
    answer should equal (expected)
  }
}
