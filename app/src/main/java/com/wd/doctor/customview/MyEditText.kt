package com.wd.doctor.customview

import android.content.Context
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.wd.doctor.R
import org.jetbrains.anko.find
import org.w3c.dom.Text

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 16:03
 * @Description: 用途：完成特定功能
 */
class MyEditText :LinearLayout{
    var editText:EditText? = null
    var eye:ImageView? = null
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.view_edit, this)
        val tvTitle = view.find<TextView>(R.id.tvTitle)
        editText = view.find<EditText>(R.id.editText)
        eye = view.find<ImageView>(R.id.iv_eye)
    }

    //设置密码
    fun setPassword(help:Boolean){
        if(help){
            editText?.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }else{
            editText?.transformationMethod = HideReturnsTransformationMethod.getInstance();
        }
    }
    //设置小眼睛
    public fun setEye(help:Boolean){
        if(help){
            eye?.visibility = View.VISIBLE
        }else{
            eye?.visibility = View.GONE
        }
    }
}