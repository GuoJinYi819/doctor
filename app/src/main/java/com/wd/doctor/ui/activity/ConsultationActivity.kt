package com.wd.doctor.ui.activity

import android.telecom.Call
import com.wd.doctor.R
import com.wd.doctor.adapter.DetailsAdapter
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.DepartmentBean
import com.wd.doctor.mvp.department.DepartmentPresenter
import com.wd.doctor.mvp.department.IDepartmentContract
import kotlinx.android.synthetic.main.activity_consultation.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 17:29
 * @Description: 用途：答疑界面
 */
class ConsultationActivity:BaseActivity(), IDepartmentContract.IView {

    //科室列表
    val presenter by lazy { DepartmentPresenter(this) }
    override fun initLayoutId(): Int {
        return R.layout.activity_consultation
    }

    override fun initLintener() {
    }

    override fun initData() {
        //获取科室列表
        presenter.getDepartmentData()
    }

    //科室列表
    override fun onDepartmentSuccess(bean: DepartmentBean) {
        val result = bean.result
        result?.let {
            val adapter = DetailsAdapter(supportFragmentManager)
            adapter.setData(result)
            val viewPager = viewPager
            viewPager.adapter = adapter
            tabLayout.setupWithViewPager(viewPager)

        }
    }

    override fun onFailed(error: String) {
    }
}