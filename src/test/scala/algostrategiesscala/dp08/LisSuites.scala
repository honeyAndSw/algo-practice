package algostrategiesscala.dp08

import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * Created by honey.and.sw on 2017. 9. 2.
  */
class LisSuites extends FunSuite {
  test("lis example1") {
    Lis.solve2(Array(1, 2, 3, 4)) should equal (4)
    Lis.solve2(Array(5, 4, 3, 2, 1, 6, 7, 8)) should equal (4)
    Lis.solve2(Array(5, 6, 7, 8, 1, 2, 3, 4)) should equal (4)
    Lis.solve2(Array(5, 6, 7, 8, 1, 2, 3, 4, 5)) should equal (5)
  }

  test("lis 1") {
    Lis.solve2(Array()) should equal (0)
    Lis.solve2(Array(1)) should equal (1)
    Lis.solve2(Array(1, 1)) should equal (1)

    Lis.solve2(Array(5, 9, 3, 6, 3)) should equal (2)
    Lis.solve2(Array(5, 4, 3, 2, 1)) should equal (1)
  }

  test("lis 2") {
    Lis.solve2(Array(9, 1, 2, 3, 4)) should equal (4)
    Lis.solve2(Array(2, 5, 6, 1, 2)) should equal (3)
    Lis.solve2(Array(9, 1, 3, 7, 5, 6, 20)) should equal (5)
  }
}
