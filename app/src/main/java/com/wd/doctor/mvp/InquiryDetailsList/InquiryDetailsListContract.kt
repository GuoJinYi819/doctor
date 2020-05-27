package com.wd.doctor.mvp.InquiryDetailsList

import com.wd.doctor.base.IBaseView
import com.wd.doctor.bean.PublicBean
import com.wd.doctor.bean.PublicListBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/27 0027 14:57
 * @Description: 用途：完成特定功能
 */
interface InquiryDetailsListContract {
    interface IView:IBaseView{
        fun onSuccess(bean: PublicListBean)
        fun onFailed(error:String)
    }
    interface IModel{
        fun getData(params:Map<String,String>,callback:ModelCallBack)
        interface ModelCallBack{
            fun onSuccess(bean:PublicListBean)
            fun onFailed(error:String)
        }
    }
    interface IPresenter{
        fun getData(params:Map<String,String>)
    }
}