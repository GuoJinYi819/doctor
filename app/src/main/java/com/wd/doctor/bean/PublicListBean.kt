package com.wd.doctor.bean

import java.io.Serializable

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 15:02
 * @Description: 用途：完成特定功能
 */
class PublicListBean:Serializable{
    var message:String? = null
    var status:String? = null
    var result:List<ResultBean>? = null

    class ResultBean:Serializable{
        var departmentId:Int? = 0
        var departmentName:String? = null
        var id:Int? = 0
        var userId:Int? = 0
        var amount:Int? = 0
        var status:Int? = 0
        var whetherContent:Int? = 0
        var authorName:String? = null
        var content:String? = null
        var userHeadPic:String? = null
        var doctorHeadPic:String? = null
        var lastContent:String? = null
        var nickName:String? = null
        var title:String? = null
        var disease:String? = null
        var detail:String? = null
        var treatmentHospital:String? = null
        var treatmentProcess:String? = null
        var picture:String? = null
        var treatmentStartTime:Long? = 0L
        var inquiryTime:Long? = 0L
        var treatmentEndTime:Long? = 0L


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