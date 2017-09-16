package algostrategiesscala.dp08

import java.util.Scanner

/**
  * Created by honey.and.sw on 2017. 9. 16.
  */
object Snail {

  def main(args: Array[String]): Unit = {
    val sc: Scanner = new Scanner(System.in)
    val cases: Int = sc.nextInt()

    for (_ <- 0 until cases) {
      val height: Int = sc.nextInt()
      val days: Int = sc.nextInt()
      println(Problem(days, height).solve)
    }
  }

  case class Problem(days: Int, height: Int) {
    val cache: Array[Array[Double]] = Array.fill(days)(Array.fill(2 * days)(-1))

    def solve: Double = countGoUp(0, 0)

    /*
     * Not accepted due to runtime error.
     */
    def countGoUp(daysSoFar: Int, heightSoFar: Int): Double =
      if (daysSoFar >= days) {
        if (daysSoFar == days && heightSoFar >= height) 1 else 0
      } else if (cache(daysSoFar)(heightSoFar) > -1) {
        cache(daysSoFar)(heightSoFar)
      } else {
        val rainTomorrow = countGoUp(daysSoFar + 1, heightSoFar + 2)
        val shineTomorrow = countGoUp(daysSoFar + 1, heightSoFar + 1)
        cache(daysSoFar)(heightSoFar) = (shineTomorrow * 0.25) + (rainTomorrow * 0.75)
        cache(daysSoFar)(heightSoFar)
      }
  }
}
