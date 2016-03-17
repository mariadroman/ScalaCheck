package com.lunatech.learning.scalacheck

import com.lunatech.learning.scalacheck.model._
import org.scalatest.{Matchers, FunSuite}

class BankSpec extends FunSuite with Matchers {

  test("createEUAccount for a non-EU user is not possible") {
    val fraud = Fraud("CyberFraud")

    val user1 = User(1,false,List(fraud))
    val user2 = User(1,false,List.empty)
    val user3 = User(1,false,List(fraud,fraud))

    assert(Bank.createEUAccount(user1).isEmpty)
    assert(Bank.createEUAccount(user2).isEmpty)
    assert(Bank.createEUAccount(user3).isEmpty)
  }
}
