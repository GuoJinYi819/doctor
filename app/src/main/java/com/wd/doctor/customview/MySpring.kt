package com.wd.doctor.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.wd.doctor.R
import org.jetbrains.anko.find
import org.jetbrains.anko.sp

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 17:36
 * @Description: 用途：完成特定功能
 */
class MySpring:LinearLayout {

    var spinner: Spinner? = null
    var tvText:TextView? = null
    var tvTitle:TextView? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.view_spring, this)
        tvTitle = view.find<TextView>(R.id.tvTitle)
        spinner = view.find<Spinner>(R.id.spinner)
        tvText = view.find<TextView>(R.id.tvText)
    }

    //设置二级列表数据
    fun setData(list: ArrayList<String>) {
       list?.let {
           //设置适配器
           val adapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, list)
           //设置下拉列表菜单样式
           adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
           spinner?.adapter = adapter
           spinner?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
               override fun onNothingSelected(parent: AdapterView<*>?) {

               }

               override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                   val text = adapter.getItem(position)
                   tvText?.text = text
               }

           }
       }

    }

}

