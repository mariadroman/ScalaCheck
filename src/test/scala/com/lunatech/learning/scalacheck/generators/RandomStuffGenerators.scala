package com.lunatech.learning.scalacheck.generators

import org.scalacheck.Gen
import org.scalacheck.Gen._
import org.scalacheck.Arbitrary.arbitrary

object RandomStuffGenerators {

  // Using Gen.choose specifying range
  val myGen = for {
    n <- choose(1, 50)
    m <- choose(n, 2*n)
  } yield (n, m)

  // String with specific format
  val genString = for {
    c1 <- Gen.numChar
    c2 <- Gen.alphaUpperChar
    c3 <- Gen.alphaLowerChar
    c4 <- Gen.alphaChar
    c5 <- Gen.alphaNumChar
  } yield List(c1,c2,c3,c4,c5).mkString

  // Extrating a part of the generated values
  val stringsGen = for {
    alpha <- Gen.alphaStr
    num <- Gen.numStr
    id <- Gen.identifier
  } yield (alpha.take(4), num.take(4), id.take(4))

  // Even / Odd numbers
  val evenNumberGen = for {
    n <- choose(2,100000)
  } yield 2*n

  val oddNumberGen = for {
    n <- choose(0,100000)
  } yield 2*n + 1

  // Even / Odd / 0 - with a certain frequency
  val numberGen = frequency(
    (1, oddNumberGen),
    (2, evenNumberGen),
    (4, 0)
  )

  // Odd int
  val oddInt = arbitrary[Int] suchThat (_ % 2 != 0)
  val oddIntOptimized = arbitrary[Int] retryUntil (_ % 2 != 0)

  val listOfOddInt = listOf(oddInt)
  val listOfOddIntWithOptimized = listOf(oddIntOptimized)

  // Lists
  val genIntList = listOf(choose(0,10))

  val genNonEmptyList = nonEmptyListOf(oneOf("foo", "bar"))

  val genEightBytes = listOfN(8, arbitrary[Byte])


}
