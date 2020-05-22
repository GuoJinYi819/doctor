package com.wd.doctor.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.R
import com.wd.doctor.bean.SickCircleListBean
import com.wd.doctor.itemview.MyDetailsItemView
import com.wd.doctor.ui.activity.SickCircleInfoActivity

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 19:12
 * @Description: 用途：详情列表
 */
class DetailsListAdapter(var context:Context) : RecyclerView.Adapter<DetailsListAdapter.MyDetailsHolder>() {
   var list = ArrayList<SickCircleListBean.ResultBean>()

    fun setData(list: List<SickCircleListBean.ResultBean>){
        this.list.clear()
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
        itemView.setOnClickListener {
            //跳转页面
            val sickCircleId = resultBean.sickCircleId
            val intent = Intent(context, SickCircleInfoActivity::class.java)
            intent.putExtra("sickCircleId",sickCircleId)
            context.startActivity(intent)
        }

    }

    fun addData(result: List<SickCircleListBean.ResultBean>) {
        if(result.size>0){
            list.addAll(result)

        }
        notifyDataSetChanged()
    }


    class MyDetailsHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

    }
}