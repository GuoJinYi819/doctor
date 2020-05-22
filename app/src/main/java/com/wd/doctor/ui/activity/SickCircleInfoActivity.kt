package com.wd.doctor.ui.activity

import android.text.TextUtils
import android.view.View
import com.bumptech.glide.Glide
import com.wd.doctor.App
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.PublicBean
import com.wd.doctor.mvp.findsickcircleinfo.FindSickCirclePresenter
import com.wd.doctor.mvp.findsickcircleinfo.IFindSickCircleInfoContract
import kotlinx.android.synthetic.main.activity_sick_circleinfo.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 8:01
 * @Description: 用途：病友圈详情  +回复
 */
class SickCircleInfoActivity :BaseActivity(), IFindSickCircleInfoContract.IView {
    //详情数据
    val presentr by lazy { FindSickCirclePresenter(this) }
    override fun initLayoutId(): Int {
        return R.layout.activity_sick_circleinfo
    }

    override fun initLintener() {
        ttt.setOnClickListener {
            rrr.visibility = View.GONE
        }
        ivBack.setOnClickListener {
            finish()
        }
    }

    override fun initData() {
        val sickCircleId = intent.getIntExtra("sickCircleId", -1)
        if(sickCircleId!=-1){
            //请求详情数据
            presentr.getSickCircleData(sickCircleId)
        }

    }

    //详情数据
    override fun onSickCircleSuccess(bean: PublicBean) {
       //显示数据
        initView(bean)
    }

    override fun onSickCircleFailed(error: String) {
    }


    private fun initView(bean: PublicBean) {
        val result = bean.result
        result?.let {
            //设置 []内显示的数据
            myText_1.tv?.text = "病症"
            myText_1.tvText?.text = result.disease
            myText_2.tv?.text = "科室"
            myText_2.tvText?.text = result.departmentName
            myText_3.tv?.text = "病症详情"
            myText_3.tvText?.text = result.detail
            //医院
            tvTreatmentHospital.text = result.treatmentHospital
            //治愈那个时间
            //tvTime-------bug暂未解决
            //治疗经历
            tvTreatmentProcess.text = result.treatmentProcess
            //相关图片
            val picture = result.picture
            if (!TextUtils.isEmpty(picture)) {
                Glide.with(App.context!!).load(picture).into(ivImg)
            }else{
                ivImg.visibility = View.GONE
                tvImag.visibility = View.GONE
            }
        }


    }

    override fun finish() {
        super.finish()

    }
}