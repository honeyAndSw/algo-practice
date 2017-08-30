package algostrategiesscala.dp08

import algostrategiesscala.dp08.Wildcard.WildcardProblem
import org.scalatest.FunSuite
import org.scalatest.Matchers._

/**
  * Created by honey.and.sw on 2017. 8. 30.
  */
class WildcardSuites extends FunSuite {
  test("Wildcard 1") {
    WildcardProblem("help", "he?p").solve should equal (true)
    WildcardProblem("heap", "he?p").solve should equal (true)
    WildcardProblem("helpp", "he?p").solve should equal (false)
  }

  test("Wildcard 2") {
    WildcardProblem("help", "*p*").solve should equal (true)
    WildcardProblem("papa", "*p*").solve should equal (true)
    WildcardProblem("hello", "*p*").solve should equal (false)
  }

  test("Wildcard 3") {
    WildcardProblem("help", "*h*").solve should equal (true)
    WildcardProblem("help", "h*").solve should equal (true)
    WildcardProblem("help", "*p").solve should equal (true)
    WildcardProblem("help", "*").solve should equal (true)
    WildcardProblem("", "*").solve should equal (true)
  }

  test("Wildcard 4") {
    WildcardProblem("help", "?elp").solve should equal (true)
    WildcardProblem("help", "?el?").solve should equal (true)
    WildcardProblem("help", "?").solve should equal (false)
    WildcardProblem("help", "?el").solve should equal (false)
    WildcardProblem("", "?").solve should equal (false)
  }

  test("Wildcard 5") {
    WildcardProblem("wildcardtest", "*card*").solve should equal (true)
    WildcardProblem("wildcardtest", "*tes?").solve should equal (true)
    WildcardProblem("wildcardtest", "?wildcardtest").solve should equal (false)
    WildcardProblem("wildcardtest", "*wildcardtest").solve should equal (true)

    WildcardProblem("wildcardtest", "*wil?card*").solve should equal (true)
    WildcardProblem("wildcardtest", "wildcardtest").solve should equal (true)
  }

  test("Wildcard 6") {
    WildcardProblem.orderIfMatch(Array("wildcardtest", "Wildcardtest", "1ildcardtest"), "*card*") should equal ("1ildcardtest\nWildcardtest\nwildcardtest")
    WildcardProblem.orderIfMatch(Array("a", "B", "c", "1"), "*") should equal ("1\nB\na\nc")
  }

  test("Wildcard 7") {
    WildcardProblem("aaaaaaaaaab", "******a").solve should equal (false)
  }

}
