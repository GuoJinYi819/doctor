package com.wd.doctor.mvp.checkcode

import com.wd.doctor.bean.MessageBean
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/20 0020 17:29
 * @Description: 用途：完成特定功能
 */
class CheckCodeModule:ICheckCodeContract.IModule {

    override fun checkCode(email: String, code: String, callback: ICheckCodeContract.IModule.ModuleCallBack) {
        val retrofitUtil = RetrofitUtil.getUtil()
        val apiService = retrofitUtil.createService()
        apiService?.let {
            val observable = it.checkCode(PathUtil.checkCode(), email, code)
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :DisposableObserver<MessageBean>(){
                    override fun onComplete() {

                    }

                    override fun onNext(value: MessageBean?) {
                        callback.onCheckSuccess(value!!)
                    }

                    override fun onError(e: Throwable?) {
                        callback.onCheckFailed(e?.message!!)
                    }

                })
        }
    }
}