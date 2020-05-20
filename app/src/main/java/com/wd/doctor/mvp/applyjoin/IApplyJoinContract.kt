package com.wd.doctor.mvp.applyjoin

import com.wd.doctor.base.IBaseView
import com.wd.doctor.bean.MessageBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/19 0019 17:16
 * @Description: 用途：完成特定功能
 */
interface IApplyJoinContract {
    interface IView :IBaseView{
        fun onSuccess(bean:MessageBean)
        fun onFailed(error:String)
    }
    interface IModel{
        fun applyJoin(params:Map<String,String>,callBack: ModuleCallBack)
        interface ModuleCallBack{
            fun onSuccess(bean:MessageBean)
            fun onFailed(error:String)
        }
    }
    interface IPresenter{
        fun applyJoin(params:Map<String,String>)
    }
}