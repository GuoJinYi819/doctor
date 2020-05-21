package com.wd.doctor.mvp.finddoctorbyId

import com.wd.doctor.base.IBaseView
import com.wd.doctor.bean.LoginBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 16:30
 * @Description: 用途：完成特定功能
 */
class IFindDoctorByIdContract {
    interface IView :IBaseView{
        fun onFindDoctorSuccess(bean: LoginBean)
        fun onFindDoctorFailed(error:String)
    }
    interface IModule{
        fun getMessage(callBack: ModuleCallBack)
        interface ModuleCallBack{
            fun onFindDoctorSuccess(bean: LoginBean)
            fun onFindDoctorFailed(error:String)
        }
    }
    interface IPresenter{
        fun getMessage()
    }
}