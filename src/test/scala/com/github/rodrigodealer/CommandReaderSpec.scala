package com.github.rodrigodealer

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by rodrigo on 6/26/15.
 */
class CommandReaderSpec extends FlatSpec with Matchers {

  it should "identify as a post command" in {
    val command = CommandReader("Alice -> I love the weather today")
    command.operation shouldBe CommandType.Post
    command.user shouldBe "Alice"
    command.args shouldBe Some("I love the weather today")
  }

  it should "identify as a read command" in {
    val command = CommandReader("Alice")
    command.operation shouldBe CommandType.Read
    command.user shouldBe "Alice"
  }

  it should "identify as a follow command" in {
    val command = CommandReader("Charlie follows Alice")
    command.operation shouldBe CommandType.Follow
    command.user shouldBe "Charlie"
    command.otherUser shouldBe Some("Alice")
  }

  it should "identify as a wall command" in {
    val command = CommandReader("Charlie wall")
    command.operation shouldBe CommandType.Wall
    command.user shouldBe "Charlie"
    command.otherUser shouldBe None
  }
}
