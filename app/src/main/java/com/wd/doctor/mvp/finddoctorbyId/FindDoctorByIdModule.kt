package com.wd.doctor.mvp.finddoctorbyId

import com.wd.doctor.bean.LoginBean
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 16:32
 * @Description: 用途：完成特定功能
 */
class FindDoctorByIdModule:IFindDoctorByIdContract.IModule {
    override fun getMessage(callBack: IFindDoctorByIdContract.IModule.ModuleCallBack) {
        val retrofitUtil = RetrofitUtil.getUtil()
        val apiService = retrofitUtil.createService()
        apiService?.let {
            val observable = it.findDoctorById(PathUtil.findDoctorById())
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :DisposableObserver<LoginBean>(){
                    override fun onComplete() {

                    }

                    override fun onNext(value: LoginBean?) {
                        callBack.onFindDoctorSuccess(value!!)
                    }

                    override fun onError(e: Throwable?) {
                        callBack.onFindDoctorFailed(e?.message!!)
                    }


                })
        }
    }
}