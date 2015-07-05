package com.github.rodrigodealer.models

import org.joda.time.DateTime
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by rodrigo on 7/5/15.
 */
class MessageSpec extends FlatSpec with Matchers {

  it should "format message to a readable format" in {
    val endDate = new DateTime(2015, 5, 26, 12, 35, 0, 0).toDate
    val message = Message("I love summer", User("Johnny"), new DateTime(1980, 3, 26, 12, 35, 0, 0).toDate)

    message.format(endDate) shouldBe "I love summer (35 years ago)"
  }

  it should "format wall message to a readable format" in {
    val endDate = new DateTime(2015, 5, 26, 12, 35, 0, 0).toDate
    val message = Message("I love summer", User("Johnny"), new DateTime(1980, 3, 26, 12, 35, 0, 0).toDate)

    message.wallFormat(endDate) shouldBe "Johnny - I love summer (35 years ago)"
  }
}