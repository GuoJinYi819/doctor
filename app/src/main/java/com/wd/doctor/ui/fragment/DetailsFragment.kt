package com.wd.doctor.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener
import com.wd.doctor.App
import com.wd.doctor.R
import com.wd.doctor.adapter.DetailsListAdapter
import com.wd.doctor.base.BaseFragment
import com.wd.doctor.bean.SickCircleListBean
import com.wd.doctor.mvp.findsickcirclelist.FindSickCirclePresenter
import com.wd.doctor.mvp.findsickcirclelist.IFindSickCircleListContract
import kotlinx.android.synthetic.main.fragment_details.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 17:54
 * @Description: 用途：完成特定功能
 */
class DetailsFragment:BaseFragment(), IFindSickCircleListContract.IView {
    val presenter by lazy { FindSickCirclePresenter(this) }
    val adapter by lazy { DetailsListAdapter(context!!) }
    var help:Int = 1
    var a:Int =0
    override fun initView(): View? {
        val view = View.inflate(context, R.layout.fragment_details, null)
        return view
    }

    override fun initListener() {
        pullToRefreshLayout.setRefreshListener(object :BaseRefreshListener{
            override fun loadMore() {
                //加载
                val departmentId = arguments?.getInt("departmentId")
                val hashMap = HashMap<String,String>()
                hashMap.put("departmentId",departmentId.toString())
                help++
                hashMap.put("page","${help}")
                hashMap.put("count","5")
                a = 2
                presenter.getSickCircleData(hashMap)

                pullToRefreshLayout.finishLoadMore()
            }

            override fun refresh() {
                //刷新
                val departmentId = arguments?.getInt("departmentId")
                val hashMap = HashMap<String,String>()
                hashMap.put("departmentId",departmentId.toString())
                hashMap.put("page","1")
                hashMap.put("count","5")
                a = 1
                presenter.getSickCircleData(hashMap)
                pullToRefreshLayout.finishRefresh()
            }

        })
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
    }
    override fun initData() {
        val departmentId = arguments?.getInt("departmentId")
        //获取病友圈列表展示
        val hashMap = HashMap<String,String>()
        hashMap.put("departmentId",departmentId.toString())
        hashMap.put("page","1")
        hashMap.put("count","5")
        a=1
        presenter.getSickCircleData(hashMap)
        //设置布局管理器
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }
    //获取病友圈列表展示
    override fun onSickCircleSuccess(bean: SickCircleListBean) {
        if(a==1){
            adapter.setData(bean.result!!)
        }else if (a==2){
            if(bean.result!!.size>0){
                adapter.addData(bean.result!!)
            }else{
                myToast("暂无更多数据")
            }

        }
    }

    override fun onSickCircleFailed(error: String) {

    }

}