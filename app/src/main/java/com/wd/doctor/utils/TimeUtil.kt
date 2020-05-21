package com.wd.doctor.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 20:01
 * @Description: 用途：完成特定功能
 */
object TimeUtil {
    fun time(time:String):String{
        var text:String? =null
      var simp = SimpleDateFormat("yyyy-MM-dd")
        val date = Date(time.toLong())
        text = simp.format(date)
        return text
    }
}