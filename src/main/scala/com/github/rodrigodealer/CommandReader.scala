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
  def apply(command: String) = {
    command match {
      case op if op.contains("->") => Command(Post, op.split("->").head.trim, Option.empty, Option(op.split("->").last.trim))
      case op if op.contains("follows") => Command(Follow, op.split("follows").head.trim, Option(op.split("follows").last.trim), Option.empty)
      case op if op.contains("wall") => Command(Wall, op.split("wall").head.trim, Option.empty, Option.empty)
      case op => Command(Read, op.trim, Option.empty, Option.empty)
    }
  }
}

case class Command(operation: CommandType, user: String, otherUser: Option[String], args: Option[String])

object CommandType extends Enumeration {
  type CommandType = Value
  val Post, Read, Follow, Wall = Value
}