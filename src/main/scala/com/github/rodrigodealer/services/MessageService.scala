package com.github.rodrigodealer.services

import com.github.rodrigodealer.models.Message

import scala.collection.mutable.ListBuffer

/**
 * Created by rodrigo on 7/5/15.
 */
class MessageService {

  var messages = ListBuffer[Message]()

  def post(message: Message) = {
    messages.append(message)
  }
}
