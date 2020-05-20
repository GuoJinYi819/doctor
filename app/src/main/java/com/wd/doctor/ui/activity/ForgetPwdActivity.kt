package com.wd.doctor.ui.activity

import android.os.Handler
import android.os.Message
import android.text.TextUtils
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.MessageBean
import com.wd.doctor.mvp.sendemailcode.ISendEmailContract
import com.wd.doctor.mvp.sendemailcode.SendEmilPresenter
import kotlinx.android.synthetic.main.activity_forget_pwd.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/20 0020 16:10
 * @Description: 用途：完成特定功能
 */
class ForgetPwdActivity:BaseActivity(), ISendEmailContract.IView {

    override fun onSendEmailSuccess(bean: MessageBean) {

    }

    override fun onSendEmailFailed(error: String) {

    }

    override fun initLayoutId(): Int {
        return R.layout.activity_forget_pwd
    }

    var i = 60
    var handler = object :Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if(msg.what==1){
                i--
                if(i>0){
                    getCode.text = "${i}秒后重新获取"
                    sendEmptyMessageDelayed(1,1000)
                }else{
                    getCode.text = "重新获取"
                }
            }
        }
    }

    override fun initLintener() {
        getCode.setOnClickListener {
            val email = editEmail.text.toString()
            val presenter = SendEmilPresenter(this)
            presenter.sendEmailCode(email)
            handler.sendEmptyMessageDelayed(1,1000)
        }

        btnNext.setOnClickListener {
            val email = editEmail.text.toString()
            val pwd = editCode.text.toString()
            if(TextUtils.isEmpty(email)&&TextUtils.isEmpty(pwd)){
                myToast("账号或密码为空")
            }else{

            }
        }
    }

    override fun initData() {

    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}