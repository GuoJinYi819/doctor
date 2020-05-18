package com.wd.doctor.mvp.department

import com.wd.doctor.base.IBaseView
import com.wd.doctor.bean.DepartmentBean
import com.wd.doctor.net.ApiService

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 19:14
 * @Description: 用途：完成特定功能
 */
interface IDepartmentContract {
    interface IView :IBaseView{
        fun onDepartmentSuccess(bean:DepartmentBean)
        fun onFailed(error:String)
    }
    interface IModel{
        fun getDepartmentData(callBack: IModuleCallBack)
        interface IModuleCallBack{
            fun onDepartmentSuccess(bean:DepartmentBean)
            fun onFailed(error:String)
        }
    }
    interface IPresenter{
        fun getDepartmentData()
    }



}