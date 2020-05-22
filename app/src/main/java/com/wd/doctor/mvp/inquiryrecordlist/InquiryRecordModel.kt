package com.wd.doctor.mvp.inquiryrecordlist

import com.wd.doctor.bean.PublicBean
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 15:21
 * @Description: 用途：完成特定功能
 */
class InquiryRecordModel:IInquiryRecordListContract.IModel {

    override fun getInquiryRecordList(callback: IInquiryRecordListContract.IModel.ModelCallBack) {
        val retrofitUtil = RetrofitUtil.getUtil()
        val apiService = retrofitUtil.createService()
        apiService?.let {
            val observable = it.getInquiryRecordList(PathUtil.getInquiryRecordList())
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :DisposableObserver<PublicBean>(){
                    override fun onComplete() {

                    }

                    override fun onNext(value: PublicBean?) {
                        callback.onInquiryRecordSuccess(value!!)
                    }

                    override fun onError(e: Throwable?) {
                        callback.onInquiryRecordFailed(e?.message!!)
                    }

                })
        }
    }
}