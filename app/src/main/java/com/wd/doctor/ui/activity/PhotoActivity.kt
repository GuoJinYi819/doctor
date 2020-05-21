package com.wd.doctor.ui.activity

import android.content.Intent
import android.os.Message
import android.provider.MediaStore
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import com.stx.xhb.xbanner.XBanner
import com.stx.xhb.xbanner.transformers.Transformer
import com.wd.doctor.App
import com.wd.doctor.App.Companion.context
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
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.find
import java.io.File
import kotlin.math.abs

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 7:42
 * @Description: 用途：证件照
 */
class PhotoActivity:BaseActivity() {

    val view = View.inflate(App.context, R.layout.view_popwindow, null)

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
                if(position==2) {
                    val intent =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivityForResult(intent, 0)
                }
            }

        })


        btnOk.setOnClickListener {
            startActivityFinish<HomePagerActivity>()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data!=null){
            val uri = data.data
            var arr:String = MediaStore.Images.Media.DATA
            val arrayOf = arrayOf(arr)
            val cursor = managedQuery(uri, arrayOf, null, null, null)
            val indexOrThrow = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor.moveToFirst()
            val s = cursor.getString(indexOrThrow)
            val f = File(s)
            val absolutePath = f.absolutePath
            var file = File(absolutePath)
            val util = RetrofitUtil.getUtil()
            val apiService = util.createService()
            val body = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), file)
            val part = MultipartBody.Part.createFormData("imagePic", file.getName(), body)
            apiService?.let {
                val observable = it.uploadImagePic(PathUtil.uploadImagePic(), part)
                observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object :DisposableObserver<MessageBean>(){
                        override fun onComplete() {

                        }

                        override fun onNext(value: MessageBean?) {
                            println(value?.message)
                            if(value?.message?.contains("成功")!!){
                                startActivityFinish<HomePagerActivity>()
                            }
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

