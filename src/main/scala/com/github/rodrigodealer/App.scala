package com.github.rodrigodealer

import com.github.rodrigodealer.CommandType._

import scala.io.StdIn

/**
 * Created by rodrigo on 7/1/15.
 */
object App {
  def main(args: Array[String]) {
    for (ln <- io.Source.stdin.getLines()) readCommandLine(ln)
  }

  def readCommandLine(commandLine: String) = {
    val command = CommandReader(commandLine)
    command.operation match {
      case Post => println(command.operation)
      case Follow => println(command.operation)
      case Read => println(command.operation)
      case Wall => println(command.operation)
    }
  }
}