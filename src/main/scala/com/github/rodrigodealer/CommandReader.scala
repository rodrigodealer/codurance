package com.github.rodrigodealer

import com.github.rodrigodealer.CommandType.CommandType
import com.github.rodrigodealer.CommandType.Post
import com.github.rodrigodealer.CommandType.Follow
import com.github.rodrigodealer.CommandType.Wall
import com.github.rodrigodealer.CommandType.Read

/**
 * Created by rodrigo on 6/27/15.
 */
object CommandReader {
  val PostCommand = "->"
  val FollowCommand = "follows"
  val WallCommand = "wall"

  def apply(command: String) = command match {
    case op if op.isPost => Command(Post, user(op, Post), Option.empty, otherUser(command, Post))
    case op if op.isFollow => Command(Follow, user(op, Follow), otherUser(command, Follow), Option.empty)
    case op if op.isWall => Command(Wall, user(op, Wall), Option.empty, Option.empty)
    case op => Command(Read, op.trim, Option.empty, Option.empty)
  }

  private[this] def otherUser(command: String, operation: CommandType) : Option[String] = operation match {
    case Post => Option(command.split(PostCommand).last.trim)
    case Follow => Option(command.split(FollowCommand).last.trim)
    case _ => Option.empty
  }

  private[this] def user(command: String, operation: CommandType) = operation match {
    case Post => command.split(PostCommand).head.trim
    case Follow => command.split(FollowCommand).head.trim
    case Wall => command.split(WallCommand).head.trim
  }

  private[this] implicit class StringCommands(s: String) {
    def isPost = s.contains(PostCommand)
    def isFollow = s.contains(FollowCommand)
    def isWall = s.contains(WallCommand)
  }
}

case class Command(operation: CommandType, user: String, otherUser: Option[String], args: Option[String])

object CommandType extends Enumeration {
  type CommandType = Value
  val Post, Read, Follow, Wall = Value
}