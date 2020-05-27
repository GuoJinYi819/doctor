package com.wd.doctor.mvp.InquiryDetailsList

import com.wd.doctor.bean.PublicBean
import com.wd.doctor.bean.PublicListBean
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.Android

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/27 0027 15:00
 * @Description: 用途：完成特定功能
 */
class InquiryDetailsListModel:InquiryDetailsListContract.IModel {
    override fun getData(params: Map<String, String>, callback: InquiryDetailsListContract.IModel.ModelCallBack) {
        val retrofitUtil = RetrofitUtil.getUtil()
        val apiService = retrofitUtil.createService()
        apiService?.let {
            val observable = it.getInquiryDetailsList(PathUtil.getInquiryDetailsList(), params)
              observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<PublicListBean>() {
                    override fun onComplete() {

                    }

                    override fun onNext(value: PublicListBean?) {
                        callback.onSuccess(value!!)
                    }

                    override fun onError(e: Throwable?) {
                        callback.onFailed(e?.message!!)
                    }

                })
        }
    }
}

