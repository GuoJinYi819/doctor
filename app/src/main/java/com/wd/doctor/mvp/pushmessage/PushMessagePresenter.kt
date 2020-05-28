package com.wd.doctor.mvp.pushmessage

import com.wd.doctor.bean.PublicListBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/28 0028 14:41
 * @Description: 用途：完成特定功能
 */
class PushMessagePresenter(var view:IPushMessaveContract.IView):IPushMessaveContract.IPresenter {
    val module = PushMessageModel()
    override fun pushMessage(params: Map<String, String>) {
        module.pushMessage(params,object :IPushMessaveContract.IModule.ModelCallBack{
            override fun onPushSuccess(bean: PublicListBean) {
                view.onPushSuccess(bean)
            }

            override fun onPushFailed(error: String) {
                view.onPushFailed(error)
            }

        })
    }
}