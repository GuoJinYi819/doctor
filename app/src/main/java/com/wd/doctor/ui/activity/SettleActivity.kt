package com.wd.doctor.ui.activity

import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.DepartmentBean
import com.wd.doctor.customview.MyEditText
import com.wd.doctor.mvp.department.DepartmentPresenter
import com.wd.doctor.mvp.department.IDepartmentContract
import kotlinx.android.synthetic.main.activity_settle.*
import kotlinx.android.synthetic.main.view_edit.view.*
import kotlinx.android.synthetic.main.view_edit.view.tvTitle
import kotlinx.android.synthetic.main.view_spring.view.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 15:41
 * @Description: 用途：申请入驻
 */
class SettleActivity:BaseActivity(), View.OnClickListener, IDepartmentContract.IView {
    //科室列表
    var list:ArrayList<String>? = ArrayList()
    override fun onDepartmentSuccess(bean: DepartmentBean) {
        val arrayList = bean.result
        arrayList?.let {
            for ((index,value) in arrayList.withIndex()){
                list?.add(index,value.departmentName!!)
            }
        }

    }

    override fun onFailed(error: String) {
        myToast("异常信息"+error)
    }

    override fun initLayoutId(): Int {
        return R.layout.activity_settle
    }

    override fun initLintener() {

        //下一步
        tvNext.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tvNext->{
                editEmil.tvTitle.text = "您的真实姓名"

                editCode.tvTitle.text = "您所在医院"
                //隐藏 获取验证码
                getCode.visibility = View.GONE

                editPwd_1.visibility = View.GONE
                editPwd_2.visibility = View.GONE

                mySpring_1.visibility = View.VISIBLE
                mySpring_2.visibility = View.VISIBLE

                mySpring_1.tvTitle?.text = "您所在科室"

                mySpring_1.setData(list!!)

                mySpring_2.tvTitle?.text = "您的职称"

                mySpring_2.setData(list!!)

            }
        }
    }

    //清除输入内容
    fun textClone(edit:MyEditText){
        edit.tvTitle.setText("")
    }

    override fun initData() {

        var presenter = DepartmentPresenter(this)
        presenter.getDepartmentData()

        editCode.tvTitle.text = "请输入验证码"
        editPwd_1.tvTitle.text = "请输入密码"
        //设置密码样式为 不可见
        editPwd_2.tvTitle.text = "请再次输入密码"
        editPwd_1.setPassword(true)
        editPwd_2.setPassword(true)
        editPwd_1.eye?.visibility = View.VISIBLE
        editPwd_2.eye?.visibility = View.VISIBLE

    }

}