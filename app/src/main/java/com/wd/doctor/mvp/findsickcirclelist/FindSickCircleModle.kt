package com.wd.doctor.mvp.findsickcirclelist

import com.wd.doctor.bean.SickCircleListBean
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 18:30
 * @Description: 用途：完成特定功能
 */
class FindSickCircleModle:IFindSickCircleListContract.IModel {
    override fun getSickCircleData(
        params: Map<String, String>,
        callback: IFindSickCircleListContract.IModel.ModuleCallBack
    ) {
        val retrofitUtil = RetrofitUtil.getUtil()
        val apiService = retrofitUtil.createService()
        apiService?.let {
            val observable = it.findSickCircleList(PathUtil.findSickCircleList(), params)
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :DisposableObserver<SickCircleListBean>(){
                    override fun onComplete() {

                    }

                    override fun onNext(value: SickCircleListBean?) {
                        callback.onSickCircleSuccess(value!!)
                    }

                    override fun onError(e: Throwable?) {
                        callback.onSickCircleFailed(e?.message!!)
                    }

                })
        }
    }
}