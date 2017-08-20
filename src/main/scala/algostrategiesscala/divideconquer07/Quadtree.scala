package algostrategiesscala.divideconquer07

import java.util.Scanner

/**
  * Simple Node of Quad Tree
  * @param ch one of 'x', 'w', or 'b'
  * @param len whole length of encoding results of this Node
  *
  * A node could have the following four children:
  * ⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽
  * | LT | RT |
  * | LB | RB |
  * ⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺
  */
case class Node(ch: Char, len: Int, LT: Node, RT: Node, LB: Node, RB: Node) {
  def this(ch: Char, len: Int) = this(ch, len, null, null, null, null)
}

object Quadtree {

  def main(args: Array[String]): Unit = {
    val sc: Scanner = new Scanner(System.in)
    var caseN: Int = sc.nextInt()
    while (caseN > 0) {
      println(encodeReversely(decode(sc.next(), 0)))
      caseN = caseN - 1
    }
  }

  /**
    * Constructs Node from encoded string input.
    *
    * @param input
    * @param idx index of input to start.
    * @return
    */
  def decode(input: String, idx: Int): Node =
    if (input.charAt(idx) == 'w') {
      new Node('w', 1)
    } else if (input.charAt(idx) == 'b') {
      new Node('b', 1)
    } else {
      var lenAccum: Int = 1
      val LT: Node = decode(input, idx + lenAccum)

      lenAccum = lenAccum + LT.len
      val RT: Node = decode(input, idx + lenAccum)

      lenAccum = lenAccum + RT.len
      val LB: Node = decode(input, idx + lenAccum)

      lenAccum = lenAccum + LB.len
      val RB: Node = decode(input, idx + lenAccum)

      lenAccum = lenAccum + RB.len
      Node('x', lenAccum, LT, RT, LB, RB)
    }

  /**
    * Encodes Node in a way that top and bottom is reversed.
    * @param head
    * @return
    */
  def encodeReversely(head: Node): String =
    if (head.len == 1) return head.ch.toString
    else s"x${encodeReversely(head.LB)}${encodeReversely(head.RB)}${encodeReversely(head.LT)}${encodeReversely(head.RT)}"
}
