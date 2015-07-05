package com.github.rodrigodealer.services

import com.github.rodrigodealer.models.User
import org.scalatest.{BeforeAndAfterEach, Matchers, FlatSpec}

/**
 * Created by rodrigo on 7/5/15.
 */
class UserServiceSpec extends FlatSpec with Matchers with BeforeAndAfterEach {

  var service: UserService = _

  override def beforeEach() {
    service = new UserService
  }

  it should "have size 0 users in users list" in {
    service.users should have size 0
  }

  it should "create user and add to users list" in {
    service.create(User("Johnny"))

    service.users should have size 1
  }

  it should "create user and try to create again only add once" in {
    service.create(User("Johnny"))
    service.create(User("Johnny"))

    service.users should have size 1
  }

  it should "follow another user" in {
    val johnny = service.create(User("Johnny"))
    val alice =  service.create(User("Alice"))

    service.follow(johnny, alice)

    johnny.follows should have size 1
    johnny.follows.head shouldBe alice
  }

  it should "follow another user twice and only add once" in {
    val johnny = service.create(User("Johnny"))
    val alice =  service.create(User("Alice"))

    service.follow(johnny, alice)
    service.follow(johnny, alice)

    johnny.follows should have size 1
    johnny.follows.head shouldBe alice
  }

  it should "find a known user" in {
    val johnny = service.create(User("Johnny"))

    val foundUser = service.find(User("Johnny"))

    foundUser should be (Some(User("Johnny")))
  }

  it should "not find a unknown user" in {

    val foundUser = service.find(User("Johnny"))

    foundUser should be (None)
  }
}
