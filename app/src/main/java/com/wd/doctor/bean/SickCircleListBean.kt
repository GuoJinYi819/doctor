package com.wd.doctor.bean

import java.io.Serializable

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/21 0021 18:25
 * @Description: 用途：完成特定功能
 */
class SickCircleListBean:Serializable {
    var status:String? = null
    var message:String? = null
    var result:ResultBean? = null
    class ResultBean:Serializable{
        var sickCircleId:Int? = 0  //病友圈id
        var title:String? = null  //标题
        var detail:String? = null  //病症描述
        var releaseTime:Long? = null  //发布时间
        var amount:Int? = 0   //悬赏额度
    }
}