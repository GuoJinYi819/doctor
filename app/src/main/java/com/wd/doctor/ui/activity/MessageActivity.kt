package com.wd.doctor.ui.activity

import android.graphics.drawable.GradientDrawable
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.google.gson.Gson
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.ApplyJoinBean
import com.wd.doctor.bean.MessageBean
import com.wd.doctor.mvp.applyjoin.IApplyJoinContract
import com.wd.doctor.mvp.applyjoin.IApplyJoinPresenter
import com.wd.doctor.net.PathUtil
import com.wd.doctor.net.RetrofitUtil
import com.wd.doctor.utils.SpKey
import com.wd.doctor.utils.SpUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_message.*
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.jetbrains.anko.backgroundDrawable
import org.jetbrains.anko.sp
import java.nio.file.Path

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/19 0019 15:22
 * @Description: 用途：完成特定功能
 */
class MessageActivity:BaseActivity(), IApplyJoinContract.IView {

    override fun initLayoutId(): Int {
        return R.layout.activity_message
    }

    override fun initLintener() {
        editPersonalProfile.setOnFocusChangeListener(object :View.OnFocusChangeListener{
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if(hasFocus){
                    jj.setBackgroundResource(R.drawable.relative_true)
                }else{
                    jj.setBackgroundResource(R.drawable.relative_false)
                }
            }

        })
        editGoodField.setOnFocusChangeListener(object :View.OnFocusChangeListener{
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if(hasFocus){
                    ly.setBackgroundResource(R.drawable.relative_true)
                }else{
                    ly.setBackgroundResource(R.drawable.relative_false)
                }
            }

        })
        editPersonalProfile.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val length = editPersonalProfile.text.length
                tvValue.text = "${length}/200"
            }

        })
        tvNext.setOnClickListener {
            val editPersonalProfile = editPersonalProfile.text.toString()
            val editGoodField = editGoodField.text.toString()

            val spUtil = SpUtil.getSpUtil()
            spUtil.putString(SpKey.PERSONALPROFILE, editPersonalProfile)
            spUtil.putString(SpKey.GOODFIELD, editGoodField)


            //发起请求
//            var hashMap = HashMap<String,String>()
//            val spUtil1 = SpUtil.getSpUtil()
//
//            hashMap.put(SpKey.EMAIL,spUtil.getString(SpKey.EMAIL)!!)
//            hashMap.put(SpKey.CODE,spUtil.getString(SpKey.CODE)!!)
//            hashMap.put(SpKey.PWD1,spUtil.getString(SpKey.PWD1)!!)
//            hashMap.put(SpKey.PWD2,spUtil.getString(SpKey.PWD2)!!)
//            hashMap.put(SpKey.NAME,spUtil.getString(SpKey.NAME)!!)
//            println(spUtil.getString(SpKey.NAME))
//            hashMap.put(SpKey.INAUGURALHOSPITAL,spUtil.getString(SpKey.INAUGURALHOSPITAL)!!)
//            hashMap.put(SpKey.DEPARTMENTID,spUtil.getInt(SpKey.DEPARTMENTID).toString())
//            hashMap.put(SpKey.JOBTITLEID,spUtil.getInt(SpKey.JOBTITLEID).toString())
//            hashMap.put(SpKey.PERSONALPROFILE,spUtil.getString(SpKey.PERSONALPROFILE)!!)
//            hashMap.put(SpKey.GOODFIELD,spUtil.getString(SpKey.GOODFIELD)!!)

//            val presenter = IApplyJoinPresenter(this)
//            presenter.applyJoin(hashMap)


//            val spUtil1 = SpUtil.getSpUtil()
//
//            val applyJoinBean = ApplyJoinBean()
//            applyJoinBean.email = spUtil1.getString(SpKey.EMAIL)!!
//            applyJoinBean.code = spUtil1.getString(SpKey.CODE)!!
//            applyJoinBean.pwd1 = spUtil1.getString(SpKey.PWD1)!!
//            applyJoinBean.pwd2 = spUtil1.getString(SpKey.PWD2)!!
//            applyJoinBean.name = spUtil1.getString(SpKey.NAME)!!
//            applyJoinBean.inauguralHospital = spUtil1.getString(SpKey.INAUGURALHOSPITAL)!!
//            applyJoinBean.departmentId = spUtil1.getInt(SpKey.DEPARTMENTID)!!
//            applyJoinBean.jobTitleId = spUtil1.getInt(SpKey.JOBTITLEID)!!
//            applyJoinBean.personalProfile = spUtil1.getString(SpKey.PERSONALPROFILE)!!
//            applyJoinBean.goodField = spUtil1.getString(SpKey.GOODFIELD)!!


            startActivityFinish<SettleOrverActivity>()
            overridePendingTransition(R.anim.zoomin, R.anim.zoomout)
        }
    }

    override fun initData() {


    }

    override fun onSuccess(bean: MessageBean) {
        myToast(bean.message)
    }

    override fun onFailed(error: String) {
        println(error)
    }


}

