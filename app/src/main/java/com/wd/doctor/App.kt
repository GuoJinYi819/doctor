package com.wd.doctor

import android.app.Application
import android.content.Context
import cn.jpush.im.android.api.JMessageClient

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/19 0019 14:51
 * @Description: 用途：完成特定功能
 */
class App:Application() {

    companion object{
        var context:Context? = null

    }

    override fun onCreate() {
        super.onCreate()
        context = this
        JMessageClient.setDebugMode(true)
        JMessageClient.init(this)
    }
}