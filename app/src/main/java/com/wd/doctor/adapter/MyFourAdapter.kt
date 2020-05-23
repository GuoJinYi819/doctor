package com.wd.doctor.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.wd.doctor.R
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
        arr.add("历史文正")
        arr.add("我的钱包")
        arr.add("被采纳建议")
        arr.add("设置自动回复")
        img.add(R.mipmap.my_icon_historical_inquiry_n)
        img.add(R.mipmap.my_icon_wallet_n)
        img.add(R.mipmap.my_icon_recommendations_adopted_n)
        img.add(R.mipmap.my_icon_automatic_response_n)

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
        val a = arr.get(position)
        val i = img.get(position)
        val myMessageItemView = MyMessageItemView(context)
        myMessageItemView.setView(a,i)
        return myMessageItemView
    }
}