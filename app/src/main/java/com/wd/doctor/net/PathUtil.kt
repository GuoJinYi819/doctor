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
}