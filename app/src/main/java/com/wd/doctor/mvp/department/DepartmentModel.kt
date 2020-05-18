package com.wd.doctor.mvp.department

import com.wd.doctor.bean.DepartmentBean
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 19:19
 * @Description: 用途：完成特定功能
 */
class DepartmentModel:IDepartmentContract.IModel {
    override fun getDepartmentData(callBack: IDepartmentContract.IModel.IModuleCallBack) {
        val retrofitUtil = RetrofitUtil.getUtil()
        val apiService = retrofitUtil.createService()
        val observable = apiService?.findDepartment(PathUtil.getFindDepartment())
        observable?.let {
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<DepartmentBean>() {
                    override fun onComplete() {
                    }

                    override fun onNext(value: DepartmentBean?) {
                        callBack.onDepartmentSuccess(value!!)
                    }

                    override fun onError(e: Throwable?) {
                        callBack.onFailed(e?.message!!)
                    }

                })
        }
    }
}