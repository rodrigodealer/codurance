package com.github.rodrigodealer.services

import com.github.rodrigodealer.models.{User, Message}
import org.joda.time.DateTime
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

  it should "show user wall" in {
    val johnny = userService.create(User("Johnny"))
    val alice = userService.create(User("Alice"))
    johnny.follow(alice)

    service.post(Message("I love winter", johnny, new DateTime(1978, 3, 26, 12, 35, 0, 0).toDate))
    service.post(Message("I love summer", alice, new DateTime(1978, 3, 26, 12, 38, 0, 0).toDate))

    val messages = service.messagesOrderedByDateFor(johnny)
    messages.head.content should be("I love summer")
    messages.head.user.name should be("Alice")
    messages.last.content should be("I love winter")
    messages.last.user.name should be("Johnny")
  }
}
