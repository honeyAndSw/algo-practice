package algostrategiesscala.dp08

object Jlis {
  case class Lis(seq: Array[Int]) {
    def setLis(sidx: Int, cache: Array[Array[Array[Int]]]): Array[Array[Array[Int]]] = {
      if (sidx == seq.length - 1) {
        cache(sidx)(0) = Array(seq(sidx))
      } else if (cache(sidx).length == 0) {
        val partOfCache = setLis(sidx + 1, cache)
        var lisMexLen: Int = 0

        val tempLisTuples: Iterable[(Array[Int], Int)] = for {
          jidx <- sidx until seq.length
          lidx <- 0 until partOfCache(jidx).length
          if (partOfCache(jidx)(lidx)(0) > seq(sidx))
          tempLis = partOfCache(jidx)(lidx)
        } yield {
          lisMexLen = Math.max(lisMexLen, 1 + tempLis.length)
          (seq(sidx) +: tempLis, 1 + tempLis.length)
        }

        cache(sidx) =
          tempLisTuples
            .filter(_._2 == lisMexLen)
            .map(_._1)
            .toArray
      }

      cache
    }
  }
}
