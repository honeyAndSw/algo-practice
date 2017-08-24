package algostrategiesscala.divideconquer07

/**
  * Fanmeeting
  *
  * @author naheon
  * @since 2017. 08. 24.
  */
object Fanmeeting {
  def main(args: Array[String]): Unit = {

  }

  def gendersToInts(str: String): Array[Int] = str.toCharArray.map {
    case 'M' => 1
    case 'F' => 0
  }

  /**
    * For bitwise operations, convert gender to this integers:
    * F = 0, M = 1
    */
  def hug(members: Array[Int], fans: Array[Int]): Int = {

    val memberBits: Int = members.foldLeft(0)((acc, m) => acc << 1 | m)

    var hugBits: Int = fans.take(members.length).foldLeft(0)((acc, f) => acc << 1 | f)
    val hugBitsMask: Int = (1 << (members.length - 1)) - 1

    // Simple lambda definition to get 1 if all members and fans could have hug.
    val couldHug: ((Int, Int) => Int) = (bit1, bit2) => if ((bit1 & bit2) == 0) 1 else 0

    // Whenever a member and a fan are both M(=1),
    // their bitwise AND result should be 1.
    // It then means count should not be increased in this case.
    var count: Int = couldHug(memberBits, hugBits)

    for (i <- members.length until fans.length) {
      hugBits = (hugBits << 1) & hugBitsMask | fans(i)
      val hug: Int = couldHug(memberBits, hugBits)
      if (hug == 1) {
        ???
      }
      count = count + hug
    }

    count
  }
}
