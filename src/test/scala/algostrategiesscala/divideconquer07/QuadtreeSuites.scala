package algostrategiesscala.divideconquer07

import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * Created by honey.and.sw on 2017. 8. 20.
  */
class QuadtreeSuites extends FunSuite {
  import Quadtree._

  test("decode") {
    decode("w", 0) should equal (new Node('w', 1))

    val expected: Node = Node('x', 5, new Node('b', 1), new Node('w', 1), new Node('w', 1), new Node('b', 1))
    decode("xbwwb", 0) should equal (expected)
  }

  test("encodeReversely") {
    encodeReversely(decode("w", 0)) should equal ("w")
    encodeReversely(decode("xbwwb", 0)) should equal ("xwbbw")
    encodeReversely(decode("xbwxwbbwb", 0)) should equal ("xxbwwbbbw")
    encodeReversely(decode("xxwwwbxwxwbbbwwxxxwwbbbwwwwbb", 0)) should equal ("xxwbxwwxbbwwbwbxwbwwxwwwxbbwb")
  }
}
