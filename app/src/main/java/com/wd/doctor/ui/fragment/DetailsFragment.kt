package com.wd.doctor.ui.fragment

import android.view.View
import android.widget.TextView
import com.wd.doctor.R
import com.wd.doctor.base.BaseFragment

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 17:54
 * @Description: 用途：完成特定功能
 */
class DetailsFragment:BaseFragment() {
    override fun initView(): View? {
        val view = View.inflate(context, R.layout.fragment_details, null)
        return view
    }

    override fun initListener() {
    }

    override fun initData() {
    }
}