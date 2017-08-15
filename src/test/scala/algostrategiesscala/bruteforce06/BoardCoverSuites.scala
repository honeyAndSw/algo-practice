package algostrategiesscala.bruteforce06

import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * Created by honey.and.sw on 2017. 8. 15.
  */
class BoardCoverSuites extends FunSuite {
  val T: Boolean = true
  val F: Boolean = false

  test("countCover small - 1") {
    val board = Array(
      Array(F, F, F),
      Array(F, F, F)
    )

    BoardCover.countBoardCover(board) should equal (2)
  }

  test("countCover - 1") {
    /*  #.....#
        #.....#
        ##...## */
    val board = Array(
      Array(T, F, F, F, F, F, T),
      Array(T, F, F, F, F, F, T),
      Array(T, T, F, F, F, T, T)
    )

    BoardCover.countBoardCover(board) should equal (0)
  }

  test("countCover - 2") {
    /*  #.....#
        #.....#
        ##..### */
    val board = Array(
      Array(T, F, F, F, F, F, T),
      Array(T, F, F, F, F, F, T),
      Array(T, T, F, F, T, T, T)
    )

    BoardCover.countBoardCover(board) should equal (2)
  }

  test("countCover - 3") {
    /*   ##########
         #........#
         #........#
         #........#
         #........#
         #........#
         #........#
         ##########  */
    val board = Array(
      Array(T, T, T, T, T, T, T, T, T, T),
      Array(T, F, F, F, F, F, F, F, F, T),
      Array(T, F, F, F, F, F, F, F, F, T),
      Array(T, F, F, F, F, F, F, F, F, T),
      Array(T, F, F, F, F, F, F, F, F, T),
      Array(T, F, F, F, F, F, F, F, F, T),
      Array(T, F, F, F, F, F, F, F, F, T),
      Array(T, T, T, T, T, T, T, T, T, T)
    )

    BoardCover.countBoardCover(board) should equal (1514)
  }

}
