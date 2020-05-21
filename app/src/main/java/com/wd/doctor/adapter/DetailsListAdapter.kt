package com.wd.doctor.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.bean.SickCircleListBean
import com.wd.doctor.itemview.MyDetailsItemView

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 19:12
 * @Description: 用途：详情列表
 */
class DetailsListAdapter : RecyclerView.Adapter<DetailsListAdapter.MyDetailsHolder>() {
   var list = ArrayList<SickCircleListBean.ResultBean>()
    fun setData(list: List<SickCircleListBean.ResultBean>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDetailsHolder {
        return MyDetailsHolder(MyDetailsItemView(parent.context))
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: MyDetailsHolder, position: Int) {
        val resultBean = list.get(position)
        var itemView = holder.itemView as MyDetailsItemView
        itemView.setView(resultBean)

    }




    class MyDetailsHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

    }
}