package com.wd.doctor.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.R
import com.wd.doctor.bean.PublicBean
import com.wd.doctor.bean.PublicListBean
import com.wd.doctor.itemview.MyAskItemView
import com.wd.doctor.ui.activity.ContentActivity
import org.jetbrains.anko.startActivity

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
        if(viewType==100){
            val inflate = LayoutInflater.from(context).inflate(R.layout.item_null, parent, false)
            return MyAskHolder(inflate)
        }else{
            return MyAskHolder(MyAskItemView(parent.context))
        }
    }

    override fun getItemCount(): Int {
        return list.size+1
    }

    override fun getItemViewType(position: Int): Int {
        if(position == list.size){
            return 100
        }else{
            return 0
        }
    }


    override fun onBindViewHolder(holder: MyAskHolder, position: Int) {
        if(position==list.size){
            if(list.size==0){
                holder.itemView.visibility = View.VISIBLE
            }else{
                holder.itemView.visibility = View.GONE
            }
            return
        }
        val resultBean = list.get(position)
        var itemView = holder.itemView as MyAskItemView
        itemView.setView(resultBean)

        itemView.setOnClickListener {
            val nickName = resultBean.nickName
            val intent = Intent(context, ContentActivity::class.java)
            intent.putExtra("name",nickName)
            context.startActivity(intent)
        }


    }




    class MyAskHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

    }
}