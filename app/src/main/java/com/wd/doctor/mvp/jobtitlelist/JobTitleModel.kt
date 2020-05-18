package com.wd.doctor.mvp.jobtitlelist

import com.wd.doctor.bean.JobTitleListBean
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 20:01
 * @Description: 用途：完成特定功能
 */
class JobTitleModel: IJobTitleListContract.IModel{
    override fun getJobTitleData(callBack: IJobTitleListContract.IModel.IModelCallBack) {
        val retrofitUtil = RetrofitUtil.getUtil()
        val apiService = retrofitUtil.createService()
        apiService?.let {
            val observable = it.findJobTitle(PathUtil.getFindJobTitleList())
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :DisposableObserver<JobTitleListBean>(){
                    override fun onComplete() {

                    }

                    override fun onNext(value: JobTitleListBean?) {
                        callBack.onJobTitleSuccess(value!!)
                    }

                    override fun onError(e: Throwable?) {
                        callBack.onJobTitleFailed(e?.message!!)
                    }

                })
        }

    }
}