package com.wd.doctor.itemview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import com.wd.doctor.R
import com.wd.doctor.bean.SickCircleListBean
import com.wd.doctor.utils.TimeUtil

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 19:15
 * @Description: 用途：完成特定功能
 */
class MyDetailsItemView:RelativeLayout {

    var tvTitle:TextView? = null
    var tvDetail:TextView? = null
    var tvReleaseTime:TextView? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.item_mydetails_view, this)
        tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        tvDetail = view.findViewById<TextView>(R.id.tvDetail)
        tvReleaseTime = view.findViewById<TextView>(R.id.tvReleaseTime)
    }
    //设置显示数据
    fun setView(resultBean: SickCircleListBean.ResultBean) {
        val title = resultBean.title
        tvTitle?.text = title

        val detail = resultBean.detail
        tvDetail?.text = detail

        val releaseTime = resultBean.releaseTime
        tvReleaseTime?.text = TimeUtil.time(releaseTime.toString()!!)
    }
}