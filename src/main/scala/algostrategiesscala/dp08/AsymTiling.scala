package algostrategiesscala.dp08

import java.util.Scanner

/**
  * AsymTiling
  */
object AsymTiling {

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val cases = sc.nextInt()
    for (_ <- 0 until cases) {
      val n = sc.nextInt()
      println(Problem(n).solve)
    }
  }

  case class Problem(n: Int) {
    private val tilingCache: Array[Long] = Array.fill(n + 1)(-1)
    private val symTilingCache: Array[Long] = Array.fill(n + 1)(-1)

    private val MOD: Long = 1000000007

    /**
      * I manually calculate # of all tiling and # of symmetric tiling,
      * but it's possible to combine two things.
      * @return
      */
    def solve: Long = {
      val all = tiling(n)
      val sym = symTiling(n)
      (all - sym + MOD) % MOD
    }

    /**
      * Just for functional refactoring practice.
      */
    private def recursiveTiling(start: Int, end: Int => Option[Long], cache: Array[Long], continue: Int => Long): Long = {
      end(start)
        .orElse(Option(cache(start))
        .flatMap(l => if (l == -1) None else Some(l)))
        .orElse(Option(continue(start)))
        .get
    }

    def tiling(n: Int): Long = {
      if (n < 0) 0
      else if (n <= 2) n
      else if (tilingCache(n) != -1) tilingCache(n)
      else {
        val next1 = tiling(n - 1)
        val next2 = tiling(n - 2)
        tilingCache(n) = (next1 + next2) % MOD
        tilingCache(n)
      }
    }

    def symTiling(n: Int): Long = {
      if (n < 0) 0
      else if (n == 1) 0
      else if (n == 2) 2
      else if (symTilingCache(n) != -1) symTilingCache(n)
      else {
        val sn: Int = n / 2
        val half = tiling(sn)

        symTilingCache(n) =
          if (n % 2 == 0) (half + tiling(sn - 1)) % MOD
          else half % MOD

        symTilingCache(n)
      }
    }
  }

}
