package com.github.rodrigodealer

import java.util.Date

import com.github.rodrigodealer.CommandType._
import com.github.rodrigodealer.models.{User, Message}
import com.github.rodrigodealer.services.{MessageService, UserService}

import scala.io.StdIn

/**
 * Created by rodrigo on 7/1/15.
 */
object App {

  def main(args: Array[String]) {
    println("App is running..")
    for (ln <- io.Source.stdin.getLines()) readCommandLine(ln)
  }

  private val userService : UserService = new UserService
  private val messageService : MessageService = new MessageService(userService)

  def readCommandLine(commandLine: String) = {
    val command = CommandReader(commandLine)
    command.operation match {
      case Post => messageService.post(Message(command.args.get, User(command.user)))
      case Follow => userService.follow(User(command.user), User(command.otherUser.get))
      case Read => messageService.messagesFor(User(command.user)).foreach(m => println(m.format(new Date)))
      case Wall => messageService.messagesOrderedByDateFor(User(command.user)).foreach(m => println(m.wallFormat(new Date)))
    }
  }
}