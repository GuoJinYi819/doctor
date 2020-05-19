package com.wd.doctor.ui.activity

import android.content.Intent
import android.graphics.Color
import android.text.TextUtils
import android.view.View
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.DepartmentBean
import com.wd.doctor.bean.JobTitleListBean
import com.wd.doctor.customview.MySpring
import com.wd.doctor.mvp.department.DepartmentPresenter
import com.wd.doctor.mvp.department.IDepartmentContract
import com.wd.doctor.mvp.jobtitlelist.IJobTitleListContract
import com.wd.doctor.mvp.jobtitlelist.JobTitlePresenter
import com.wd.doctor.utils.SpKey
import com.wd.doctor.utils.SpUtil
import kotlinx.android.synthetic.main.activity_settle.*
import kotlinx.android.synthetic.main.activity_settle.editCode
import kotlinx.android.synthetic.main.activity_settle.editEmil
import kotlinx.android.synthetic.main.activity_settle.tvNext
import kotlinx.android.synthetic.main.activity_settle_two.*
import kotlinx.android.synthetic.main.view_edit.view.*
import org.jetbrains.anko.hintTextColor
import org.jetbrains.anko.sp

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/19 0019 14:30
 * @Description: 用途：完成特定功能
 */
class SettleTwoActivity:BaseActivity(), IDepartmentContract.IView, IJobTitleListContract.IView {

    //科室列表
    var list:ArrayList<String>? = ArrayList()
    //职位列表
    var jobTitleList = ArrayList<String>()
    override fun onJobTitleSuccess(bean: JobTitleListBean) {
        val result = bean.result
        result?.forEach {
            jobTitleList.add(it.jobTitle!!)
        }
        mySpring_2.setData(jobTitleList!!)
    }

    override fun onJobTitleFailed(error: String) {
        myToast("异常信息"+error)
    }


    override fun onDepartmentSuccess(bean: DepartmentBean) {
        val arrayList = bean.result
        arrayList?.let {
            for ((index,value) in arrayList.withIndex()){
                list?.add(value.departmentName!!)
            }
            mySpring_1.setData(list!!)
        }

    }

    override fun onFailed(error: String) {
        myToast("异常信息"+error)
    }

    override fun initLayoutId(): Int {
        return R.layout.activity_settle_two
    }

    override fun initLintener() {
        tvNext.setOnClickListener {
            if (change()) {
                startActivity(Intent(this,MessageActivity::class.java))
            }
        }
    }

    override fun initData() {
        //科室列表请求数据
        var presenter = DepartmentPresenter(this)
        presenter.getDepartmentData()
        //职位请求数据
        var pre = JobTitlePresenter(this)
        pre.getJobTitleData()

        editName.tvTitle.text = "您的真实姓名"
        editName.editText?.setText("")

        editAddrss.tvTitle.text = "您所在医院"
        editAddrss.editText?.setText("")


        mySpring_1.tvTitle?.text = "您所在科室"
        mySpring_2.tvTitle?.text = "您的职称"


        val spUtil = SpUtil.getSpUtil()
        mySpring_1.onPositionListener = object :MySpring.OnPositionListener{
            override fun onPosition(id: Int) {
                var i = id+1
                spUtil.putInt(SpKey.DEPARTMENTID,i)
            }
        }
        mySpring_2.onPositionListener = object :MySpring.OnPositionListener{
            override fun onPosition(id: Int) {
                var i = id+1
                spUtil.putInt(SpKey.JOBTITLEID,i)
            }
        }

    }

    fun change():Boolean{
        val spUtil = SpUtil.getSpUtil()
        var i=0
        if (stringNotNull(editName.editText?.text.toString())) {
            //为空
            editName.editText?.editText?.hint = "暂未输入"
            editName.editText?.editText?.hintTextColor = Color.RED
        }else{
            spUtil.putString(SpKey.NAME,editName.editText?.text.toString())
            i++
        }
        if (stringNotNull(editAddrss.editText?.text.toString())){
            //为空
            editAddrss.editText?.editText?.hint = "暂未输入"
            editAddrss.editText?.editText?.hintTextColor = Color.RED
        }else{
            spUtil.putString(SpKey.INAUGURALHOSPITAL,editAddrss.editText?.text.toString())
            i++
        }

        //获取科室和职称id


        if(i==2){
            return true
        }else{
            return false
        }

    }
    //判空
    private fun stringNotNull(str:String):Boolean{
        return TextUtils.isEmpty(str)
    }
}