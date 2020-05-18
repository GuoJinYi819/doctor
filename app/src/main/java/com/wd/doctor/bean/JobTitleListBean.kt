package com.wd.doctor.bean

import java.io.Serializable

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 19:46
 * @Description: 用途：职位列表
 */
class JobTitleListBean:Serializable {
    var message:String? = null
    var result:List<ResultBean>? = null
    class ResultBean:Serializable{
        var id:Int? = null
        var jobTitle:String? = null
    }
}