package com.wd.doctor.bean

import java.io.Serializable

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 15:02
 * @Description: 用途：完成特定功能
 */
class LoginBean:Serializable{
    var message:String? = null
    var status:String? = null
    var result:ResultBean? = null

    class ResultBean:Serializable{
        var departmentId:Int? = 0
        var departmentName:String? = null
        var id:Int? = 0
        var inauguralHospital:String? = null
        var jiGuangPwd:String? = null
        var jobTitle:String? = null
        var name:String? = null
        var reviewStatus:Int = 0
        var sessionId:String? = null
        var userName:String? = null
        var whetherHaveImagePic:Int = 0
        var imagePic:String? = null
        var personalProfile:String? = null
        var goodField:String? = null

    }
}