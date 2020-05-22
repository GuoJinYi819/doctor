package com.wd.doctor.itemview

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.wd.doctor.R
import com.wd.doctor.bean.PublicListBean
import com.wd.doctor.utils.TimeUtil

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 16:25
 * @Description: 用途：完成特定功能
 */
class MyAskItemView:RelativeLayout {


    var ivUserHeadPic:ImageView? = null
    var tvNickName:TextView? = null
    var tvlastContent:TextView? = null
    var tvTime:TextView? = null


    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init {
        val view = LinearLayout.inflate(context, R.layout.item_askview, this)
        ivUserHeadPic = view.findViewById(R.id.ivUserHeadPic)
        tvNickName = view.findViewById(R.id.tvNickName)
        tvlastContent = view.findViewById(R.id.tvlastContent)
        tvTime = view.findViewById(R.id.tvTime)
    }
    //设置显示布局
    fun setView(resultBean: PublicListBean.ResultBean) {
        //展示圆形地图
        val userHeadPic = resultBean.userHeadPic
        Glide.with(context).load(userHeadPic).apply(RequestOptions.bitmapTransform(CircleCrop())).into(ivUserHeadPic!!)
        //姓名
        tvNickName?.text = resultBean.nickName
        //最后一条信息
        tvlastContent?.text = resultBean.lastContent
        //时间
        tvTime?.text = TimeUtil.time(resultBean.inquiryTime.toString())

    }
}