package com.wd.doctor.bean

import java.io.Serializable

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 19:15
 * @Description: 用途：完成特定功能
 */
class DepartmentBean :Serializable{
    var message:String? = null
    var result:ArrayList<ResultBean>? = null

    class ResultBean:Serializable{
        var id:Int? = null
        var departmentName:String? = null
        var pic:String? = null
        var rank:Int? = null
    }
}