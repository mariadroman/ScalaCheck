package com.lunatech.learning.scalacheck.model

case class Fraud(description: String)
case class User(id: Int, euCitizen: Boolean, fraudRecord: List[Fraud])
case class Account(user: User, balance: Double)
