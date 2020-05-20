package com.wd.doctor.bean

import java.io.Serializable

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/20 0020 8:09
 * @Description: 用途：完成特定功能
 */
class ApplyJoinBean:Serializable {
    var email = "email" // 邮箱
    var code = "code" //验证码
    var pwd1 = "pwd1" //用户密码1
    var pwd2 = "pwd2" //用户密码2
    var name = "name" //姓名
    var inauguralHospital = "inauguralHospital" //就职医院
    var departmentId = 0 //科室id
    var jobTitleId = 0 //职称id
    var personalProfile = "personalProfile" //个人简介
    var goodField = "goodField" //擅长领域

}