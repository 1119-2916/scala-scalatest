package tddtutorial

import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, convertToAnyShouldWrapper}

class IntegerClosedIntervalSuite extends FunSuite {

  test("整数閉区間オブジェクトは文字列表現を[(下端値),(上端値)]の形で返す。") {
    // 準備
    val integerClosedInterval = IntegerClosedInterval(3, 8)
    // 実行, 確認
    integerClosedInterval.toString shouldBe "[3,8]"

    // 三角測量
    val integerClosedInterval2 = IntegerClosedInterval(4, 8)
    integerClosedInterval2.toString shouldBe "[4,8]"
  }

  test("整数の閉区間は指定した整数を含むかどうかを判定する。") {
    // 準備
    val integerClosedInterval = IntegerClosedInterval(3, 8)
    // 実行, 確認
    integerClosedInterval.isInside(3) shouldBe true
    integerClosedInterval.isInside(2) shouldBe false
  }

  test("上端点より下端点が大きい閉区間を作ることはできない。") {
    an[IllegalArgumentException] should be thrownBy IntegerClosedInterval(8, 7)
  }

  test("別の閉区間と等価か判定する。") {
    val integerClosedInterval = IntegerClosedInterval(-1, 1)
    integerClosedInterval.equals(IntegerClosedInterval(-1, 1)) shouldBe true
    integerClosedInterval.equals(IntegerClosedInterval(0, 1)) shouldBe false
  }

  test("別の閉区間を完全に含んでいるか判定する。") {
    val integerClosedInterval = IntegerClosedInterval(1, 10)
    integerClosedInterval.isInside(IntegerClosedInterval(2,3)) shouldBe true
    integerClosedInterval.isInside(IntegerClosedInterval(0,1)) shouldBe false
  }
}
