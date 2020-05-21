package com.wd.doctor.ui.activity

import android.content.Intent
import com.bumptech.glide.Glide
import com.wd.doctor.App
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.LoginBean
import com.wd.doctor.mvp.finddoctorbyId.FindDoctorByIdPresenter
import com.wd.doctor.mvp.finddoctorbyId.IFindDoctorByIdContract
import kotlinx.android.synthetic.main.activity_home_pager.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/20 0020 15:57
 * @Description: 用途：主页
 */
class HomePagerActivity:BaseActivity(), IFindDoctorByIdContract.IView {

    val presenter by lazy { FindDoctorByIdPresenter(this)}
    override fun initLayoutId(): Int {
        return R.layout.activity_home_pager
    }

    override fun initLintener() {
        //答疑界面
        relativeConsultation.setOnClickListener {
            startActivity(Intent(this,ConsultationActivity::class.java))
            overridePendingTransition(R.anim.z1,R.anim.z0)
        }
    }

    override fun initData() {
        labelView_2.text("答疑")
        labelView_3.text("管理")
        //查询个人信息
        presenter.getMessage()

    }
    //个人信息
    override fun onFindDoctorSuccess(bean: LoginBean) {
        val result = bean.result
        result?.let {
            //展示图片
            Glide.with(App.context!!).load(result.imagePic).into(imagePic)
            //姓名
            tvName.text = it.name
            //职称
            tvJobTitle.text = it.jobTitle
            //医院
            tvInauguralHospital.text = it.inauguralHospital
            //格式名称
            departmentName.text = it.departmentName

        }
    }

    override fun onFindDoctorFailed(error: String) {

    }

    override fun finish() {
        super.finish()

    }
}