package com.github.rodrigodealer.services

import com.github.rodrigodealer.models.{User, Message}
import org.scalatest.{BeforeAndAfterEach, Matchers, FlatSpec}

/**
 * Created by rodrigo on 7/5/15.
 */
class MessageServiceSpec extends FlatSpec with Matchers with BeforeAndAfterEach {

  var service: MessageService = _

  override def beforeEach() {
    service = new MessageService
  }

  it should "have size 0 in messages list" in {
    service.messages should have size 0
  }

  it should "create a message and append to list" in {
    service.post(Message("I love winter", User("Johnny")))

    service.messages should have size 1
  }

}
