package com.wd.doctor.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import com.wd.doctor.R

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 8:01
 * @Description: 用途：完成特定功能
 */
class LabelView:RelativeLayout {
    var tvTitle:TextView? = null
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.view_label, this)
        tvTitle = view.findViewById<TextView>(R.id.tvTitle)

    }
    //设置字体
    fun text(msg:String){
        tvTitle?.text = msg
    }
}