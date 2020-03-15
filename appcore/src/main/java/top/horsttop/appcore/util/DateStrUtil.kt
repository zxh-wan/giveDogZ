package top.horsttop.appcore.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by horsttop on 18.October.2018
 */
object DateStrUtil{

    fun ofFullTime(date: Long?): String {
        if(date == null)
            return "暂无"

        val sdf = SimpleDateFormat("yyyy" + "-" + "MM" + "-" + "dd" + "  " + "HH" + ":" + "mm")
        val dt = Date(date)
        return sdf.format(dt)
    }

    fun ofDayTime(date: Long?): String {

        if(date == null)
            return "暂无"

        val sdf = SimpleDateFormat("yyyy" + "-" + "MM" + "-" + "dd")
        val dt = Date(date)
        return sdf.format(dt)
    }


}