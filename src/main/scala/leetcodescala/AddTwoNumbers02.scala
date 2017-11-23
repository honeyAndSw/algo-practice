package leetcodescala

/**
  * Created by honey.and.sw on 2017. 11. 23.
  */
object AddTwoNumbers02 {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = add(l1, l2, 0)

  def add(l1: ListNode, l2: ListNode, carry: Int): ListNode = {
    val (ol1, ol2) = (Option(l1), Option(l2))
    val sum = ol1.map(_.x).getOrElse(0) + ol2.map(_.x).getOrElse(0) + carry
    if (ol1.isEmpty && ol2.isEmpty && sum == 0) null
    else {
      val head = new ListNode(sum % 10)
      head.next = add(ol1.map(_.next).orNull, ol2.map(_.next).orNull, sum / 10)
      head
    }
  }

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x

    def append(_next: ListNode): ListNode = {
      this.next = _next
      this
    }

    def toArray: Array[Int] = if (next == null) Array(_x) else _x +: next.toArray
  }
}

