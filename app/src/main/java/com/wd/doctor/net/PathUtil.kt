package com.wd.doctor.net

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 19:10
 * @Description: 用途：完成特定功能
 */
object PathUtil {
    //查询科室列表
    fun getFindDepartment():String{
        var path = "http://mobile.bwstudent.com/health/share/knowledgeBase/v1/findDepartment"
        return path
    }
    //查询医生职称列表
    fun getFindJobTitleList():String{
        var path = "http://mobile.bwstudent.com/health/doctor/v1/findJobTitleList"
        return path
    }
    //发送验证码
    fun sendEmailCode():String{
        var path = "http://mobile.bwstudent.com/health/doctor/v1/sendEmailCode"
        return path
    }
    //申请入驻
    fun applyJoin():String{
        var path = "http://mobile.bwstudent.com/health/doctor/v1/applyJoin"
        return path
    }
    //登入
    fun login():String{
        var path = "http://mobile.bwstudent.com/health/doctor/v1/login"
        return path
    }
    //校验验证码
    fun checkCode():String{
        var path = "http://mobile.bwstudent.com/health/doctor/v1/checkCode"
        return path
    }
}