package com.wd.doctor.mvp.findsickcirclelist

import com.wd.doctor.bean.SickCircleListBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 18:37
 * @Description: 用途：完成特定功能
 */
class FindSickCirclePresenter(var view:IFindSickCircleListContract.IView):IFindSickCircleListContract.IPresenter {
    val module = FindSickCircleModle()
    override fun getSickCircleData(params: Map<String, String>) {
        module.getSickCircleData(params,object :IFindSickCircleListContract.IModel.ModuleCallBack{
            override fun onSickCircleSuccess(bean: SickCircleListBean) {
                view.onSickCircleSuccess(bean)
            }

            override fun onSickCircleFailed(error: String) {
                view.onSickCircleFailed(error)
            }

        })
    }
}