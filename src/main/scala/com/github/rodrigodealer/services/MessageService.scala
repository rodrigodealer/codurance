package com.github.rodrigodealer.services

import com.github.rodrigodealer.models.{User, Message}

import scala.collection.mutable.ListBuffer

/**
 * Created by rodrigo on 7/5/15.
 */
class MessageService(userService: UserService) {

  var messages = ListBuffer[Message]()

  def post(message: Message) = {
    userService.find(message.user) match {
      case Some(user) => messages.append(message)
      case None =>
        userService.create(message.user)
        messages.append(message)
    }
  }

  def messagesFor(user: User) = {
    messages.filter(m => m.user.equals(user)).toList.reverse
  }
}
