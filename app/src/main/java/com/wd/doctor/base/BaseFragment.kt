package com.wd.doctor.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 14:12
 * @Description: 用途：完成特定功能
 */
abstract class BaseFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }

    abstract fun initView(): View?

    abstract fun initListener()

    abstract fun initData()

    protected fun myToast(msg:String){
        context?.toast(msg)
    }

    inline fun <reified A:Activity>startActivityFiash(){
        context?.startActivity<A>()
    }

}