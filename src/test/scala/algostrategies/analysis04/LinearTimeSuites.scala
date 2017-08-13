package algostrategies.analysis04

import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * Created by honey.and.sw on 2017. 7. 30.
  */
class LinearTimeSuites extends FunSuite {
  test("movingAverage1") {
    LinearTime.movingAverage1(Array(1.0, 1.0), 3) should be (empty)
    LinearTime.movingAverage1(Array(1.0, 1.0, 1.0), 3) should equal (Array(1.0))
    LinearTime.movingAverage1(Array(1.0, 1.0, 1.0, 1.0), 3) should equal (Array(1.0, 1.0))
  }

  test("movingAverage2") {
    LinearTime.movingAverage2(Array(1.0, 1.0), 3) should be (empty)
    LinearTime.movingAverage2(Array(1.0, 1.0, 1.0), 3) should equal (Array(1.0))
    LinearTime.movingAverage2(Array(1.0, 1.0, 1.0, 1.0), 3) should equal (Array(1.0, 1.0))
  }
}
