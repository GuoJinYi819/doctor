package com.wd.doctor.mvp.pushmessage

import com.wd.doctor.bean.PublicListBean
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.Android

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/28 0028 14:38
 * @Description: 用途：完成特定功能
 */
class PushMessageModel:IPushMessaveContract.IModule {
    override fun pushMessage(params: Map<String, String>, callback: IPushMessaveContract.IModule.ModelCallBack) {
        val retrofitUtil = RetrofitUtil.getUtil()
        val apiService = retrofitUtil.createService()
        apiService?.let {
            val observable = it.pushMessage(PathUtil.pushMessage(), params)
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :DisposableObserver<PublicListBean>(){
                    override fun onComplete() {

                    }

                    override fun onNext(value: PublicListBean?) {
                        callback.onPushSuccess(value!!)
                    }

                    override fun onError(e: Throwable?) {
                        callback.onPushFailed(e?.message!!)
                    }

                })
        }
    }
}