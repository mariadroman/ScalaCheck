package com.lunatech.learning.scalacheck

import model._

object Bank {

  def main(args: Array[String]): Unit = {
    println("Bank API")
  }

  def createAccount(user: User): Option[Account] = {
    if (user.fraudRecord.isEmpty)
      Some(Account(user, 0.0))
    else
      None
  }

  def createEUAccount(user: User): Option[Account] = {
    if (user.euCitizen)
      createAccount(user)
    else
      None
  }

}
