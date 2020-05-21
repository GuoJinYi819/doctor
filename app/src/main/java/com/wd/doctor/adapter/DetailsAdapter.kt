package com.wd.doctor.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wd.doctor.base.BaseFragment
import com.wd.doctor.bean.DepartmentBean
import com.wd.doctor.ui.fragment.DetailsFragment

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 17:57
 * @Description: 用途：详情页  viewpager+tablayout
 */
class DetailsAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    private var list = ArrayList<BaseFragment>()
    private val arr = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return list.get(position)
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return arr.get(position)
    }

    fun setData(result:ArrayList<DepartmentBean.ResultBean>) {
        result.forEach {
            val detailsFragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putInt("departmentId",it.id!!)
            detailsFragment.arguments = bundle
            list.add(detailsFragment)
            arr.add(it.departmentName!!)
        }
    }
}