package com.wd.doctor.mvp.login

import com.wd.doctor.base.IBaseView
import com.wd.doctor.bean.LoginBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/20 0020 15:16
 * @Description: 用途：完成特定功能
 */
interface ILoginContract {
    interface IView:IBaseView{
        fun onLoginSuccess(bean:LoginBean)
        fun onLoginFailed(error:String)
    }
    interface IModule{
        fun login(params:Map<String,String>,callBack: ModuleCallBack)
        interface ModuleCallBack{
            fun onLoginSuccess(bean:LoginBean)
            fun onLoginFailed(error:String)
        }
    }
    interface IPresenter{
        fun login(params:Map<String,String>)
    }
}