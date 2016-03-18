package com.lunatech.learning.scalacheck.properties

import com.lunatech.learning.scalacheck._
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import org.scalatest.Matchers

class ParserProperties extends Properties("Parser Properties") with Matchers {

  import com.lunatech.learning.scalacheck.generators.ParserGenerators
//  property("string parsed generates a sequence of at least 1 element") = forAll (ParserGenerators.genRangeString) { (str) =>
//    Parser.parseStringToSeq(str).length >= 1
//  }

  property("commons#parseStringToRange - creates sequence for a single int value") = forAll { (i: Int) =>
    val input = i.toString
    val output = Parser.parseStringToSeq(input)

    output.length == 1
    output.head == i
  }

  property("commons#parseStringToRange - throws IAE for any string") = forAll { (input: String) =>
    val ex = intercept[IllegalArgumentException] {
      Parser.parseStringToSeq(input)
    }
    ex.getMessage.trim.toLowerCase.equals("The input should contain either an Integer or a comma separated list of 3 integers.".toLowerCase)
  }

  property("commons#parseStringToRange - throws IAE for any string separated by commas") = forAll { (start: String, stop: String, step: String) =>
    val input = start + "," + stop + "," + step
    val ex = intercept[IllegalArgumentException] {
      Parser.parseStringToSeq(input)
    }
    ex.getMessage.trim.toLowerCase.equals("The input should contain either an Integer or a comma separated list of 3 integers.".toLowerCase)
  }

  property("commons#parseStringToRange - throws IAE for ints not satisfying requirements") = forAll { (start: Int, stop: Int, step: Int) =>
    val input = start + "," + stop + "," + step
    if ((start < stop) &&
      (step > 0) &&
      (((stop.toLong - start.toLong) / step.toLong) + 1L <= Int.MaxValue.toLong)) {
      val output = Parser.parseStringToSeq(input)
      output == ((start to stop) by step)

    } else {
      val ex = intercept[IllegalArgumentException] {
        Parser.parseStringToSeq(input)
      }
      ex.isInstanceOf[IllegalArgumentException]
    }
  }
}
