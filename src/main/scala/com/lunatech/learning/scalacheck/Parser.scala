package com.lunatech.learning.scalacheck

import scala.util.{Success, Try}

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
    val arg = Try(input.split(",").map(_.trim.toInt).toSeq)
    arg match {
      case Success(start +: stop +: step +: Nil) =>
        require(start < stop, "The start should be smaller than the stop.")
        require(step > 0, "The step should be a positive number.")
        require(((stop.toLong - start.toLong) / step.toLong) + 1L <= Int.MaxValue.toLong)
        (start to stop) by step
      case Success(value +: Nil) => Seq(value)
      case _ => throw new IllegalArgumentException(
        """
          |The input should contain either an Integer or a comma separated list of 3 integers.
        """.stripMargin)
    }
  }

}
