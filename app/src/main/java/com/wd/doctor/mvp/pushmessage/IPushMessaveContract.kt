package com.wd.doctor.mvp.pushmessage

import com.wd.doctor.base.IBaseView
import com.wd.doctor.bean.PublicListBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/28 0028 14:35
 * @Description: 用途：完成特定功能
 */
interface IPushMessaveContract {
    interface IView :IBaseView{
        fun onPushSuccess(bean: PublicListBean)
        fun onPushFailed(error:String)
    }
    interface IModule{
        fun pushMessage(params:Map<String,String>,callback:ModelCallBack)
        interface ModelCallBack{
            fun onPushSuccess(bean: PublicListBean)
            fun onPushFailed(error:String)
        }
    }
    interface IPresenter{
        fun pushMessage(params:Map<String,String>)
    }

}