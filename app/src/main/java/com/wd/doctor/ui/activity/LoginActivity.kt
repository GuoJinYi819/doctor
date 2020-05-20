package com.wd.doctor.ui.activity

import android.content.Intent
import android.graphics.Color
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.hintTextColor

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
        //登入
        btnLogin.setOnClickListener {

        }

        //小眼睛
        iv_hide.setOnLongClickListener(object :View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                iv_hide.setBackgroundResource(R.mipmap.login_icon_show_password)
                editPwd?.transformationMethod = HideReturnsTransformationMethod.getInstance();
                return false
            }

        })

        iv_hide.setOnClickListener {
            iv_hide.setBackgroundResource(R.mipmap.login_icon_hide_password_n)
            editPwd?.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }


    }

    override fun initData() {
        val emil = editEmil.text.toString()
        val pwd = editPwd.text.toString()
        //判空
        if (stringNotNull(emil)) {
            editEmil.hint = "账号暂未输入"
            editEmil.hintTextColor = Color.RED
        }else if(stringNotNull(pwd)){
            editPwd.hint = "密码暂未输入"
            editPwd.hintTextColor = Color.RED
        }else{
            //请求数据

        }

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
    private fun stringNotNull(str:String):Boolean{
        return TextUtils.isEmpty(str)
    }
}