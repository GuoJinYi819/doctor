package com.wd.doctor.ui.activity

import android.content.Intent
import android.view.View
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 14:36
 * @Description: 用途：完成特定功能
 */
class LoginActivity:BaseActivity(), View.OnClickListener {

    override fun initLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initLintener() {
        //申请入驻
        tvSettle.setOnClickListener(this)
    }

    override fun initData() {

    }

    //监听
    override fun onClick(v: View?) {
        when(v!!.id){
            //申请入驻
            R.id.tvSettle->{
                startActivity(Intent(this,SettleActivity::class.java))
            }

        }
    }
}