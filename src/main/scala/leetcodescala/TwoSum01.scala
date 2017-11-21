package leetcodescala

/**
  * TwoSum01
  * https://leetcode.com/problems/two-sum/description/
  * easy, array
  */
object TwoSum01 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    // `nums` could be negative, and other nums grater than `target` might be needed to make target.
    // So that filtering is unnecessary.
    // .filter(ni => ni._1 <= target)
    val indexedNums = nums.zipWithIndex

    val idxTuple: (Int, Int) = indexedNums.map { case (n1, i1) =>
        indexedNums.drop(i1 + 1)
          .find(_._1 + n1 == target)
          .map{ case (_, i2) => (i1, i2) }
      }.find(_.isDefined).get.get

    Array(idxTuple._1, idxTuple._2)
  }
}
