package algostrategiesscala.divideconquer07

import java.util.Scanner

/**
  * Fence
  *
  * @author naheon
  * @since 2017. 08. 22.
  */
object Fence {

  def main(args: Array[String]): Unit = {
    val sc: Scanner = new Scanner(System.in)
    var caseM: Int = sc.nextInt()

    while (caseM > 0) {
      val fenceN: Int = sc.nextInt()
      val heights: Array[Int] = (for (_ <- 0 until fenceN) yield sc.nextInt()).toArray
      val (maxW, maxH, _, _) = maxRectangle(heights, 0)
      println(maxW * maxH)

      caseM = caseM - 1
    }
  }

  // (width, height, start idx, end idx)
  type MaxSize = (Int, Int, Int, Int)

  /**
    *
    * 1) It uses stacks too much that it throws StackoverflowError if heights have 20,000 elements.
    * 2) This logic could not compare the left maxRectangle and right maxRectangle at the same time.
    */
  def maxRectangle(heights: Array[Int], idx: Int): MaxSize = {
    val h: Int = heights(idx)

    if (idx + 1 == heights.length) {
      (1, h, idx, idx)
    } else {
      val next: MaxSize = maxRectangle(heights, idx + 1)
      val (nwidth, nheight, nstart, nend) = next

      if (h >= nheight) {
        if (idx + 1 == nstart) {
          // It's possible to expand `next`.
          selectBigger((1, h, idx, idx), (nwidth + 1, nheight, idx, nend))
        } else {
          // It's not possible to expand `next`, so just compare itself and `next`.
          selectBigger((1, h, idx, idx), next)
        }
      } else {
        if (idx + 1 == nstart) {
          selectBigger((nwidth + 1, h, idx, nend), next)
        } else {
          next
        }
      }
    }
  }

  private def selectBigger(m1: MaxSize, m2: MaxSize): MaxSize = {
    val i1: Int = m1._1 * m1._2
    val i2: Int = m2._1 * m2._2
    if (i1 > i2) m1 else m2
  }
}
