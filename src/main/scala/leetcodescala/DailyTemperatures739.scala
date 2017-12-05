package leetcodescala

/**
  * DailyTemperatures739
  */
object DailyTemperatures739 {
  // Time Limit Exceeded
  def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
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
}
