package com.wd.doctor.ui.activity

import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.PublicBean
import com.wd.doctor.mvp.inquiryrecordlist.IInquiryRecordListContract
import com.wd.doctor.mvp.inquiryrecordlist.InquiryRecordPresenter
import kotlinx.android.synthetic.main.activity_ask.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 15:04
 * @Description: 用途：问诊界面
 */
class AskActivity:BaseActivity(), IInquiryRecordListContract.IView {

    val presenter by lazy { InquiryRecordPresenter(this) }
    override fun initLayoutId(): Int {
        return R.layout.activity_ask
    }

    override fun initLintener() {
    }

    override fun initData() {
        //请求问诊列表
        presenter.getInquiryRecordList()
        //设置布局管理器
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    //问诊列表界面
    override fun onInquiryRecordSuccess(bean: PublicBean) {
        println(bean.toString())
    }
    override fun onInquiryRecordFailed(error: String) {
    }
}