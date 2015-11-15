package frdomain.ch8
package cqrs
package memrepo

import scalaz._
import Scalaz._

import java.util.{ Date, Calendar }

object common {
  type Amount = BigDecimal
  type Error = String

  val today = Calendar.getInstance.getTime
}

import common._

case class Balance(amount: Amount = 0)

case class Account(no: String, name: String, dateOfOpening: Date = today, dateOfClosing: Option[Date] = None, 
  balance: Balance = Balance(0)) {
  def isClosed = dateOfClosing.isDefined
}

object Account {
  implicit val showAccount: Show[Account] = Show.shows { case a: Account => a.toString }
}


