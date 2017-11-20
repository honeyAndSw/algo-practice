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
  var BOARD_ANSWER: Array[Array[Int]] = _
  var BOARD_HHINT: Array[Array[Int]] = _
  var BOARD_VHINT: Array[Array[Int]] = _

  val HHINT: mutable.Map[String, Hint] = mutable.Map.empty
  val VHINT: mutable.Map[String, Hint] = mutable.Map.empty

  def solve(board: Array[Array[Int]], hints: Array[Array[Int]]): Array[Array[Int]] = {
    initialize(board, hints)
    val nextYX: (Int, Int) = findNextYX(0, 0).get
    val result = fillBoard(nextYX._1, nextYX._2)
    BOARD_ANSWER
  }

  def print: Unit = BOARD_ANSWER.foreach(row => println(row.mkString(",")))

  def initialize(board: Array[Array[Int]], hints: Array[Array[Int]]): Unit = {
    val len = board.length
    BOARD = board
    BOARD_ANSWER = Array.fill(len)(Array.fill(len)(0))

    // Set whitecells to -1
    BOARD.indices.foreach { y =>
      BOARD.indices.foreach { x =>
        if (BOARD(y)(x) == 1) BOARD_ANSWER(y)(x) = -1
      }
    }

    BOARD_HHINT = Array.fill(len)(Array.fill(len)(0))
    BOARD_VHINT = Array.fill(len)(Array.fill(len)(0))

    // each described with four integers: y, x, direction, and sum
    // y and x are 1-based integers
    hints.foreach { hint =>
      val y = hint(0) - 1
      val x = hint(1) - 1
      val direction = hint(2)
      val sum = hint(3)

      val numofcells = numberOfCells(y, x, direction)
      val hintObj: Hint = Hint(y, x, sum, direction, numofcells)

      direction match {
        case HORIZONTAL =>
          BOARD_HHINT(y)(x) = sum
          (1 to numofcells).foreach(x1 => HHINT.put(yxKey(y, x1 + x), hintObj))
        case VERTICAL =>
          BOARD_VHINT(y)(x) = sum
          (1 to numofcells).foreach(y1 => VHINT.put(yxKey(y1 + y, x), hintObj))
      }
    }
  }

  private def numberOfCells(hintY: Int, hintX: Int, direction: Int): Int = {
    val longestOnePrefixLen: (Iterable[Int] => Int) = itr => itr.toSeq.takeWhile(_ == 1).length

    direction match {
      case HORIZONTAL => longestOnePrefixLen(BOARD(hintY).drop(hintX + 1))
      case VERTICAL => longestOnePrefixLen(BOARD.indices.map(yi => BOARD(yi)(hintX)).drop(hintY + 1))
    }
  }

  private def yxKey(y: Int, x: Int): String = y + "," + x

  def fillBoard(y: Int, x: Int): Boolean = {
    val nextYX: Option[(Int, Int)] = findNextYX(y, x)

    println(s">>>>> ($x,$y)")
    // true if nextYX is empty or map function return true
    nextYX.forall { case (nextY, nextX) =>
      val num: Option[Int] = (1 to 9).toSeq
        .filter { n =>
          val predicate1 = smallerThanHints(y, x, n)
          val predicate2 = !duplicated(y, x, n)
          val predicate3 = bigEnough(y, x, n)

          println(s">> $n $predicate1 $predicate2 $predicate3")
          predicate1 && predicate2 && predicate3
        }.map { n =>
          BOARD_ANSWER(y)(x) = n
          (n, fillBoard(nextY, nextX))
        }
        .find(_._2) // filter and get valid `n`
        .map(_._1)

      // Reset board of set to valid `n`
      BOARD_ANSWER(y)(x) = num.getOrElse(-1)
      num.isDefined
    }
  }

  private def findNextYX(y: Int, x: Int): Option[(Int, Int)] = {
    BOARD_ANSWER.zipWithIndex
      .drop(y)
      .map { case (row, yi) =>
        row.zipWithIndex
          .drop(if (yi == y) x + 1 else 0)
          .find(_._1 == -1)
          .map { case (v, xi) => (yi, xi, v) }
          .getOrElse((-1, -1, -2))
      }
      .find(_._3 > -2)
      .map { case (yi, xi, _) => (yi, xi) }
  }

  private def smallerThanHints(y: Int, x: Int, n: Int): Boolean =
    (n <= HHINT(yxKey(y, x)).value) && (n <= VHINT(yxKey(y, x)).value)

  private def duplicated(y: Int, x: Int, n: Int): Boolean = {
    val hhint = HHINT(yxKey(y, x))
    val hdup = BOARD_ANSWER(y).toSeq.
      slice(hhint.x + 1, hhint.numofcells + hhint.x + 1)
      .contains(n)

    val vhint = VHINT(yxKey(y, x))
    val vdup = BOARD_ANSWER.indices
      .map(yi => BOARD_ANSWER(yi)(x))
      .slice(vhint.y + 1, vhint.y + 1 + vhint.numofcells)
      .contains(n)

    hdup || vdup
  }

  private def bigEnough(y: Int, x: Int, n: Int): Boolean = {
    val countEmptyCells: ((Iterable[Int]) => Int) = (itr) => itr.count(_ == -1)
    val remainingSum: ((Hint, Iterable[Int]) => Int) = (hint, itr) => hint.value - itr.filter(_ > -1).sum

    val hhint = HHINT(yxKey(y, x))
    // slice from the right next of hint
    val hhintCells = BOARD_ANSWER(y).toSeq.slice(hhint.x + 1, hhint.numofcells + hhint.x + 1)
    val hEmptyCells = countEmptyCells(hhintCells)

    val vhint = VHINT(yxKey(y, x))
    val vhintCells = BOARD_ANSWER.indices.map(yi => BOARD_ANSWER(yi)(x)).slice(vhint.y + 1, vhint.y + 1 + vhint.numofcells)
    val vEmptyCells = countEmptyCells(vhintCells)

    // hint.value <= n + (# of empty cells * 9)
    // hint.value - n <= # of empty cells * 9
    ((remainingSum(hhint, hhintCells) - n) <= (hEmptyCells - 1) * 9) &&
      ((remainingSum(vhint, vhintCells) - n) <= (vEmptyCells - 1) * 9)
  }
}


case class Hint(y: Int, x: Int, value: Int, direction: Int, numofcells: Int)