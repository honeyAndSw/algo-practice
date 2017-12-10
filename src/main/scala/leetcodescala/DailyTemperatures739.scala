package leetcodescala

/**
  * DailyTemperatures739
  */
object DailyTemperatures739 {

  /* Time Limit Exceeded */
  def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
    val N = temperatures.length
    val wait: Array[Int] = Array.fill(N)(0)

    val indexes: Array[Int] = Array(0, 1)
    var use0: Boolean = true

    while (indexes(0) <= N && indexes(1) <= N) {
      val (front, back) = if (use0) (0, 1) else (1, 0)

      // Position of front and back coule be similar to O(N^2)
      // in the following temperatures: [75, 71, 69, 72, 76]
      // (front, back)
      // (0, 4)
      // (1, 3)
      // (2, 3)
      // (3, 4)
      // (4, 5)
      if (indexes(back) == N) {
        // No answer for `front`.
        indexes(front) = indexes(front) + 2
        indexes(back) = indexes(front) - 1
        use0 = !use0
      } else if (temperatures(indexes(front)) < temperatures(indexes(back))) {
        // Found answer. Update `wait` and reset indexes to start from next `front`.
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
