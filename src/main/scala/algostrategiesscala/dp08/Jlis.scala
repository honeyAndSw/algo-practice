package algostrategiesscala.dp08

import scala.collection.mutable.Map

object Jlis {

  type Cache = Map[Int, List[List[Int]]]

  def solve(seq1: Array[Int], seq2: Array[Int]): Int = {
    val cache1: Cache = setCache(seq1)
    val cache2: Cache = setCache(seq2)
    ???
  }

  private def setCache(seq: Array[Int]): Cache = {
    val cache: Cache = Map.empty

    seq.reverse.foreach { s =>

    }

    cache
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
}
