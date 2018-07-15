import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

//import _root_.utils.TimestampUtil._

//import _root_.utils.TimestampUtil._

import scala.annotation.tailrec

object TimestampUtil {
  final val MILLS: Long = 1000
  final val MIN: Long = MILLS(60)
  final val HOUR: Long = MILLS(3600)
  final val DAY: Long = HOUR(24)

  implicit class int2multi(int: Long) {
    def apply(factor: Long) = int * factor
  }

  implicit class long2timestamp(timestamp: Long) {

    def tsFuzzByHourIn: Long = timestamp / HOUR * HOUR + HOUR

    def tsFuzzByHourOut: Long = timestamp / HOUR * HOUR

    def tsFuzzByDay: Long = timestamp / DAY * DAY

    def tsDaysBefore(days: Int): Long = timestamp - DAY * days

    def tsDaysAfter(days: Int): Long = timestamp + DAY * days

    def tsHoursBefore(hours: Int): Long = timestamp - hours * HOUR

    def tsMinBefore(min: Int): Long = timestamp - min * MIN

    def tsSecondBefore(second: Int): Long = timestamp - second * MILLS

    def tsMillsBefore(mills: Int): Long = timestamp - mills

    def tsMinAfter(min: Int): Long = timestamp + min * MIN

    def toDate = new Date(timestamp)

    def daybreak: Long = {
      val calendar = Calendar.getInstance()
      calendar.setTime(new Date(timestamp))
      calendar.set(Calendar.HOUR_OF_DAY, 0)
      calendar.set(Calendar.MINUTE, 0)
      calendar.set(Calendar.SECOND, 0)
      calendar.set(Calendar.MILLISECOND, 0)
      calendar.getTimeInMillis
    }

    def endOfTheDay: Long = {
      val calendar = Calendar.getInstance()
      calendar.setTimeInMillis(timestamp)
      calendar.set(Calendar.HOUR_OF_DAY, 23)
      calendar.set(Calendar.MINUTE, 59)
      calendar.set(Calendar.SECOND, 59)
      calendar.set(Calendar.MILLISECOND, 999)
      calendar.getTimeInMillis
    }

    def yyyy_MM_dd: String = {
      val sdf = new SimpleDateFormat("yyyy-MM-dd")
      sdf.format(new Date(timestamp))
    }

    def yyyyMMdd: String = {
      val sdf = new SimpleDateFormat("yyyyMMdd")
      sdf.format(new Date(timestamp))
    }

    def hourOfDay: Int = {
      val calendar = Calendar.getInstance()
      calendar.setTimeInMillis(timestamp)
      calendar.get(Calendar.HOUR_OF_DAY)
    }

    def minOfDay: Int = {
      val calendar = Calendar.getInstance()
      calendar.setTimeInMillis(timestamp)
      calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE)
    }

    def millisOfDay: Int = {
      val calendar = Calendar.getInstance()
      calendar.setTimeInMillis(timestamp)
      calendar.get(Calendar.HOUR_OF_DAY) * 3600000 + calendar.get(Calendar.MINUTE) * 60000 + calendar.get(Calendar.SECOND) * 1000 + calendar.get(Calendar.MILLISECOND)
    }

    def dayOfWeek: Int = {
      val calendar = Calendar.getInstance()
      calendar.setTimeInMillis(timestamp)
      calendar.get(Calendar.DAY_OF_WEEK) - 1
    }

    def toDateOfYuanDan: Date = {
      val calendar = Calendar.getInstance()
      calendar.setTime(new Date(timestamp))
      val year = calendar.get(Calendar.YEAR)
      new Date(year, 1, 1)
    }

    def toDateAfterYears(num: Int): Date = {
      val calendar = Calendar.getInstance()
      calendar.setTime(new Date(timestamp))
      val year = calendar.get(Calendar.YEAR)
      new Date(year + num, 1, 1)
    }
  }

  def now = System.currentTimeMillis()

  def nowDate = new Date()

  def workDaysBetweenBeginAndEnd(begin: Long, end: Long, format: String = "yyyy-MM-dd", workDays: List[Int]): List[String] = {
    val sdf = new SimpleDateFormat()
    @tailrec
    def loopWorkDays(calendar: Calendar): Long = {
      if (workDays.contains(calendar.get(Calendar.DAY_OF_WEEK) - 1)) {
        calendar.getTimeInMillis
      } else {
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        loopWorkDays(calendar)
      }
    }
    @tailrec
    def loop(now: Long, list: List[String]): List[String] = {
      if (now <= end.endOfTheDay) {
        val calendar = Calendar.getInstance()
        calendar.setTimeInMillis(now)
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        val timeInMillis = loopWorkDays(calendar)
        loop(timeInMillis, list :+ sdf.format(timeInMillis))
      } else {
        list
      }
    }
    loop(begin, List())
  }

  def minuteBetween(begin: Long, end: Long): Int = {
    val calendarBegin = Calendar.getInstance()
    calendarBegin.setTimeInMillis(begin)
    val calendarEnd = Calendar.getInstance()
    calendarEnd.setTimeInMillis(end)
    val hour = calendarEnd.get(Calendar.HOUR_OF_DAY) - calendarBegin.get(Calendar.HOUR_OF_DAY)
    val min = calendarEnd.get(Calendar.MINUTE) - calendarBegin.get(Calendar.MINUTE)
    hour * 60 + min
  }
}
/**
  * Created by gaoxd on 2018/6/1.
  */
object testTime {

  def main(args: Array[String]) {
    import TimestampUtil._
    val ddd= TimestampUtil.now
    //延时的毫秒数 晚上23:59点执行
    println(ddd.endOfTheDay - now - 60000)
    println(now.endOfTheDay - now - 60000*1*60*8 - 2523698)
    println(now.endOfTheDay - now - 60000*1*60*16)

    if((now.endOfTheDay - now - 60000*1*60*16)<0){
      now.endOfTheDay - now + 60000*1*60*8
    }

    println(s"ddd.dayOfWeek=${ddd.dayOfWeek}")
    val dddd = TimestampUtil.MILLS
    println(TimestampUtil.MILLS)
    println(TimestampUtil.MIN)
    println(TimestampUtil.HOUR)
    println(TimestampUtil.DAY)

    println(now)
    println(now.toDate)
    println(nowDate)

    println("time="+1531259234000L.toDate)
    println(1528680655806L.toDate)
    println(1528713055806L.toDate)

    println("-------")
    println(1528980553468L.toDate)
    println(1528980553468L.millisOfDay)
    println(1528980553468L.dayOfWeek)
    println(1528980553468L.hourOfDay)
    println(1528980553468L.minOfDay)
    println("-------")

    println(System.getProperty("user.dir"))
  }
}
