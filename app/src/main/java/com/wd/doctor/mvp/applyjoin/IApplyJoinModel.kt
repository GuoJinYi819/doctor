package com.wd.doctor.mvp.applyjoin

import com.wd.doctor.bean.MessageBean
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/19 0019 17:19
 * @Description: 用途：完成特定功能
 */
class IApplyJoinModel:IApplyJoinContract.IModel {
    override fun applyJoin(params: Map<String, String>, callBack: IApplyJoinContract.IModel.ModuleCallBack) {
//        val retrofitUtil = RetrofitUtil.getUtil()
//        val apiService = retrofitUtil.createService()
//        apiService?.let {
//            val observable = it.applyJoin(PathUtil.applyJoin(), params)
//            observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object :DisposableObserver<MessageBean>(){
//                    override fun onComplete() {
//
//                    }
//
//                    override fun onNext(value: MessageBean?) {
//                        callBack.onSuccess(value!!)
//                    }
//
//                    override fun onError(e: Throwable?) {
//                        callBack.onFailed(e?.message!!)
//                    }
//
//                })
//        }
    }
}