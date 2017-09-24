package algostrategiesscala.dp08

import java.io.{BufferedReader, InputStreamReader}

/**
  * Created by honey.and.sw on 2017. 9. 24.
  */
object Numb3rs {

  val stdin = new BufferedReader(new InputStreamReader(System.in))

  def main(args: Array[String]): Unit = {
    val cases = Integer.parseInt(stdin.readLine())

    for (_ <- 0 until cases) {
      val target = stdin.readLine()
      val targets = target.split(" ")

      val townSize = targets(0).toInt
      val day = targets(1).toInt
      val prison = targets(2).toInt

      val town = Array.fill(townSize)(Array.fill(townSize)(0))
      for {
        y <- 0 until townSize
      } {
        val cells: Array[Int] = stdin.readLine().split(" ").map(_.toInt)
        town(y) = cells
      }

      val problemSize = Integer.parseInt(stdin.readLine())
      val result: Array[String] = stdin.readLine().split(" ")
          .map(_.toInt)
          .map { village =>
            Problem(town, prison, village, day).solve.formatted("%.8f")
          }

      println(result.mkString(" "))
    }
  }

  case class Problem(town: Array[Array[Int]], prison: Int, village: Int, day: Int) {

    val neighbors: Array[Int] = Array.fill(town.length)(0)
    val cache: Array[Array[Double]] = Array.fill(town.length)(Array.fill(day + 1)(-1))

    def solve: Double = {
      town.map(_.count(_ == 1))
        .zipWithIndex
        .foreach { case (l, i) =>
          neighbors(i) = l
        }

      hide(village, day)
    }

    def hide(m: Int, d: Int): Double =
      if (d == 0) {
        if (m == prison) 1.0 else 0.0
      } else if (cache(m)(d) > -1) {
        cache(m)(d)
      } else {
        val probability: Double = town(m)
          .zipWithIndex
          .filter(_._1 == 1)
          .map { case (n, i) =>
            hide(i, d - 1) / neighbors(i).toDouble
          }
          .sum

        cache(m)(d) = probability
        cache(m)(d)
      }
  }

}
