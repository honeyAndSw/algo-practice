package algostrategiesscala.dp08

import algostrategiesscala.dp08.AsymTiling.Problem
import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * AsymTiling
  *
  * @author naheon
  * @since 2017. 09. 18.
  */
class AsymTilingSuites extends FunSuite {

  test("symmetric tiling") {
    Problem(4).symTiling(4) should equal (3)
    Problem(5).symTiling(5) should equal (2)
    Problem(7).symTiling(7) should equal (3)
  }

  test("example") {
    Problem(2).solve should equal (0)
    Problem(4).solve should equal (2)
    Problem(92).solve should equal (913227494)
  }

}
