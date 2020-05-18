package com.wd.doctor.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initLintener() {

    }

    override fun initData() {
        myToast("测试项目")

    }

}
