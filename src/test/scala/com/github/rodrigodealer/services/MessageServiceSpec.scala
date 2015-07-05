package com.github.rodrigodealer.services

import com.github.rodrigodealer.models.{User, Message}
import org.scalatest.{BeforeAndAfterEach, Matchers, FlatSpec}

/**
 * Created by rodrigo on 7/5/15.
 */
class MessageServiceSpec extends FlatSpec with Matchers with BeforeAndAfterEach {

  var service: MessageService = _
  var userService: UserService = _

  override def beforeEach() {
    userService = new UserService
    service = new MessageService(userService)
  }

  it should "have size 0 in messages list" in {
    service.messages should have size 0
  }

  it should "create a message and append to list" in {
    val johnny = userService.create(User("Johnny"))

    service.post(Message("I love winter", johnny))

    service.messages should have size 1
    userService.users should have size 1
  }

  it should "try to post a message with unknown user and create the user and post his message" in {
    service.post(Message("I love winter", User("Johnny")))

    service.messages should have size 1
    userService.users should have size 1
  }

  it should "show user messages" in {
    val johnny = userService.create(User("Johnny"))
    service.post(Message("I love winter", johnny))
    service.post(Message("I want to travel next year", johnny))

    val messages = service.messagesFor(johnny)
    messages should have size 2
    messages.head.content should be("I want to travel next year")
    messages.last.content should be("I love winter")
  }
}
