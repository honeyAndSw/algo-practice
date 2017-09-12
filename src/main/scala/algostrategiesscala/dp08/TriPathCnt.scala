package algostrategiesscala.dp08

import java.util.Scanner

object TriPathCnt {

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val cases = sc.nextInt()
    for (_ <- 0 until cases) {
      val len = sc.nextInt()
      val cache = Array.fill(len)(Array.fill(len)((-1, -1)))
      val triangle = Array.fill(len)(Array.fill(len)(0))
      for {
        h <- 0 until len
        w <- 0 to h
      } triangle(h)(w) = sc.nextInt()

      println(pathCount(triangle, 0, 0, cache)._2)
    }
  }

  def pathCount(tri: Array[Array[Int]], x: Int, y: Int, cache: Array[Array[(Int, Int)]]): (Int, Int) = {
    val len = tri.length
    if (y == len - 1) (tri(y)(x), 1)
    else if (cache(y)(x)._1 != -1) cache(y)(x)
    else {
      val (s1, c1) = pathCount(tri, x, y + 1, cache)
      val (s2, c2) = pathCount(tri, x + 1, y + 1, cache)

      cache(y)(x) =
        if (s1 == s2) (tri(y)(x) + s1, c1 + c2)
        else if (s1 > s2)  (tri(y)(x) + s1, c1)
        else (tri(y)(x) + s2, c2)

      cache(y)(x)
    }
  }
}
