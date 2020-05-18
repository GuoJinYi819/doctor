package com.wd.doctor.mvp.department

import com.wd.doctor.bean.DepartmentBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 19:26
 * @Description: 用途：完成特定功能
 */
class DepartmentPresenter(var view:IDepartmentContract.IView):IDepartmentContract.IPresenter {
    val model = DepartmentModel()
    override fun getDepartmentData() {
        model.getDepartmentData(object :IDepartmentContract.IModel.IModuleCallBack{
            override fun onDepartmentSuccess(bean: DepartmentBean) {
                view.onDepartmentSuccess(bean)
            }

            override fun onFailed(error: String) {
                view.onFailed(error)
            }

        })
    }
}