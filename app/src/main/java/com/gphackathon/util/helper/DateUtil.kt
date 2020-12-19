package com.gphackathon.util.helper


import com.gphackathon.data.Const
import java.text.SimpleDateFormat
import java.util.*


/*
 * Created by :
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

object DateUtil {

    fun addMinutes(date: Date, i: Int): Date {
        val cal: Calendar = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.MINUTE, i)
        return cal.time
    }

    fun addDay(date: Date = Date(), i: Int): Date {
        val cal: Calendar = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.DAY_OF_YEAR, i)
        return cal.time
    }

    fun addMonth(date: Date = Date(), i: Int): Date {
        val cal: Calendar = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.MONTH, i)
        return cal.time
    }

    fun addYear(date: Date = Date(), i: Int): Date {
        val cal: Calendar = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.YEAR, i)
        return cal.time
    }

    fun todayAsFormat(format: String): String {
        return SimpleDateFormat(format, Locale.getDefault()).format(Date())
    }

    fun convertDateFormats(dateString: String, fromFormat: String, toFormat: String): String {
        val simpleDateFormat = SimpleDateFormat(fromFormat, Locale.getDefault())
        val simpleDateFormat2 = SimpleDateFormat(toFormat, Locale.getDefault())
        return try {
            val date = simpleDateFormat.parse(dateString)
            simpleDateFormat2.format(date!!)
        } catch (e: Exception) {
            dateString
        }
    }

    fun stringToDateTime(dateTimeString: String, format: String): Date {
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        return simpleDateFormat.parse(dateTimeString)!!
    }

    fun Date.getHour(): Int {
        val c = Calendar.getInstance()
        c.time = this
        return c.get(Calendar.HOUR_OF_DAY)
    }

    fun Date.getMinute(): Int {
        val c = Calendar.getInstance()
        c.time = this
        return c.get(Calendar.MINUTE)
    }

    fun dateToDateTimeString(time: Date, format: String): String {
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        return simpleDateFormat.format(time)
    }

    fun getFormattedTimeOnly(hr: Int, min: Int, is24Hr: Boolean = false): String {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hr)
        calendar.set(Calendar.MINUTE, min)
        val pattern = if (is24Hr) "HH:mm" else "hh:mm a"
        val formatter = SimpleDateFormat(pattern, Locale.getDefault())
        return formatter.format(calendar.time).toUpperCase(Locale.getDefault())
    }

}