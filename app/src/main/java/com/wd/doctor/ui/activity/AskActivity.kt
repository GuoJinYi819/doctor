package com.wd.doctor.ui.activity

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.content.TextContent
import cn.jpush.im.android.api.enums.ContentType
import cn.jpush.im.android.api.event.MessageEvent
import cn.jpush.im.android.api.model.UserInfo
import com.wd.doctor.R
import com.wd.doctor.adapter.AskAdapter
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.PublicBean
import com.wd.doctor.bean.PublicListBean
import com.wd.doctor.mvp.inquiryrecordlist.IInquiryRecordListContract
import com.wd.doctor.mvp.inquiryrecordlist.InquiryRecordPresenter
import kotlinx.android.synthetic.main.activity_ask.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/22 0022 15:04
 * @Description: 用途：问诊界面
 */
class AskActivity:BaseActivity(), IInquiryRecordListContract.IView {
    val adapter by lazy { AskAdapter(this) }
    val presenter by lazy { InquiryRecordPresenter(this) }

    init {
        //注册极光
        JMessageClient.registerEventReceiver(this)
    }

    override fun initLayoutId(): Int {
        return R.layout.activity_ask
    }

    override fun initLintener() {
        ivBack.setOnClickListener {
            finish()
        }
    }

    override fun initData() {
        //请求问诊列表
        presenter.getInquiryRecordList()
        //设置布局管理器
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    //问诊列表界面
    override fun onInquiryRecordSuccess(bean: PublicListBean) {
        val result = bean.result
        result?.let {
            adapter.setData(it)
        }

    }
    override fun onInquiryRecordFailed(error: String) {
    }

    //接收信息
    fun onEvent(event: MessageEvent) {
        //获取事件发生的会话对象
        val message = event.message//获取此次离线期间会话收到的新消息列表
        when (message.contentType) {
            ContentType.text -> {
                // 处理文字消息
                val userName = (message.targetInfo as UserInfo).userName
                val content = message.content as TextContent
                val text = content.text

                Log.i("消息", "onEvent: $text")
            }
            else -> Log.i("office", message.fromType)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        JMessageClient.unRegisterEventReceiver(this)
    }
}