package com.wd.doctor.mvp.checkcode

import com.wd.doctor.base.IBaseView
import com.wd.doctor.bean.MessageBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/20 0020 17:26
 * @Description: 用途：完成特定功能
 */
interface ICheckCodeContract {
    interface IView :IBaseView{
        fun onCheckSuccess(bean:MessageBean)
        fun onCheckFailed(error:String)
    }
    interface IModule{
        fun checkCode(email:String,code:String,callback: ModuleCallBack)
        interface ModuleCallBack{
            fun onCheckSuccess(bean:MessageBean)
            fun onCheckFailed(error:String)
        }
    }
    interface IPresenter{
        fun checkCode(email:String,code:String)
    }
}