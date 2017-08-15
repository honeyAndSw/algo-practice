package algostrategiesscala.bruteforce06

/**
  * Created by honey.and.sw on 2017. 8. 15.
  */
object BoardCover {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    var caseM: Int = sc.nextInt()
    while (caseM > 0) {
      val h: Int = sc.nextInt()
      val w: Int = sc.nextInt()

      val board: Array[Array[Boolean]] = (
        for (_ <- 0 until h) yield {
          sc.next().toCharArray.map(ch => if (ch == '#') true else false)
        }
      ).toArray

      println(countBoardCover(board))
      caseM -= 1
    }
  }

  private val covers: Array[Array[Array[Int]]] = Array(
    Array(Array(0, 0), Array(0, 1), Array(1, 0)),
    Array(Array(0, 0), Array(0, 1), Array(1, 1)),
    Array(Array(0, 0), Array(0, 1), Array(-1, 1)),
    Array(Array(0, 0), Array(1, 0), Array(1, 1))
  )

  def countBoardCover(board: Array[Array[Boolean]]): Int = {
    val startPosition: IndexedSeq[Option[(Int, Int)]] = (for (y <- 0 until board.length) yield {
      val first: Option[(Boolean, Int)] = board(y).zipWithIndex.find(_._1 == false)
      if (first.isDefined) Some(first.get._2, y) else None
    }).filter(_.isDefined)

    if (startPosition.size == 0) 1
    else {
      val (x, y): ((Int, Int)) = startPosition.head.get
      val recursiveResult = for (cover <- covers) yield {
        val success: Boolean = coverBoard(board, x, y, cover, true/*to black*/)
        val count = if (success) countBoardCover(board) else 0
        coverBoard(board, x, y, cover, false/*to white*/)
        count
      }

      recursiveResult.reduce(_ + _)
    }
  }

  private def coverBoard(board: Array[Array[Boolean]], x: Int, y: Int, how: Array[Array[Int]], toBlack: Boolean)
  : Boolean = {
    var doneAll: Boolean = true

    for {
      h <- how
      (ax, ay) = (x + h(0), y + h(1))
    } {
      if (ax < 0 || ax >= board(0).length || ay < 0 || ay >= board.length) {
        doneAll = false
      } else if (board(ay)(ax) == toBlack) {
        doneAll = false
        board(ay)(ax) = !board(ay)(ax)
      } else {
        board(ay)(ax) = !board(ay)(ax)
      }
    }

    doneAll
  }

}
