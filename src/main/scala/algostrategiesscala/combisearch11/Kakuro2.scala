package algostrategiesscala.combisearch11

import scala.collection.mutable

/**
  * Created by honey.and.sw on 2017. 11. 18.
  * http://homoefficio.github.io/2016/06/26/for-loop-%EB%A5%BC-Stream-forEach-%EB%A1%9C-%EB%B0%94%EA%BE%B8%EC%A7%80-%EB%A7%90%EC%95%84%EC%95%BC-%ED%95%A0-3%EA%B0%80%EC%A7%80-%EC%9D%B4%EC%9C%A0/
  */
object Kakuro2 {

  def main(args: Array[String]): Unit = {

  }

  // direction is 0 if hint clue is a horizontal sum, 1 if the clue is a vertical sum.
  val HORIZONTAL = 0
  val VERTICAL = 1

  var BOARD: Array[Array[Int]] = _
  var BOARD_HHINT: Array[Array[Int]] = _
  var BOARD_VHINT: Array[Array[Int]] = _

  val HHINT: mutable.Map[String, Hint] = mutable.Map.empty
  val VHINT: mutable.Map[String, Hint] = mutable.Map.empty

  def initialize(board: Array[Array[Int]], hints: Array[Array[Int]]): Unit = {
    val len = board.length
    BOARD = board
    BOARD_HHINT = Array.fill(len)(Array.fill(len)(0))
    BOARD_VHINT = Array.fill(len)(Array.fill(len)(0))

    // each described with four integers: y, x, direction, and sum
    hints.foreach { hint =>
      val y = hint(0)
      val x = hint(1)
      val direction = hint(2)
      val sum = hint(3)

      val numofcells = numberOfCells(y, x, direction)
      val hintObj: Hint = Hint(y, x, sum, direction, numofcells)

      direction match {
        case HORIZONTAL =>
          BOARD_HHINT(y)(x) = sum
          for (x1 <- 1 to numofcells) {
            HHINT.put(yxKey(y, x1 + x), hintObj)
          }
        case VERTICAL =>
          BOARD_VHINT(y)(x) = sum
          for (y1 <- 1 to numofcells) {
            VHINT.put(yxKey(y1 + y, x), hintObj)
          }
      }
    }
  }

  private def numberOfCells(y: Int, x: Int, direction: Int): Int = {
    direction match {
      case HORIZONTAL =>
        BOARD(y).drop(x + 1).zipWithIndex.find(_._1 == 0).get._2
      case VERTICAL =>
        BOARD.indices
          .map(yi => BOARD(yi)(x))
          .drop(y + 1).zipWithIndex.find(_._1 == 0).get._2
    }
  }

  private def yxKey(y: Int, x: Int): String = y + "," + x

  def fillBoard(y: Int, x: Int): Boolean = {
    val nextYX: Option[(Int, Int)] = findNextYX(y, x)

    // true if nextYX is empty or map function return true
    nextYX.forall { case (nextY, nextX) =>
      val num: Option[Int] = (1 to 9).filter { n =>
        smallerThanHints(y, x, n) && !duplicated(y, x, n) && bigEnough(y, x, n)
      }.map { n =>
        BOARD(y)(x) = n
        (n, fillBoard(nextY, nextX))
      }
      .find(_._2) // filter and get valid `n`
      .map(_._1)

      // Reset board of set to valid `n`
      BOARD(y)(x) = num.getOrElse(1)
      num.isDefined
    }
  }

  private def findNextYX(y: Int, x: Int): Option[(Int, Int)] = {
    BOARD.zipWithIndex
      .drop(y)
      .map { case (row, yi) =>
        row.zipWithIndex
          .drop(if (yi == y) x + 1 else 0)
          .find(_._1 == 1)
          .map { case (v, xi) => (yi, xi, v) }
          .getOrElse((-1, -1, -1))
      }
      .find(_._3 > -1)
      .map { case (yi, xi, _) => (yi, xi) }
  }

  private def smallerThanHints(y: Int, x: Int, n: Int): Boolean =
    (n <= HHINT(yxKey(y, x)).value) && (n <= VHINT(yxKey(y, x)).value)

  private def duplicated(y: Int, x: Int, n: Int): Boolean = {
    val hhint = HHINT(yxKey(y, x))
    val hdup = BOARD(y).drop(hhint.x + 1).take(hhint.numofcells).contains(n)

    val vhint = VHINT(yxKey(y, x))
    val vdup = BOARD.indices
      .map(yi => BOARD(yi)(x))
      .slice(vhint.y + 1, vhint.y + 1 + vhint.numofcells)
      .contains(n)

    hdup || vdup
  }

  private def bigEnough(y: Int, x: Int, n: Int): Boolean = ???
}


case class Hint(y: Int, x: Int, value: Int, direction: Int, numofcells: Int)