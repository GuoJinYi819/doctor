package com.wd.doctor.net

import com.wd.doctor.bean.LoginBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 15:01
 * @Description: 用途：完成特定功能
 */
interface ApiService {

    @POST
    fun login(@Url path:String):Observable<LoginBean>
}