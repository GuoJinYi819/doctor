package com.wd.doctor.mvp.sendemailcode

import com.wd.doctor.bean.MessageBean
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.Android

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/19 0019 8:19
 * @Description: 用途：完成特定功能
 */
class SendEmilModel:ISendEmailContract.IModel {
    override fun sendEmailCode(email: String, callBack: ISendEmailContract.IModel.ModuleCallBack) {
        val retrofitUtil = RetrofitUtil.getUtil()
        val apiService = retrofitUtil.createService()
        apiService?.let {
            val observable = it.sendEmailCode(PathUtil.sendEmailCode(), email)
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :DisposableObserver<MessageBean>(){
                    override fun onComplete() {

                    }

                    override fun onNext(value: MessageBean?) {
                        callBack.onSendEmailSuccess(value!!)
                    }

                    override fun onError(e: Throwable?) {
                        callBack.onSendEmailFailed(e?.message!!)
                    }

                })
        }
    }
}