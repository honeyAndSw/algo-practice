package algostrategiesscala.dp08

import java.util.Scanner

object JumpGame {

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val cases: Int = sc.nextInt()

    for (_ <- 0 until cases) {
      val boardLength = sc.nextInt()
      val board: Array[Array[Int]] = Array.fill(boardLength)(Array.fill(boardLength)(0))

      for {
        y <- 0 until boardLength
        x <- 0 until boardLength
      } board(y)(x) = sc.nextInt()

      println(JumpGameSolver(board).solve)
    }
  }

  case class JumpGameSolver(board: Array[Array[Int]]) {

    def solve: String = {
      // -1 : impossible
      // 0 : unknown
      // 1 : possible
      val length = board.length
      val cache = Array.fill(length)(Array.fill(length)(0))
      if (canGoBottom(cache, 0, 0)) "YES" else "NO"
    }

    private def canGoBottom(cache: Array[Array[Int]], x: Int, y: Int): Boolean =
      if (y >= board.length || x >= board(0).length) false
      else if (y == board.length - 1 && x == board(0).length - 1) true
      else if (cache(y)(x) != 0) cache(y)(x) == 1
      else  {
        val afterMove: Boolean = canGoBottom(cache, x + board(y)(x), y) || canGoBottom(cache, x, y + board(y)(x))
        cache(y)(x) = if (afterMove) 1 else -1
        afterMove
      }
  }
}

