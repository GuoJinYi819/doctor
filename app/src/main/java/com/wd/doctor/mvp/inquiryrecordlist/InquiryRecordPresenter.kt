package com.wd.doctor.mvp.inquiryrecordlist

import com.wd.doctor.bean.PublicBean
import com.wd.doctor.bean.PublicListBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 15:25
 * @Description: 用途：完成特定功能
 */
class InquiryRecordPresenter(var view:IInquiryRecordListContract.IView):IInquiryRecordListContract.IPresenter {
    val model = InquiryRecordModel()
    override fun getInquiryRecordList() {
        model.getInquiryRecordList(object :IInquiryRecordListContract.IModel.ModelCallBack{
            override fun onInquiryRecordSuccess(bean: PublicListBean) {
                view.onInquiryRecordSuccess(bean)
            }

            override fun onInquiryRecordFailed(error: String) {
                view.onInquiryRecordFailed(error)
            }

        })
    }
}