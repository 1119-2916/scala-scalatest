package tddtutorial

/**
 * 整数閉区間を表すクラス
 *
 * @param left 左辺値
 * @param right 右辺値
 */
sealed case class IntegerClosedInterval(left:Int, right:Int) {
  require(left <= right, "right value must be grater or equal than left value")

  override def toString: String = {
    "[" + left.toString + "," + right.toString + "]"
  }

  override def equals(obj: Any): Boolean = {
    obj match {
      case arg:IntegerClosedInterval => this.left == arg.left && this.right == arg.right
      case _ => false
    }
  }

  def isInside(num:Int): Boolean = {
    left <= num && num <= right
  }
}
