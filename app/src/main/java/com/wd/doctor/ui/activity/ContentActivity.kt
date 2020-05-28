package com.wd.doctor.ui.activity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.R
import com.wd.doctor.adapter.ContentAdapter
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.PublicListBean
import com.wd.doctor.mvp.InquiryDetailsList.InquiryDetailsListContract
import com.wd.doctor.mvp.InquiryDetailsList.InquiryDetailsListPresenter
import com.wd.doctor.mvp.pushmessage.IPushMessaveContract
import com.wd.doctor.mvp.pushmessage.PushMessagePresenter
import kotlinx.android.synthetic.main.activity_content.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.coroutines.Continuation

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/26 0026 14:52
 * @Description: 用途：聊天界面
 */
class ContentActivity:BaseActivity(), InquiryDetailsListContract.IView, IPushMessaveContract.IView {

    //适配器
    val adapter by lazy { ContentAdapter(this) }

    //获取聊天数据
    val presenter by lazy { InquiryDetailsListPresenter(this) }

    //发送消息
    val pushPresenter by lazy { PushMessagePresenter(this) }
    override fun initLayoutId(): Int {
        return R.layout.activity_content
    }

    override fun initLintener() {
        ivBack.setOnClickListener {
            finish()
        }
        sendMessage.setOnClickListener {
            val map = HashMap<String,String>()
            val intExtra = intent.getIntExtra("userId", -1)
            if(intExtra!=-1){
                map.put("inquiryId",intExtra.toString())
                map.put("userId",intExtra.toString())
            }
            map.put("content","好好好")
            map.put("type","1")
            pushPresenter.pushMessage(map)
        }
    }

    override fun initData() {
        getData()

        //设置布局管理器
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter =adapter
    }

    private fun getData(){
        tvTitle.text = intent.getStringExtra("name")
        //获取聊天数据
        val map = HashMap<String,String>()
        map.put("inquiryId","255")
        map.put("page","1")
        map.put("count","15")
        presenter.getData(map)
    }

    //获取聊天数据
    override fun onSuccess(bean: PublicListBean) {
        val result = bean.result
        //倒叙
        Collections.reverse(result)
        adapter.setData(result as ArrayList<PublicListBean.ResultBean>?)
    }

    override fun onFailed(error: String) {
    }

    //发送消息
    override fun onPushSuccess(bean: PublicListBean) {
        getData()
    }

    override fun onPushFailed(error: String) {
    }

}