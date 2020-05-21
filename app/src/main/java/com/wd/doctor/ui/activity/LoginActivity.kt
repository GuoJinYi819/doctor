package com.wd.doctor.ui.activity

import android.content.Intent
import android.graphics.Color
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.LoginBean
import com.wd.doctor.mvp.login.ILoginContract
import com.wd.doctor.mvp.login.LoginPresenter
import com.wd.doctor.utils.RsaCoder
import com.wd.doctor.utils.SpKey
import com.wd.doctor.utils.SpUtil
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.hintTextColor
import org.jetbrains.anko.sp
import org.jetbrains.anko.textColor

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 14:36
 * @Description: 用途：完成特定功能
 */
class LoginActivity:BaseActivity(), View.OnClickListener, ILoginContract.IView {

    override fun initLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initLintener() {
        //申请入驻
        tvSettle.setOnClickListener(this)
        editEmil.setOnFocusChangeListener(object :View.OnFocusChangeListener{
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if(!hasFocus){
                    val emil = editEmil.text.toString()
                    if (!emil.contains(".com")) {
                        editEmil.textColor = Color.RED
                        myToast("账号格式不对")
                    }else{

                    }
                }else{
                    editEmil.textColor = Color.BLACK
                }
            }

        })

        //登入
        btnLogin.setOnClickListener {
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
                    val presenter = LoginPresenter(this)
                    var hashMap = HashMap<String,String>()
                    hashMap.put("email",emil)
                    //加密
                    val pwd1 = RsaCoder.encryptByPublicKey(pwd)
                    hashMap.put("pwd",pwd1)
                    presenter.login(hashMap)

            }
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

        //忘记密码
        tvPwd.setOnClickListener {
            startActivity(Intent(this,ForgetPwdActivity::class.java))
        }
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
    private fun stringNotNull(str:String):Boolean{
        return TextUtils.isEmpty(str)
    }

    override fun onLoginSuccess(bean: LoginBean) {
        if (bean.message!!.contains("登录成功")) {
            val result = bean.result
            result?.let {

                //存储id
                val spUtil = SpUtil.getSpUtil()
                val id = result.id
                val sessionId = result.sessionId
                spUtil.putInt(SpKey.DOCTORID,id!!)
                spUtil.putString(SpKey.SESSIONID,sessionId!!)

                val whetherHaveImagePic = it.whetherHaveImagePic
                if(whetherHaveImagePic==1){
                    startActivityFinish<HomePagerActivity>()
                    overridePendingTransition(R.anim.s0,R.anim.s1)
                }else{
                    startActivityFinish<PhotoActivity>()
                }
            }

        }else if(bean.message!!.contains("登录失败，账号或密码错误")){
            editPwd.setText("")
            editPwd.hint = "密码输入错误"
            editPwd.hintTextColor = Color.RED
        }
    }

    override fun onLoginFailed(error: String) {

    }
}