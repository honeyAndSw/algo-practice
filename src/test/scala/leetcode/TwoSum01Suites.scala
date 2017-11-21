package leetcode

import leetcodescala.TwoSum01
import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * TwoSum01Suites
  */
class TwoSum01Suites extends FunSuite {
  test("twoSum1") {
    TwoSum01.twoSum(Array(2, 7, 11, 15), 9) should equal (Array(0, 1))
  }

  test("twoSum2") {
    TwoSum01.twoSum(Array(3, 2, 4), 6) should equal (Array(1, 2))
  }

  test("twoSum3") {
    TwoSum01.twoSum(Array(-3, 4, 3, 90), 0) should equal (Array(0, 2))
  }

}
