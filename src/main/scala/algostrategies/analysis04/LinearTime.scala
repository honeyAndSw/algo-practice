package algostrategies.analysis04

object LinearTime {
  /**
    * 코드 4.3 이동 평균 구하기
    * @param input
    * @param M
    * @return
    */
  def movingAverage1(input: Array[Double], M: Int): Array[Double] = {
    val input1 = input.toTraversable

    (for {
      i <- (M - 1) until input.length
    } yield {
      input1.slice(i - M + 1, i + 1).reduce(_ + _) / M
    }) toArray
  }

  /**
    * 코드 4.4 선형 시간에 이동 평균 구하기
    * @param input
    * @param M
    * @return
    */
  def movingAverage2(input: Array[Double], M: Int): Array[Double] = {
    // 아래 for-loop에서 update 해야하므로 variable로 선언한다.
    var initialPartialSum: Double = input.take(M - 1).reduce(_ + _)

    (for {
      i <- (M - 1) until input.length
    } yield {
      val ret: Double = (initialPartialSum + input(i)) / M
      initialPartialSum = initialPartialSum + input(i) - input(i - M + 1)
      ret
    }) toArray
  }

}
