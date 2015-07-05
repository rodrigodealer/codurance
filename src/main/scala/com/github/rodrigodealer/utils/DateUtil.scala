package com.github.rodrigodealer.utils

import java.util.Date

import org.joda.time.format.PeriodFormatterBuilder
import org.joda.time.{DateTime, Period}

/**
 * Created by rodrigo on 7/5/15.
 */
object DateUtil {

  private val formatter = new PeriodFormatterBuilder()
    .appendSeconds().appendSuffix(" seconds ago")
    .appendMinutes().appendSuffix(" minutes ago")
    .appendHours().appendSuffix(" hours ago")
    .appendDays().appendSuffix(" days ago")
    .appendWeeks().appendSuffix(" weeks ago")
    .appendMonths().appendSuffix(" months ago")
    .appendYears().appendSuffix(" years ago")
    .printZeroNever()
    .toFormatter

  def elapsedTimeFrom(startDate: Date, endDate: Date) = {
    val period = new Period(new DateTime(startDate), new DateTime(endDate))
    formatter.print(period)
  }
}