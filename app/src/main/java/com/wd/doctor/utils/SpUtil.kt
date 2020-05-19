package com.wd.doctor.utils

import android.content.Context
import com.wd.doctor.App

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/19 0019 14:48
 * @Description: 用途：完成特定功能
 */
class SpUtil {
    val sharedPrefanaces by lazy { App.context!!.getSharedPreferences("user",Context.MODE_PRIVATE) }
    val edit by lazy { sharedPrefanaces!!.edit() }

    private constructor()

    companion object{
        private var instance:SpUtil? = null
        get() {
            if(field == null){
                field = SpUtil()
            }
            return field
        }
        fun getSpUtil():SpUtil{
            return instance!!
        }
    }

    //存储
    fun putString(key:String,value:String){
        edit.putString(key,value)
        edit.commit()
    }
    fun putInt(key:String,value:Int){
        edit.putInt(key,value)
        edit.commit()
    }

    //取出
    fun getString(key:String): String? {
        val str = sharedPrefanaces.getString(key, null)
        return str
    }
    fun getInt(key:String): Int? {
        val int = sharedPrefanaces.getInt(key, -1)
        return int
    }
}