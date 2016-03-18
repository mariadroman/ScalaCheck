package com.lunatech.learning.scalacheck.properties

import org.scalacheck.{Gen, Properties}
import org.scalacheck.Gen._
import org.scalacheck.Prop._

class RandomStuffProperties extends Properties("Random Stuff Properties"){

  import com.lunatech.learning.scalacheck.generators.RandomStuffGenerators

  // Choosing
  val g = choose(-2, 5)

  val h = choose(4.1, 4.2)

  val p = forAll(h) { n => n >= 4.1 && n <= 4.2 }

  // Show statistics
  p.check

  // Absolute value
  val propAbs = forAll(negNum[Int]) { n =>
    math.abs(n) == -n
  }

  // Even / Odd / 0
  val propNumberGen = forAll(RandomStuffGenerators.numberGen) { n =>
    val l = {
      if (n == 0) "zero"
      else if (n % 2 == 0) "even"
      else "odd"
    }
    collect(l)(true)
  }

  // Odd Ints - regular / improved
  val pOddInt = forAll(RandomStuffGenerators.listOfOddInt)(_.forall(_ % 2 != 0))
  val pOddIntOptimized = forAll(RandomStuffGenerators.listOfOddIntWithOptimized)(_.forall(_ % 2 != 0))

  // Lists
  val propIntsWithinBounds = forAll(RandomStuffGenerators.genIntList) { xs =>
    xs.forall { n:Int =>
      n >= 0 && n <= 10
    }
  }

  val propCorrectStrings = forAll(RandomStuffGenerators.genNonEmptyList) { xs =>
    (xs.size > 0) && xs.forall { s:String =>
      s == "foo" || s == "bar"
    }
  }

  val propListLength = forAll(RandomStuffGenerators.genEightBytes) { xs =>
    xs.size == 8
  }

  // More props
  val propStringLength = forAll { s: String =>
    val len = s.length
    (s+s).length == len+len
  }

  val propDivByZero =
    throws(classOf[ArithmeticException]) { 1/0 }

  val propListIdxOutOfBounds = forAll { xs: List[Int] =>
    throws(classOf[IndexOutOfBoundsException]) {
      xs(xs.length+1)
    }
  }

  property("list tail") =
    forAll { (x: Int, xs: List[Int]) =>
      (x::xs).tail == xs
    }

  property("list head") = forAll { xs: List[Int] =>
    if (xs.isEmpty)
      throws(classOf[NoSuchElementException]) { xs.head }
    else
      xs.head == xs(0)
  }


}
