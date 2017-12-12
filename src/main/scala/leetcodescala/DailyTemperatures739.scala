package leetcodescala

/**
  * DailyTemperatures739
  */
object DailyTemperatures739 {
  /*
   * Time Limit Exceeded
   *
   * With temperatures Array(71,71,71,71,76,71,71,71,71,71,71),
   * (front, end) moves like:
   * (0,1) (0,2) (0,3) (0,4)
   * (1,2) (1,3) (1,4)
   * (2,3) (2,4)
   * (3,4)
   * (4,5) (4,6) (4,7) (4,8) (4,9) (4,10) (4,11)
   * (5,6) (5,7) (5,8) (5,9) (5,10) (5,11)
   * (6,7) (6,8) (6,9) (6,10) (6,11)
   * (7,8) (7,9) (7,10) 7,11)
   * (8,9) (8,10) (8,11)
   * (9,10) (9,11)
   * (10,11)
   */
  def dailyTemperatures0(temperatures: Array[Int]): Array[Int] = {
    val N = temperatures.length
    val wait: Array[Int] = Array.fill(N)(0)

    val indexes: Array[Int] = Array(0, 1)
    var use0: Boolean = true

    while (indexes(0) <= N && indexes(1) <= N) {
      val (front, back) = if (use0) (0, 1) else (1, 0)

      if (indexes(back) == N) {
        indexes(front) = indexes(front) + 2
        indexes(back) = indexes(front) - 1
        use0 = !use0
      } else if (temperatures(indexes(front)) < temperatures(indexes(back))) {
        wait(indexes(front)) = indexes(back) - indexes(front)
        indexes(front) = indexes(front) + 2
        indexes(back) = indexes(front) - 1
        use0 = !use0
      } else {
        indexes(back) = indexes(back) + 1
      }
    }

    wait
  }

  /* Not Scala one, but same Java solution accepted. */
  def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
    val ans: Array[Int] = Array.fill(temperatures.length)(0)
    val next: Array[Int] = Array.fill(101)(Integer.MAX_VALUE)

    for (i <- (temperatures.length - 1) to (0, -1)) {
      var warmerIndex = Integer.MAX_VALUE
      for (t <- (temperatures(i) + 1) to 100) {
        if (next(t) < warmerIndex) {
          warmerIndex = next(t)
        }
      }

      if (warmerIndex < Integer.MAX_VALUE) {
        ans(i) = warmerIndex - i
      }
      next(temperatures(i)) = i
    }

    ans
  }
}
