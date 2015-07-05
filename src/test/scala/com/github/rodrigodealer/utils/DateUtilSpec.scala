package com.github.rodrigodealer.utils

import org.joda.time.DateTime
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by rodrigo on 7/5/15.
 */
class DateUtilSpec extends FlatSpec with Matchers {

  it should "show elapsed time for a specific date" in {
    val startDate = new DateTime(1978, 3, 26, 12, 35, 0, 0).toDate
    val endDate = new DateTime(1978, 3, 26, 12, 38, 0, 0).toDate

    val elapsedTime = DateUtil.elapsedTimeFrom(startDate, endDate)

    elapsedTime shouldBe "3 minutes ago"
  }

}
