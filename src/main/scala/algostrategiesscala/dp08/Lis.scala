package algostrategiesscala.dp08

import java.util.Scanner

object Lis {

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val cases = sc.nextInt()
    for (_ <- 0 until cases) {
      val seqLen = sc.nextInt()
      val seq = (for (_ <- 0 until seqLen) yield sc.nextInt()).toArray
      println(solve2(seq))
    }
  }

  def solve2(seq: Array[Int]): Int = {
    val cache: Array[Int] = Array.fill(seq.length)(-1)

    // Iterate seq backwards and set its cache.
    for (sid <- seq.length - 1 to 0 by -1) {
      // The body of for loop is logically identical to code 8.11.
      var max: Int = 0
      for (cid <- sid + 1 until seq.length) {
        max = if (seq(sid) < seq(cid)) Math.max(cache(cid), max)
              else max
      }

      cache(sid) = max + 1
    }

    if (cache.isEmpty) 0 else cache.max
  }

  /*
   * Couldn't solve:
   * Lis.solve(Array(9, 1, 3, 7, 5, 6, 20)) should equal (5)
   */
  def solve(seq: Array[Int]): Int = {
    val seqWithIdx: Array[(Int/*seq*/, Int/*index*/)] = seq.zipWithIndex
    val cache: Array[Int] = seqWithIdx.map { case (s, i) =>
      seqWithIdx.drop(i).find(_._1 > s).map(_._2).getOrElse(-1)
    }

    val eachPaths: Iterable[Int] = for (s <- 0 until seq.length) yield {
      var ci: Int = cache(s)
      var path: List[Int] = List(seq(s))
      while (ci != -1) {
        path = path :+ seq(ci)
        ci = cache(ci)
      }

      path.size
    }

    if (eachPaths.isEmpty) 0 else eachPaths.max
  }
}
