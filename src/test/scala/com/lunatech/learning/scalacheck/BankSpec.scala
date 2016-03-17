package com.lunatech.learning.scalacheck

import com.lunatech.learning.scalacheck.model._
import org.scalatest.{Matchers, FunSuite}

//class BankSpec extends FunSuite with Matchers {
//
//  test("createEUAccount for a non-EU user is not possible") {
//    val fraud = Fraud("CyberFraud")
//    val emptyFraud = Fraud("")
//
//    val user1 = User(1,false,List(fraud))
//    val user2 = User(1,false,List.empty)
//    val user3 = User(1,false,List(fraud,fraud))
//    val user4 = User(1,false,List(emptyFraud)) //Fraud description should not be empty!!
//
//    assert(Bank.createEUAccount(user1).isEmpty)
//    assert(Bank.createEUAccount(user2).isEmpty)
//    assert(Bank.createEUAccount(user3).isEmpty)
//    assert(Bank.createEUAccount(user4).isEmpty)
//  }
//
//  test("createEUAccount for an EU user can be possible") {
//    val fraud = Fraud("CyberFraud")
//    val emptyFraud = Fraud("")
//
//    val user1 = User(1,true,List(fraud))
//    val user2 = User(1,true,List.empty)
//    val user3 = User(1,true,List(fraud,fraud))
//    val user4 = User(1,true,List(emptyFraud)) //Fraud description should not be empty!!
//
//    assert(Bank.createEUAccount(user1).isEmpty)
//    assert(Bank.createEUAccount(user2).nonEmpty)
//    assert(Bank.createEUAccount(user3).isEmpty)
//    assert(Bank.createEUAccount(user4).isEmpty)
//  }
//}
