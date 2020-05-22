package com.wd.doctor.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.bean.PublicBean
import com.wd.doctor.itemview.MyAskItemView

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 16:39
 * @Description: 用途：完成特定功能
 */
class AskAdapter:RecyclerView.Adapter<AskAdapter.MyAskHolder>() {
    var list = ArrayList<PublicBean.ResultBean>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAskHolder {
        return MyAskHolder(MyAskItemView(parent.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyAskHolder, position: Int) {

    }




    class MyAskHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

    }
}