package com.lunatech.learning.scalacheck.generators

import org.scalacheck.Gen
import org.scalacheck.Arbitrary.arbitrary

object ParserGenerators {

  val genRangeString = for {
    start <- arbitrary[Int]
    stop <- arbitrary[Int]
    step <- arbitrary[Int]
  } yield List(start,stop,step).mkString(",")

}
