package com.wd.doctor.mvp.login

import com.wd.doctor.bean.LoginBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/20 0020 15:20
 * @Description: 用途：完成特定功能
 */
class LoginPresenter(var view:ILoginContract.IView):ILoginContract.IPresenter {
    var model = LoginModel()
    override fun login(params: Map<String, String>) {
        model.login(params,object :ILoginContract.IModule.ModuleCallBack{
            override fun onLoginSuccess(bean: LoginBean) {
                view.onLoginSuccess(bean)
            }

            override fun onLoginFailed(error: String) {
                view.onLoginFailed(error)
            }

        })
    }
}