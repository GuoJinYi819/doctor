package com.wd.doctor.mvp.findsickcircleinfo

import com.wd.doctor.base.IBaseView
import com.wd.doctor.bean.PublicBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 8:13
 * @Description: 用途：完成特定功能
 */
interface IFindSickCircleInfoContract {
    interface IView:IBaseView{
        fun onSickCircleSuccess(bean: PublicBean)
        fun onSickCircleFailed(error:String)
    }
    interface IModel{
        fun getSickCircleData(sickCircleId:Int,callback: ModuleCallBack)
        interface ModuleCallBack{
            fun onSickCircleSuccess(bean: PublicBean)
            fun onSickCircleFailed(error:String)
        }
    }
    interface IPresenter{
        fun getSickCircleData(sickCircleId:Int)
    }
}