package com.wd.doctor.ui.activity

import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.PublicListBean
import com.wd.doctor.mvp.InquiryDetailsList.InquiryDetailsListContract
import com.wd.doctor.mvp.InquiryDetailsList.InquiryDetailsListPresenter
import kotlinx.android.synthetic.main.activity_content.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/26 0026 14:52
 * @Description: 用途：聊天界面
 */
class ContentActivity:BaseActivity(), InquiryDetailsListContract.IView {

    //获取聊天数据
    val presenter by lazy { InquiryDetailsListPresenter(this) }
    override fun initLayoutId(): Int {
        return R.layout.activity_content
    }

    override fun initLintener() {
        ivBack.setOnClickListener {
            finish()
        }
    }

    override fun initData() {
        tvTitle.text = intent.getStringExtra("name")
        //获取聊天数据
        val map = HashMap<String,String>()
        map.put("inquiryId","255")
        map.put("page","1")
        map.put("count","15")
        presenter.getData(map)
    }

    //获取聊天数据
    override fun onSuccess(bean: PublicListBean) {

    }

    override fun onFailed(error: String) {
    }

}