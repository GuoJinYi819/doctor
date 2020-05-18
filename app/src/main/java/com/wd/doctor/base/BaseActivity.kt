package com.wd.doctor.base

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 14:02
 * @Description: 用途：baseActivity基类
 */
abstract class BaseActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initLayoutId())
        initLintener()
        initData()
    }

    //初始化布局
    abstract fun initLayoutId():Int
    //初始化监听
    abstract fun initLintener()
    //初始化数据
    abstract fun initData()

    //自定义吐司
    protected fun myToast(msg:String){
        toast(msg)
    }

    //跳转activity
    inline fun <reified A: Activity>startActivityFinish(){
        startActivity<A>()
        //销毁当前界面
        finish()
    }

}