package com.wd.doctor.mvp.finddoctorbyId

import com.wd.doctor.bean.LoginBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 16:34
 * @Description: 用途：完成特定功能
 */
class FindDoctorByIdPresenter(var view:IFindDoctorByIdContract.IView):IFindDoctorByIdContract.IPresenter {
    var module = FindDoctorByIdModule()
    override fun getMessage() {
        module.getMessage(object :IFindDoctorByIdContract.IModule.ModuleCallBack{
            override fun onFindDoctorSuccess(bean: LoginBean) {
                view.onFindDoctorSuccess(bean)
            }

            override fun onFindDoctorFailed(error: String) {
                view.onFindDoctorFailed(error)
            }

        })
    }
}