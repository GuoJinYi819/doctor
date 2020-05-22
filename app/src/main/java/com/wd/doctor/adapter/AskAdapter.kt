package com.wd.doctor.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.bean.PublicBean
import com.wd.doctor.bean.PublicListBean
import com.wd.doctor.itemview.MyAskItemView

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 16:39
 * @Description: 用途：完成特定功能
 */
class AskAdapter(var context:Context):RecyclerView.Adapter<AskAdapter.MyAskHolder>() {
    var list = ArrayList<PublicListBean.ResultBean>()

    fun setData(result: List<PublicListBean.ResultBean>) {
        this.list.addAll(result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAskHolder {
        return MyAskHolder(MyAskItemView(parent.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyAskHolder, position: Int) {
        val resultBean = list.get(position)
        var itemView = holder.itemView as MyAskItemView
        itemView.setView(resultBean)

        itemView.setOnClickListener {
            Toast.makeText(context,"开发中……",Toast.LENGTH_SHORT).show()
        }


    }




    class MyAskHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

    }
}