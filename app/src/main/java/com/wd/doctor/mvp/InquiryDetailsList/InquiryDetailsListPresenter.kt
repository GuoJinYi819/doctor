package com.wd.doctor.mvp.InquiryDetailsList

import com.wd.doctor.bean.PublicListBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/27 0027 15:04
 * @Description: 用途：完成特定功能
 */
class InquiryDetailsListPresenter(var view:InquiryDetailsListContract.IView):InquiryDetailsListContract.IPresenter {
    val module = InquiryDetailsListModel()
    override fun getData(params: Map<String, String>) {
        module.getData(params,object :InquiryDetailsListContract.IModel.ModelCallBack{
            override fun onFailed(error: String) {
                view.onFailed(error)
            }

            override fun onSuccess(bean: PublicListBean) {
                view.onSuccess(bean)
            }

        })
    }
}