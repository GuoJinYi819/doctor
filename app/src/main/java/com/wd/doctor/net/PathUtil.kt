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
    //重置密码
    fun resetUserPwd():String{
        var path = "http://mobile.bwstudent.com/health/doctor/v1/resetUserPwd"
        return path
    }
    //上传形象照
    fun uploadImagePic():String{
        var path = "http://mobile.bwstudent.com/health/doctor/verify/v1/uploadImagePic"
        return path
    }
    //查询医生信息
    fun findDoctorById():String{
        var path = "http://mobile.bwstudent.com/health/doctor/verify/v1/findDoctorById"
        return path
    }
    //病友圈相关接口
    fun findSickCircleList():String{
        var path = "http://mobile.bwstudent.com/health/doctor/sickCircle/v1/findSickCircleList"
        return path
    }
    //病友圈详情
    fun findSickCircleInfo():String{
        var path = "http://mobile.bwstudent.com/health/doctor/sickCircle/v1/findSickCircleInfo"
        return path
    }
    //查询医生的问诊记录列表
    fun getInquiryRecordList():String{
        var path = "http://mobile.bwstudent.com/health/doctor/inquiry/verify/v1/findInquiryRecordList"
        return path
    }
}