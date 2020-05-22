package com.wd.doctor.ui.activity

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
    }

    override fun initData() {
        val sickCircleId = intent.getIntExtra("sickCircleId", -1)
        if(sickCircleId!=-1){
            ttt.text = sickCircleId.toString()
            //请求详情数据
            presentr.getSickCircleData(sickCircleId)
        }
    }
    //详情数据
    override fun onSickCircleSuccess(bean: PublicBean) {
        println(bean.toString())
    }

    override fun onSickCircleFailed(error: String) {
    }

}