package com.wd.doctor.mvp.checkcode

import com.wd.doctor.bean.MessageBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/20 0020 17:31
 * @Description: 用途：完成特定功能
 */
class CheckCodePresenter(var view:ICheckCodeContract.IView) :ICheckCodeContract.IPresenter {
    var module = CheckCodeModule()
    override fun checkCode(email: String, code: String) {
        module.checkCode(email,code,object :ICheckCodeContract.IModule.ModuleCallBack{
            override fun onCheckSuccess(bean: MessageBean) {
                view.onCheckSuccess(bean)
            }

            override fun onCheckFailed(error: String) {
                view.onCheckFailed(error)
            }

        })
    }
}