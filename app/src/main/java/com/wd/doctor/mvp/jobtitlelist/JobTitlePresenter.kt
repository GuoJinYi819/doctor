package com.wd.doctor.mvp.jobtitlelist

import com.wd.doctor.bean.JobTitleListBean

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 20:48
 * @Description: 用途：完成特定功能
 */
class JobTitlePresenter(var view:IJobTitleListContract.IView):IJobTitleListContract.IPresenter {
    var module = JobTitleModel()
    override fun getJobTitleData() {
        module.getJobTitleData(object :IJobTitleListContract.IModel.IModelCallBack{
            override fun onJobTitleSuccess(bean: JobTitleListBean) {
                view.onJobTitleSuccess(bean)
            }

            override fun onJobTitleFailed(error: String) {
                view.onJobTitleFailed(error)
            }

        })
    }
}