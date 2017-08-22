package algostrategiesscala.divideconquer07

import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * FenceSuites
  *
  * @author naheon
  * @since 2017. 08. 22.
  */
class FenceSuites extends FunSuite {
  test("maxRectangle1") {
    val (width, height, _, _) = Fence.maxRectangle(Array(7, 1, 5, 9, 6, 7, 3), 0)
    (width * height) should equal (20)
  }

  test("maxRectangle2") {
    val (width, height, _, _) = Fence.maxRectangle(Array(1, 4, 4, 4, 4, 1, 1), 0)
    (width * height) should equal (16)
  }

  test("maxRectangle3") {
    val (width, height, _, _) = Fence.maxRectangle(Array(1, 8, 2, 2), 0)
    (width * height) should equal (8)
  }

  test("maxRectangle4") {
    val (width, height, _, _) = Fence.maxRectangle(Array(5, 6, 7, 8, 9, 1, 2, 3), 0)
    (width * height) should equal (25)
  }

  test("maxRectangle5") {
    val (width, height, _, _) = Fence.maxRectangle(Array(10), 0)
    (width * height) should equal(10)
  }

  test("maxRectangle") {
    val rect: (Int, Int, Int, Int) = Fence.maxRectangle(Array(7, 1, 5, 9, 6, 7, 3), 0)
    (rect._1 * rect._2) should equal (20)
  }

  test("maxRectangle2") {
    val (w, h, _, _) = Fence.maxRectangle(Array.fill(20000)(1), 0)
    (w * h) should equal (20000)
  }

}
