package com.wd.doctor.mvp.findsickcircleinfo

import com.wd.doctor.bean.PublicBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 8:17
 * @Description: 用途：完成特定功能
 */
class FindSickCirclePresenter(var view:IFindSickCircleInfoContract.IView):IFindSickCircleInfoContract.IPresenter {
    val module = FindSickCircleModel()
    override fun getSickCircleData(sickCircleId: Int) {
        module.getSickCircleData(sickCircleId,object :IFindSickCircleInfoContract.IModel.ModuleCallBack{
            override fun onSickCircleSuccess(bean: PublicBean) {
                view.onSickCircleSuccess(bean)
            }

            override fun onSickCircleFailed(error: String) {
                view.onSickCircleFailed(error)
            }

        })
    }
}