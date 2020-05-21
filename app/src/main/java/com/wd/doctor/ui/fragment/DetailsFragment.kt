package com.wd.doctor.ui.fragment

import android.view.View
import android.widget.TextView
import com.wd.doctor.R
import com.wd.doctor.base.BaseFragment
import com.wd.doctor.bean.SickCircleListBean
import com.wd.doctor.mvp.findsickcirclelist.FindSickCirclePresenter
import com.wd.doctor.mvp.findsickcirclelist.IFindSickCircleListContract
import kotlinx.android.synthetic.main.fragment_details.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 17:54
 * @Description: 用途：完成特定功能
 */
class DetailsFragment:BaseFragment(), IFindSickCircleListContract.IView {

    val presenter by lazy { FindSickCirclePresenter(this) }
    override fun initView(): View? {
        val view = View.inflate(context, R.layout.fragment_details, null)
        return view
    }

    override fun initListener() {
    }

    override fun initData() {
        val departmentId = arguments?.getInt("departmentId")
        ttt.text = departmentId.toString()

        //获取病友圈列表展示
        val hashMap = HashMap<String,String>()
        hashMap.put("departmentId",departmentId.toString())
        hashMap.put("page","1")
        hashMap.put("count","10")
        presenter.getSickCircleData(hashMap)
    }
    //获取病友圈列表展示
    override fun onSickCircleSuccess(bean: SickCircleListBean) {
        println(bean.toString())
    }

    override fun onSickCircleFailed(error: String) {

    }

}