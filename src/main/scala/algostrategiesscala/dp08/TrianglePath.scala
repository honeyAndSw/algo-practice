package algostrategiesscala.dp08

import java.util.Scanner

object TrianglePath {

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val cases = sc.nextInt()
    for (_ <- 0 until cases) {
      val len = sc.nextInt()
      val triangle = Array.fill(len)(Array.fill(len)(0))
      val cache = Array.fill(len)(Array.fill(len)(0))

      for {
        h <- 0 until len
        w <- 0 to h
      } triangle(h)(w) = sc.nextInt()

      println(findPath(triangle, cache)(0, 0))
    }
  }

  val UNKNOWN: Int = 0

  def findPath(triangle: Array[Array[Int]], cache: Array[Array[Int]])(height: Int, width: Int): Int =
    if (height == triangle.length - 1) triangle(height)(width)
    else if (cache(height)(width) != UNKNOWN) cache(height)(width)
    else {
      val recursiveFindPath: (Int, Int) => Int = findPath(triangle, cache)

      cache(height)(width) = triangle(height)(width) +
        Math.max(recursiveFindPath(height + 1, width), recursiveFindPath(height + 1, width + 1))
      cache(height)(width)
    }
}
