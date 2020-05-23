package com.wd.doctor.customview

import android.view.View

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/23 0023 8:20
 * @Description: 用途：完成特定功能
 */
abstract class MyClickListener:View.OnClickListener {
    private var time:Long = 0
    override fun onClick(v: View?) {
        //获取当前时间
        val timeMillis = System.currentTimeMillis()
        if(timeMillis-time>700){
            onMyClick()
        }else{
            println("防误触--触发")
        }
        time = System.currentTimeMillis()
    }

    open abstract fun onMyClick()
}