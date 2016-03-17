package com.lunatech.learning.scalacheck.generators

import com.lunatech.learning.scalacheck.model._
import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen

//object BankGenerators {
//
//  val genFraud = for {
//    desc <- arbitrary[String].suchThat(_.nonEmpty) //description not empty
//  } yield Fraud(desc)
//
//  val genAnyUser = for {
//    id <- arbitrary[Int]
//    eu <- arbitrary[Boolean]
//    fraud <- Gen.listOf(genFraud)
//  } yield User(id, eu, fraud)
//
//  val genEUUser = for {
//    id <- arbitrary[Int]
//    eu <- Gen.const(true)
//    fraud <- Gen.listOf(genFraud)
//  } yield User(id, eu, fraud)
//
//  val genNonEUUser = for {
//    id <- arbitrary[Int]
//    eu <- Gen.const(false)
//    fraud <- Gen.listOf(genFraud)
//  } yield User(id, eu, fraud)
//
//  val genAccount = for {
//    user <- genEUUser.suchThat(_.fraudRecord.isEmpty) //Be careful with restrictions
//    balance <- Gen.choose(0.0,1000.0)
//  } yield Account(user, balance)
//
//}
