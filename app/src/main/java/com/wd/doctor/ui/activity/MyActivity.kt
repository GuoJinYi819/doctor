package com.wd.doctor.ui.activity

import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_my.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 17:21
 * @Description: 用途：完成特定功能
 */
class MyActivity:BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_my
    }

    override fun initLintener() {
        ivBack.setOnClickListener {
            finish()
        }
    }

    override fun initData() {
    }
}