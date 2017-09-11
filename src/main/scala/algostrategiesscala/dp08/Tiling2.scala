package algostrategiesscala.dp08

import java.util.Scanner

object Tiling2 {

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val cases = sc.nextInt()
    for (_ <- 0 until cases) {
      val n = sc.nextInt()
      val cache = Array.fill(n + 1)(-1)
      println(fill(n, cache))
    }
  }

  def fill(n: Int, cache: Array[Int]): Int = {
    if (n < 0) 0
    else if (n == 1 || n == 2) n
    else if (cache(n) != -1) cache(n)
    else {
      val next1: Int = fill(n - 1, cache)
      val next2: Int = fill(n - 2, cache)
      cache(n) = (next1 + next2) % 1000000007
      return cache(n)
    }
  }

}
