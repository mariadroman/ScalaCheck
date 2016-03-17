package com.lunatech.learning.scalacheck.properties

import com.lunatech.learning.scalacheck._
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

class ParserProperties extends Properties("Parser Properties") {

  import com.lunatech.learning.scalacheck.generators.ParserGenerators
  property("string parsed generates a sequence of at least 1 element") = forAll (ParserGenerators.genRangeString) { (str) =>
    Parser.parseStringToSeq(str).length >= 1
  }
}
