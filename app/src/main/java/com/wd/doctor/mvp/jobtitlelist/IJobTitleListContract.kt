package com.wd.doctor.mvp.jobtitlelist

import com.wd.doctor.base.IBaseView
import com.wd.doctor.bean.JobTitleListBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 19:55
 * @Description: 用途：完成特定功能
 */
interface IJobTitleListContract {
    interface IView :IBaseView{
        fun onJobTitleSuccess(bean:JobTitleListBean)
        fun onJobTitleFailed(error:String)
    }
    interface IModel{
        fun getJobTitleData(callBack: IModelCallBack)
        interface IModelCallBack{
            fun onJobTitleSuccess(bean:JobTitleListBean)
            fun onJobTitleFailed(error:String)
        }
    }
    interface IPresenter{
        fun getJobTitleData()
    }
}