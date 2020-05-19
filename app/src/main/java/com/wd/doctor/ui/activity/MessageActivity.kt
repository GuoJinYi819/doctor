package com.wd.doctor.ui.activity

import android.graphics.drawable.GradientDrawable
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.utils.SpKey
import com.wd.doctor.utils.SpUtil
import kotlinx.android.synthetic.main.activity_message.*
import org.jetbrains.anko.backgroundDrawable
import org.jetbrains.anko.sp

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/19 0019 15:22
 * @Description: 用途：完成特定功能
 */
class MessageActivity:BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_message
    }

    override fun initLintener() {
        editPersonalProfile.setOnFocusChangeListener(object :View.OnFocusChangeListener{
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if(hasFocus){
                    jj.setBackgroundResource(R.drawable.relative_true)
                }else{
                    jj.setBackgroundResource(R.drawable.relative_false)
                }
            }

        })
        editGoodField.setOnFocusChangeListener(object :View.OnFocusChangeListener{
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if(hasFocus){
                    ly.setBackgroundResource(R.drawable.relative_true)
                }else{
                    ly.setBackgroundResource(R.drawable.relative_false)
                }
            }

        })
        editPersonalProfile.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val length = editPersonalProfile.text.length
                tvValue.text = "${length}/200"
            }

        })
        tvNext.setOnClickListener {
            val editPersonalProfile = editPersonalProfile.text.toString()
            val editGoodField = editGoodField.text.toString()

            val spUtil = SpUtil.getSpUtil()
            spUtil.putString(SpKey.PERSONALPROFILE,editPersonalProfile)
            spUtil.putString(SpKey.GOODFIELD,editGoodField)
            startActivityFinish<SettleOrverActivity>()
            overridePendingTransition(R.anim.zoomin,R.anim.zoomout)
        }
    }

    override fun initData() {

    }
}