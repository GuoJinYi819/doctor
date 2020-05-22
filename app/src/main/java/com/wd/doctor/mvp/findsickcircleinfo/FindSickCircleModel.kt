package com.wd.doctor.mvp.findsickcircleinfo

import com.wd.doctor.bean.PublicBean
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.Android

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 8:15
 * @Description: 用途：完成特定功能
 */
class FindSickCircleModel:IFindSickCircleInfoContract.IModel {
    override fun getSickCircleData(
        sickCircleId: Int,
        callback: IFindSickCircleInfoContract.IModel.ModuleCallBack
    ) {
        val retrofitUtil = RetrofitUtil.getUtil()
        val apiService = retrofitUtil.createService()
        apiService?.let {
            val observable = it.findSickCircleInfo(PathUtil.findSickCircleInfo(), sickCircleId)
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :DisposableObserver<PublicBean>(){
                    override fun onComplete() {

                    }

                    override fun onNext(value: PublicBean?) {
                        callback.onSickCircleSuccess(value!!)
                    }

                    override fun onError(e: Throwable?) {
                        callback.onSickCircleFailed(e?.message!!)
                    }

                })
        }
    }
}