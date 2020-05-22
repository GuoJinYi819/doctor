package com.wd.doctor.mvp.inquiryrecordlist

import com.wd.doctor.base.IBaseView
import com.wd.doctor.bean.PublicBean
import com.wd.doctor.bean.PublicListBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 15:17
 * @Description: 用途：完成特定功能
 */
interface IInquiryRecordListContract {
    interface IView:IBaseView{
        fun onInquiryRecordSuccess(bean: PublicListBean)
        fun onInquiryRecordFailed(error:String)
    }
    interface IModel{
        fun getInquiryRecordList(callback: ModelCallBack)
        interface ModelCallBack{
            fun onInquiryRecordSuccess(bean: PublicListBean)
            fun onInquiryRecordFailed(error:String)
        }
    }
    interface IPresenter{
        fun getInquiryRecordList()
    }
}