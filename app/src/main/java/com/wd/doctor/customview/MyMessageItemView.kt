package com.wd.doctor.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.wd.doctor.R

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 17:55
 * @Description: 用途：完成特定功能
 */
class MyMessageItemView:RelativeLayout {

    var img:ImageView? = null
    var tv:TextView? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.itme_mymessage, this)
        img = view.findViewById(R.id.ivIma)
        tv = view.findViewById(R.id.tvText1)
    }

}