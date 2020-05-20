package com.wd.doctor.mvp.login

import com.wd.doctor.bean.LoginBean
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/20 0020 15:18
 * @Description: 用途：完成特定功能
 */
class LoginModel:ILoginContract.IModule {
    override fun login(params: Map<String, String>, callBack: ILoginContract.IModule.ModuleCallBack) {
        val retrofitUtil = RetrofitUtil.getUtil()
        val apiService = retrofitUtil.createService()
        apiService?.let {
            val observable = it.login(PathUtil.login(), params)
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :DisposableObserver<LoginBean>(){
                    override fun onComplete() {

                    }

                    override fun onNext(value: LoginBean?) {
                        callBack.onLoginSuccess(value!!)
                    }

                    override fun onError(e: Throwable?) {
                        callBack.onLoginFailed(e?.message!!)
                    }

                })
        }
    }
}