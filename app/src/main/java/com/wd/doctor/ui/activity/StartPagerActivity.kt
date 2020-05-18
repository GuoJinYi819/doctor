package com.wd.doctor.ui.activity

import android.animation.Animator
import android.animation.ObjectAnimator
import androidx.core.animation.addListener
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_start_pager.*

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 14:01
 * @Description: 用途：完成特定功能
 */
class StartPagerActivity :BaseActivity(){

    val objectAnimator by lazy { ObjectAnimator.ofFloat(activitybg,"alpha",0f,0.5f,1f) }

    override fun initLayoutId(): Int {
        return R.layout.activity_start_pager
    }

    override fun initLintener() {
        //动画监听
        objectAnimator.addListener(object :Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                //跳转页面
                startActivityFinish<LoginActivity>()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })
    }

    override fun initData() {
        //动画时间
        objectAnimator.duration = 2000
        //启动
        objectAnimator.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (objectAnimator != null) {
            objectAnimator.clone()
        }

    }
}