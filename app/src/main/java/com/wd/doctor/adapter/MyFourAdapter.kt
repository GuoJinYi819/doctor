package com.wd.doctor.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.wd.doctor.customview.MyMessageItemView

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 17:54
 * @Description: 用途：完成特定功能
 */
class MyFourAdapter(var context:Context):BaseAdapter() {

    val arr = ArrayList<String>()
    val img = ArrayList<Int>()

    init {

    }

    override fun getItem(position: Int): Any {
        return arr
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return MyMessageItemView(context)
    }
}