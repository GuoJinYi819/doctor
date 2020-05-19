package com.wd.doctor.mvp.sendemailcode

import com.wd.doctor.base.IBaseView
import com.wd.doctor.bean.MessageBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/19 0019 8:04
 * @Description: 用途：完成特定功能
 */
interface ISendEmailContract {
    interface IView:IBaseView{
        fun onSendEmailSuccess(bean: MessageBean)
        fun onSendEmailFailed(error:String)
    }
    interface IModel{
        fun sendEmailCode(email:String,callBack: ModuleCallBack)
        interface ModuleCallBack{
            fun onSendEmailSuccess(bean: MessageBean)
            fun onSendEmailFailed(error:String)
        }
    }
    interface IPresenter{
        fun sendEmailCode(email:String)
    }
}