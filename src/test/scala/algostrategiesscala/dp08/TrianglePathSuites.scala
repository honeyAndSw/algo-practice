package algostrategiesscala.dp08

import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * Created by honey.and.sw on 2017. 9. 2.
  */
class TrianglePathSuites extends FunSuite {
  test("findPath example1") {
    val triangle = Array(
      Array(6),
      Array(1, 2),
      Array(3, 7, 4),
      Array(9, 4, 1, 7),
      Array(2, 7, 5, 9, 4)
    )
    val cache = Array.fill(5)(Array.fill(5)(0))
    TrianglePath.findPath(triangle, cache)(0, 0) should equal (28)
  }

  test("findPath example2") {
    val triangle = Array(
      Array(1),
      Array(2, 4),
      Array(8, 16, 8),
      Array(32, 64, 32, 64),
      Array(128, 256, 128, 256, 128)
    )
    val cache = Array.fill(5)(Array.fill(5)(0))
    TrianglePath.findPath(triangle, cache)(0, 0) should equal (341)
  }

  test("findPath 1") {
    val triangle = Array(
      Array(1),
      Array(1, 1),
      Array(1, 1, 1),
      Array(1, 1, 1, 1),
      Array(1, 1, 1, 1, 1)
    )
    val cache = Array.fill(5)(Array.fill(5)(0))
    TrianglePath.findPath(triangle, cache)(0, 0) should equal (5)
  }

}
