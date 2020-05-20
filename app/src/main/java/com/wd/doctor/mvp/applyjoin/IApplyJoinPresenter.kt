package com.wd.doctor.mvp.applyjoin

import com.wd.doctor.bean.MessageBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/19 0019 17:21
 * @Description: 用途：完成特定功能
 */
class IApplyJoinPresenter(var view:IApplyJoinContract.IView):IApplyJoinContract.IPresenter {
    val module = IApplyJoinModel()
    override fun applyJoin(params: Map<String, String>) {
        module.applyJoin(params,object :IApplyJoinContract.IModel.ModuleCallBack{
            override fun onSuccess(bean: MessageBean) {
                view.onSuccess(bean)
            }

            override fun onFailed(error: String) {
                view.onFailed(error)
            }

        })
    }
}