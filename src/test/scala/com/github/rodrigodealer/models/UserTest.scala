package com.github.rodrigodealer.models

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by rodrigo on 7/5/15.
 */
class UserTest extends FlatSpec with Matchers {

  it should "follow one user" in {
    val user = new User("Jack")
    val otherUser = new User("Frank")

    user.follow(otherUser)
    user.follows should have size 1
  }

  it should "follow two users" in {
    val user = new User("Jack")
    val otherUser = new User("Frank")
    val anotherUser = new User("Nancy")

    user.follow(otherUser)
    user.follow(anotherUser)
    user.follows should have size 2
  }
}
