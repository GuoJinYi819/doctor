package com.wd.doctor.mvp.findsickcirclelist

import com.wd.doctor.base.IBaseView
import com.wd.doctor.bean.SickCircleListBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 18:28
 * @Description: 用途：完成特定功能
 */
interface IFindSickCircleListContract {
    interface IView:IBaseView{
        fun onSickCircleSuccess(bean: SickCircleListBean)
        fun onSickCircleFailed(error:String)
    }
    interface IModel{
        fun getSickCircleData(params:Map<String,String>,callback: ModuleCallBack)
        interface ModuleCallBack{
            fun onSickCircleSuccess(bean: SickCircleListBean)
            fun onSickCircleFailed(error:String)
        }
    }
    interface IPresenter{
        fun getSickCircleData(params:Map<String,String>)
    }
}