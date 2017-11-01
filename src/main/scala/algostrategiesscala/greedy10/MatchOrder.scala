package algostrategiesscala.greedy10

import java.util.Scanner

/**
  * MatchOrder
  */
object MatchOrder {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val cases = sc.nextInt()
    for (_ <- 0 until cases) {
      val len: Int = sc.nextInt()
      val russia = (for (_ <- 0 until len) yield sc.nextInt()).toArray
      val korea = (for (_ <- 0 until len) yield sc.nextInt()).toArray
      println(win(russia, korea))
    }
  }

  def win(russia: Array[Int], korea: Array[Int]): Int = {
    val selected: Array[Boolean] = Array.fill(russia.length)(false)
    val indexedKorea: Array[(Int, Int/*Index*/)] = korea.zipWithIndex

    russia.map { r =>
      indexedKorea
        .map { case (k, ki) => (k - r, ki) }
        .sortBy(_._1) // ASC ordered differences
        .find { case (d, ki) => !selected(ki) && (d >= 0) }
        .map { case (d, ki) =>
          selected(ki) = true
          1
        }
        .getOrElse(0)
    }.sum
  }
}
