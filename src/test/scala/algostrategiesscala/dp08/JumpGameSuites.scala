package algostrategiesscala.dp08

import algostrategiesscala.dp08.JumpGame.JumpGameSolver
import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * Created by honey.and.sw on 2017. 8. 29.
  */
class JumpGameSuites extends FunSuite {
  test("JumpGame 1") {
    val solver = JumpGameSolver(Array(
      Array(2, 5, 1, 6, 1, 4, 1),
      Array(6, 1, 1, 2, 2, 9, 3),
      Array(7, 2, 3, 2, 1, 3, 1),
      Array(1, 1, 3, 1, 7, 1, 2),
      Array(4, 1, 2, 3, 4, 1, 2),
      Array(3, 3, 1, 2, 3, 4, 1),
      Array(1, 5, 2, 9, 4, 7, 0)
    ))
    solver.solve should equal ("YES")
  }

  test("JumpGame2") {
    val solver = JumpGameSolver(Array(
      Array(2, 5, 1, 6, 1, 4, 1),
      Array(6, 1, 1, 2, 2, 9, 3),
      Array(7, 2, 3, 2, 1, 3, 1),
      Array(1, 1, 3, 1, 7, 1, 2),
      Array(4, 1, 2, 3, 4, 1, 3),
      Array(3, 3, 1, 2, 3, 4, 1),
      Array(1, 5, 2, 9, 4, 7, 0)
    ))
    solver.solve should equal ("NO")
  }

}
