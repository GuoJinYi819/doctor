package com.wd.doctor.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import com.wd.doctor.R

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 13:59
 * @Description: 用途：完成特定功能
 */
class MyTextContent:RelativeLayout {
    var tv:TextView? = null
    var tvText:TextView? = null
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.view_mytext_content, this)
        tv = view.findViewById<TextView>(R.id.tv)
        tvText = view.findViewById<TextView>(R.id.tvText)
    }
    fun tv(msg:String){
        tv?.text = msg
    }
    fun tvText(msg:String){
        tvText?.text = msg
    }
}