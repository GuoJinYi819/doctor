package com.wd.doctor.ui.activity

import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_settle_orver.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/19 0019 16:11
 * @Description: 用途：完成特定功能
 */
class SettleOrverActivity:BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_settle_orver
    }

    override fun initLintener() {
        linearbg.setOnClickListener {
            startActivityFinish<LoginActivity>()
        }
    }

    override fun initData() {
    }
}