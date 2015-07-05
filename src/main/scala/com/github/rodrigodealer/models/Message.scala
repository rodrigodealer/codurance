package com.github.rodrigodealer.models

import java.util.Date

import com.github.rodrigodealer.utils.DateUtil

/**
 * Created by rodrigo on 7/5/15.
 */
case class Message(content: String, user: User, date: Date = new Date) {
  def postDate(endDate: Date) = DateUtil.elapsedTimeFrom(date, endDate)

  def format(endDate: Date) = s"$content (${postDate(endDate)})"

  def wallFormat(endDate: Date) = s"${user.name} - $content (${postDate(endDate)})"
}