package com.wd.doctor.ui.activity

import com.bumptech.glide.Glide
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.LoginBean
import com.wd.doctor.mvp.finddoctorbyId.FindDoctorByIdPresenter
import com.wd.doctor.mvp.finddoctorbyId.IFindDoctorByIdContract
import kotlinx.android.synthetic.main.activity_my.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 17:21
 * @Description: 用途：完成特定功能
 */
class MyActivity:BaseActivity(), IFindDoctorByIdContract.IView {

    val presenter by lazy { FindDoctorByIdPresenter(this) }

    override fun initLayoutId(): Int {
        return R.layout.activity_my
    }

    override fun initLintener() {
        ivBack.setOnClickListener {
            finish()
        }
    }

    override fun initData() {
        //查询个人信息
        presenter.getMessage()
    }
    //个人信息
    override fun onFindDoctorSuccess(bean: LoginBean) {
        val result = bean.result
        result?.let {
            Glide.with(this).load(result.imagePic).into(ivImagePic)
        }
    }

    override fun onFindDoctorFailed(error: String) {
    }
}