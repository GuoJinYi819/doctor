package com.wd.doctor.net

import com.wd.doctor.bean.*
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*
import java.io.File
import java.io.Serializable

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 15:01
 * @Description: 用途：完成特定功能
 */
interface ApiService {

    //查询科室列表
    @GET
    fun findDepartment(@Url path:String):Observable<DepartmentBean>

    //查询职位列表
    @GET
    fun findJobTitle(@Url path:String):Observable<JobTitleListBean>

    //发送验证码
    @POST
    @FormUrlEncoded
    fun sendEmailCode(@Url path:String,@Field("email") email:String):Observable<MessageBean>

    //申请入驻
    @POST
    @FormUrlEncoded
    fun applyJoin(@Url path:String,@Body bean:String):Observable<MessageBean>

    //登入
    @POST
    @FormUrlEncoded
    fun login(@Url path:String,@FieldMap params:Map<String,String>):Observable<LoginBean>

    //校验验证码
    @POST
    @FormUrlEncoded
    fun checkCode(@Url path:String, @Field("email") email:String, @Field("code")code:String):Observable<MessageBean>

    //重置密码
    @PUT
    fun resetUserPwd(@Url path:String,@FieldMap params:Map<String,String>):Observable<MessageBean>

    //上传图片
    @POST
    @Multipart
    fun uploadImagePic(@Url path:String,@Part imagePic:MultipartBody.Part):Observable<MessageBean>

    //查询医生信息
    @GET
    fun findDoctorById(@Url path:String):Observable<LoginBean>

    //病友圈列表展示
    @GET
    fun findSickCircleList(@Url path: String,@QueryMap params: Map<String, String>):Observable<SickCircleListBean>

    //病友圈单列表详情
    @GET
    fun findSickCircleInfo(@Url path:String,@Query("sickCircleId")sickCircleId:Int):Observable<PublicBean>
}