package com.lunatech.learning.scalacheck

import org.scalatest.{Matchers, FunSuite}

class ParserSpec extends FunSuite with Matchers {

  test("parseStringToSeq parses string to sequence of Ints") {
    val input1 = "1,10,2"
    val expectedOutput1 = Seq(1, 3, 5, 7, 9)
    assert(Parser.parseStringToSeq(input1) == expectedOutput1)

    val input2 = "Maria"
    //Exception has to be handled
    intercept[java.lang.IllegalArgumentException] {
      Parser.parseStringToSeq(input2)
    }

    //Invalid Range should not be accepted
    val input3 = "10,1,2"
    println(Parser.parseStringToSeq(input3))

  }

}
