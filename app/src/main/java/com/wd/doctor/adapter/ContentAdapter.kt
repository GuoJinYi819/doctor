package com.wd.doctor.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.wd.doctor.R
import com.wd.doctor.bean.PublicListBean
import kotlinx.android.synthetic.main.item_left.view.*
import kotlinx.android.synthetic.main.item_left.view.ivHeadPic
import kotlinx.android.synthetic.main.item_right.view.*
import kotlinx.android.synthetic.main.item_left.view.tvContent as tvContent1

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/27 0027 15:37
 * @Description: 用途：完成特定功能
 */
class ContentAdapter(var context: Context):RecyclerView.Adapter<ContentAdapter.MyContentHolder>() {

    var list = ArrayList<PublicListBean.ResultBean>()
    fun setData(result: ArrayList<PublicListBean.ResultBean>?) {
        list.clear()
        list.addAll(result!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyContentHolder {
        if(viewType == 1){
            val view = LayoutInflater.from(context).inflate(R.layout.item_right, parent, false)
            return MyContentHolder(view)
        }else{
            val view = LayoutInflater.from(context).inflate(R.layout.item_left, parent, false)
            return MyContentHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        val resultBean = list.get(position)
        val direction = resultBean.direction
        if(direction==1){
            //发送者
            return 1
        }else{
            //接收者
            return 0
        }
    }

    override fun onBindViewHolder(holder: MyContentHolder, position: Int) {
        val resultBean = list.get(position)
        val userHeadPic = resultBean.userHeadPic
        val doctorHeadPic = resultBean.doctorHeadPic
        val direction = resultBean.direction
        val content = resultBean.content
        if(direction==1){
            //发送者
            Glide.with(context).load(doctorHeadPic)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .into(holder.itemView.ivHeadPic);
            holder.setContent(content)

        }else{
            //接收者
            Glide.with(context).load(userHeadPic)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .into(holder.itemView.ivHeadPic)

            holder.setContent(content)
        }
    }



    class MyContentHolder(var view:View) :RecyclerView.ViewHolder(view){
        fun setContent(content: String?) {
            view.tvContent.text = content
        }

    }
}