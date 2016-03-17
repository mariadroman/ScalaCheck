package com.lunatech.learning.scalacheck.properties

import com.lunatech.learning.scalacheck._
import com.lunatech.learning.scalacheck.model._
import org.scalacheck.Gen.Parameters
import org.scalacheck.Properties
import org.scalacheck.Prop._

class BankProperties extends Properties("Bank Properties") {
  import com.lunatech.learning.scalacheck.generators.BankGenerators

  property("createEUAccount for a non-EU user is not possible") = forAll(BankGenerators.genNonEUUser) { (user) =>
    Bank.createEUAccount(user).isEmpty
  }

  property("createEUAccount for an EU user can be possible") = forAll(BankGenerators.genEUUser) { (user) =>
    if (user.fraudRecord.isEmpty)
      Bank.createEUAccount(user).nonEmpty
    else
      Bank.createEUAccount(user).isEmpty
  }

  property("createAccount for any user is possible based on frauds") = forAll(BankGenerators.genAnyUser) { (user) =>
    if (user.fraudRecord.isEmpty)
      Bank.createAccount(user).nonEmpty
    else
      Bank.createAccount(user).isEmpty
  }

  property("for a new account, balance is positive or zero") = forAll (BankGenerators.genAccount) { (account) =>
    account.balance >= 0
  }

  property("for a new account, there is no user's fraud") = forAll (BankGenerators.genAccount) { (account) =>
    account.user.fraudRecord.isEmpty
  }
}
