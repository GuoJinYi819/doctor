package com.wd.doctor.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Handler
import android.os.Message
import android.text.InputType
import android.text.TextUtils
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.DepartmentBean
import com.wd.doctor.bean.JobTitleListBean
import com.wd.doctor.bean.MessageBean
import com.wd.doctor.customview.MyEditText
import com.wd.doctor.mvp.department.DepartmentPresenter
import com.wd.doctor.mvp.department.IDepartmentContract
import com.wd.doctor.mvp.jobtitlelist.IJobTitleListContract
import com.wd.doctor.mvp.jobtitlelist.JobTitlePresenter
import com.wd.doctor.mvp.sendemailcode.ISendEmailContract
import com.wd.doctor.mvp.sendemailcode.SendEmilPresenter
import com.wd.doctor.utils.SpKey
import com.wd.doctor.utils.SpUtil
import kotlinx.android.synthetic.main.activity_settle.*
import kotlinx.android.synthetic.main.view_edit.view.*
import kotlinx.android.synthetic.main.view_edit.view.tvTitle
import kotlinx.android.synthetic.main.view_spring.view.*
import org.jetbrains.anko.hintTextColor

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 15:41
 * @Description: 用途：申请入驻
 */
class SettleActivity:BaseActivity(), View.OnClickListener, ISendEmailContract.IView {
    var i = 60
    var handler = object :Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if(msg.what==1){
                i--
                if(i>0){
                    getCode.text = "${i}秒内有效"
                    sendEmptyMessageDelayed(1,1000)
                }else{
                    getCode.text = "重新发送验证码"
                    removeCallbacksAndMessages(null)
                }
            }
        }
    }

    //验证码
    override fun onSendEmailSuccess(bean: MessageBean) {
        if(bean.message.equals("发送成功")){
            handler.sendEmptyMessageDelayed(1,1000)
        }
    }

    override fun onSendEmailFailed(error: String) {
        myToast("异常信息"+error)
    }


    override fun initLayoutId(): Int {
        return R.layout.activity_settle
    }
    var help:Boolean = false

    override fun initLintener() {

        //下一步
        tvNext.setOnClickListener(this)
        //获取验证码
        getCode.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tvNext->{
                    if (notNull()) {
                         startActivity(Intent(this,SettleTwoActivity::class.java))
                     }
                }

            R.id.getCode->{
                //获取验证码
                if (getCode.text.toString().equals("获取验证码")||getCode.text.toString().equals("重新发送验证码")) {
                    if (!stringNotNull(editEmil.editText?.text.toString())) {
                        var presenter = SendEmilPresenter(this)
                        presenter.sendEmailCode(editEmil.editText?.text.toString())
                    }else{
                        editEmil.editText?.editText?.hint = "账号暂未输入"
                        editEmil.editText?.editText?.hintTextColor = Color.RED
                    }
                }

            }
        }
    }

    //判空
    private fun stringNotNull(str:String):Boolean{
        return TextUtils.isEmpty(str)
    }

    //判空处理
    fun notNull(): Boolean {
        var i = 0
        val spUtil = SpUtil.getSpUtil()
        if (stringNotNull(editEmil.editText?.text.toString())) {
            //为空
            editEmil.editText?.editText?.hint = "暂未输入"
            editEmil.editText?.editText?.hintTextColor = Color.RED
            help == false
        }else{
            //存储
            spUtil.putString(SpKey.EMAIL,editEmil.editText?.text.toString())
            i++
        }
        if (stringNotNull(editCode.editText?.text.toString())){
            //为空
            editCode.editText?.editText?.hint = "暂未输入"
            editCode.editText?.editText?.hintTextColor = Color.RED
            help == false
        }else{
            spUtil.putString(SpKey.CODE,editCode.editText?.text.toString())
            i++
        }

        if(stringNotNull(editPwd_1.editText?.text.toString())){
            editPwd_1.editText?.editText?.hint = "暂未输入"
            editPwd_1.editText?.editText?.hintTextColor = Color.RED
            help == false
        }else{
            spUtil.putString(SpKey.PWD1,editPwd_1.editText?.text.toString())
            i++
        }

        if(stringNotNull(editPwd_2.editText?.text.toString())){
            editPwd_2.editText?.editText?.hint = "与第一次密码不一致"
            editPwd_2.editText?.editText?.hintTextColor = Color.RED
            help == false
        }else{
            val pwd1 = editPwd_1.editText?.text.toString()
            val pwd2 = editPwd_2.editText?.text.toString()
            if(!pwd1.equals(pwd2)){
                editPwd_2.editText?.setText("")
                editPwd_2.editText?.editText?.hint = "与第一次密码不一致"
                editPwd_2.editText?.editText?.hintTextColor = Color.RED
            }else{
                spUtil.putString(SpKey.PWD2,editPwd_2.editText?.text.toString())
                help = true
                i++
            }
        }

        if(i==4){
            return true
        }else{
            return false
        }

    }


    override fun initData() {

        editCode.tvTitle.text = "请输入验证码"
        editPwd_1.tvTitle.text = "请输入密码"
        //设置密码样式为 不可见
        editPwd_2.tvTitle.text = "请再次输入密码"
        editPwd_1.setPassword(true)
        editPwd_2.setPassword(true)
        editPwd_1.eye?.visibility = View.VISIBLE
        editPwd_2.eye?.visibility = View.VISIBLE

    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

}