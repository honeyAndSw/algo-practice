package algostrategiesscala.divideconquer07

import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * Created by honey.and.sw on 2017. 8. 20.
  */
class MultiplySuites extends FunSuite {
  test("multiply1") {
    // 2 * 5 = 10
    Multiply.multiply(Array(2), Array(5)) should equal (Array(0, 1))

    // 123 * 456 = 56088
    Multiply.multiply(Array[Int](3, 2, 1), Array[Int](6, 5, 4)) should equal (Array[Int](8, 8, 0, 6, 5))
  }

  test("multiply2") {
    // (-52) * 3 = -156
    Multiply.multiply(Array(2, -5), Array(3)) should equal (Array(6, 5, -1))
  }

}
