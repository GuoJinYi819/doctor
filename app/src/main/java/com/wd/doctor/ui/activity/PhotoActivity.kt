package com.wd.doctor.ui.activity

import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_photo.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 7:42
 * @Description: 用途：证件照
 */
class PhotoActivity:BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_photo
    }

    override fun initLintener() {
        tvBack.setOnClickListener {
            startActivityFinish<HomePagerActivity>()
        }
    }

    override fun initData() {
    }
}