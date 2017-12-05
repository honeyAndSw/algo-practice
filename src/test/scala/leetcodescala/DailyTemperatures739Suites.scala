package leetcodescala

import leetcodescala.DailyTemperatures739.dailyTemperatures
import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * DailyTemperatures739Suites
  *
  * @author naheon
  * @since 2017. 12. 05.
  */
class DailyTemperatures739Suites extends FunSuite {

  test("empty array") {
    dailyTemperatures(Array[Int]()) should equal (Array[Int]())
    dailyTemperatures(Array(1)) should equal (Array(0))
  }

  test("simple array") {
    dailyTemperatures(Array(73, 74)) should equal (Array(1, 0))
    dailyTemperatures(Array(74, 73)) should equal (Array(0, 0))
    dailyTemperatures(Array(74, 74)) should equal (Array(0, 0))
  }

  test("example") {
    dailyTemperatures(Array(73, 74, 75, 71, 69, 72, 76, 73)) should equal (Array(1, 1, 4, 2, 1, 1, 0, 0))
  }

  test("example2") {
    dailyTemperatures(Array(73, 74, 75, 71, 69, 72, 76, 77)) should equal (Array(1, 1, 4, 2, 1, 1, 1, 0))
  }
}
