package algostrategiesscala.divideconquer07

/**
  * Created by honey.and.sw on 2017. 8. 20.
  */
object Multiply {

  def multiply(a: Array[Int], b: Array[Int]): Array[Int] = {
    val result: Array[Int] = new Array[Int](a.length + b.length + 1)

    for {
      ai <- 0 until a.length
      bi <- 0 until b.length
    } result(ai + bi) = result(ai + bi) + (a(ai) * b(bi))

    normalize(result)
  }

  private def normalize(num: Array[Int]): Array[Int] = {
    println(num.mkString(","))

    for (i <- 0 until (num.length - 1)) {
      num(i) match {
        case negative if num(i) < 0 => {
          val borrow: Int = (Math.abs(num(i)) + 9) / 10
          num(i + 1) = num(i + 1) - borrow
          num(i) = num(i) + (borrow * 10)
        }
        case _ => {
          num(i + 1) = num(i + 1) + (num(i) / 10)
          num(i) = num(i) % 10
        }
      }
    }

    // Remove 0s at the end of array
    num.reverse.dropWhile(_ == 0).reverse
  }
}
