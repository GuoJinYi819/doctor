package com.wd.doctor.mvp.sendemailcode

import com.wd.doctor.bean.MessageBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/19 0019 8:21
 * @Description: 用途：完成特定功能
 */
class SendEmilPresenter(var view:ISendEmailContract.IView):ISendEmailContract.IPresenter {
    var module = SendEmilModel()
    override fun sendEmailCode(email: String) {
        module.sendEmailCode(email,object :ISendEmailContract.IModel.ModuleCallBack{
            override fun onSendEmailSuccess(bean: MessageBean) {
                view.onSendEmailSuccess(bean)
            }

            override fun onSendEmailFailed(error: String) {
                view.onSendEmailFailed(error)
            }

        })
    }
}