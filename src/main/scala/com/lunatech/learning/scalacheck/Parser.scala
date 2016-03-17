package com.lunatech.learning.scalacheck

object Parser {

  def main(args: Array[String]): Unit = {
    println("Parser")
  }

  /*
  * Scenario: Receive as a parameter a String with the format
  * <start>,<stop>,<step>
  * Required to convert it to a sequence of ints from start to
  * stop using step interval
  * E.g.:
  *   "1,10,2" => Seq(1, 3, 5, 7, 9)
  * */
  def parseStringToSeq(input: String): Seq[Int] = {
    val array = input.trim.split(",").map(_.toInt)
    array(0).to(array(1)).by(array(2))
  }
}
