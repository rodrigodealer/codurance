package com.github.rodrigodealer.utils

import java.util.Date

import org.joda.time.format.PeriodFormatterBuilder
import org.joda.time.{DateTime, Period}

/**
 * Created by rodrigo on 7/5/15.
 */
object DateUtil {

  private val formatter = new PeriodFormatterBuilder()
    .appendSeconds().appendSuffix(" seconds ago\n")
    .appendMinutes().appendSuffix(" minutes ago\n")
    .appendHours().appendSuffix(" hours ago\n")
    .appendDays().appendSuffix(" days ago\n")
    .appendWeeks().appendSuffix(" weeks ago\n")
    .appendMonths().appendSuffix(" months ago\n")
    .appendYears().appendSuffix(" years ago\n")
    .printZeroNever()
    .toFormatter

  def elapsedTimeFrom(startDate: Date, endDate: Date) = {
    val period = new Period(new DateTime(startDate), new DateTime(endDate))
    formatter.print(period).split("\n").last
  }
}