package leetcodescala

import leetcodescala.AddTwoNumbers02
import leetcodescala.AddTwoNumbers02.ListNode
import org.scalatest.FunSuite
import org.scalatest.Matchers._
import org.scalatest.matchers.{MatchResult, Matcher}

/**
  * Created by honey.and.sw on 2017. 11. 23.
  */
class AddTwoNumbers02Suites extends FunSuite {
  import CustomMatchers._

  test("add1") {
    val result1 = AddTwoNumbers02.addTwoNumbers(new ListNode(2), new ListNode(2))
    result1 should sameListNode (new ListNode(4))

    val result2 = AddTwoNumbers02.addTwoNumbers(new ListNode(0), new ListNode(0))
    result2 should sameListNode (new ListNode(0))
  }

  test("add2") {
    val result1 = AddTwoNumbers02.addTwoNumbers(
      new ListNode(2) append (new ListNode(4) append new ListNode(3)),
      new ListNode(5) append (new ListNode(6) append new ListNode(4))
    )
    result1 should sameListNode (new ListNode(7) append (new ListNode(0) append new ListNode(8)))

    val result2 = AddTwoNumbers02.addTwoNumbers(
      new ListNode(2) append (new ListNode(4) append new ListNode(6)),
      new ListNode(5) append (new ListNode(4) append new ListNode(4))
    )
    result2 should sameListNode (new ListNode(7) append (new ListNode(8) append (new ListNode(0) append new ListNode(1))))
  }

  test("add3 - different size") {
    val result1 = AddTwoNumbers02.addTwoNumbers(
      new ListNode(2) append new ListNode(4),
      new ListNode(5) append (new ListNode(6) append new ListNode(4))
    )
    result1 should sameListNode (new ListNode(7) append (new ListNode(0) append new ListNode(5)))

    val result2 = AddTwoNumbers02.addTwoNumbers(
      new ListNode(5) append (new ListNode(6) append new ListNode(4)),
      new ListNode(2) append new ListNode(4)
    )
    result2 should sameListNode (new ListNode(7) append (new ListNode(0) append new ListNode(5)))
  }

}

trait CustomMatchers {
  class SameListNodeMatcher(right: ListNode) extends Matcher[ListNode] {
    def apply(left: ListNode): MatchResult = {
      MatchResult(
        left.toArray.sameElements(right.toArray),
        s"""Different elements. left:${left.toArray.mkString(",")}, right:${right.toArray.mkString(",")}""",
        s"""Same elements."""
      )
    }
  }

  def sameListNode(right: ListNode) = new SameListNodeMatcher(right)
}

// Make them easy to import with:
// import CustomMatchers._
object CustomMatchers extends CustomMatchers
