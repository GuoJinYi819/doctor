package com.wd.doctor.ui.activity

import android.os.Message
import android.view.View
import android.widget.ImageView
import com.stx.xhb.xbanner.XBanner
import com.stx.xhb.xbanner.transformers.Transformer
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.ImageBean
import com.wd.doctor.bean.MessageBean
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_photo.*
import java.io.File

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 7:42
 * @Description: 用途：证件照
 */
class PhotoActivity:BaseActivity() {


    override fun initLayoutId(): Int {
        return R.layout.activity_photo
    }

    override fun initLintener() {
        tvBack.setOnClickListener {
            startActivityFinish<HomePagerActivity>()
        }
        //xbanner监听事件
        xbanner.setOnItemClickListener(object :XBanner.OnItemClickListener{
            override fun onItemClick(banner: XBanner?, model: Any?, view: View?, position: Int) {

            }

        })
        btnOk.setOnClickListener {
            val file = File("D:\\WorkSpaces\\Train\\Doctor\\app\\src\\main\\res\\mipmap-xhdpi\\t1.png")
            val util = RetrofitUtil.getUtil()
            val observable =
                util.createService()?.uploadImagePic(PathUtil.uploadImagePic(), file)
            observable?.let {
                it.subscribeOn(Schedulers.io())
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(object :DisposableObserver<MessageBean>(){
                        override fun onComplete() {

                        }

                        override fun onNext(value: MessageBean?) {
                            println(value?.message)
                        }

                        override fun onError(e: Throwable?) {
                            println(e?.message)
                        }

                    })
            }
        }
    }

    override fun initData() {
        //设置数据
        var list = ArrayList<ImageBean>()
        list.add(ImageBean(R.mipmap.t3))
        list.add(ImageBean(R.mipmap.t1))
        list.add(ImageBean(R.mipmap.t2))

        xbanner.setBannerData(list)
        xbanner.setAutoPlayAble(false)

        xbanner.setPageTransformer(Transformer.Scale)
        xbanner.loadImage(object :XBanner.XBannerAdapter{
            override fun loadBanner(banner: XBanner?, model: Any?, view: View?, position: Int) {
                //加载图片
                var img = view as ImageView
                img.setBackgroundResource(list.get(position).img)
            }

        })

    }
}

