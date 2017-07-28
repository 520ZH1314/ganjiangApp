package moye.ganjiang.com.ganjiang.model.http;

import io.reactivex.Flowable;
import moye.ganjiang.com.ganjiang.model.login.LoginResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.CodeResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistResponseBean;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/10.
 * rxjava +Retrofit实现网络请求
 * //注册和登录的请求都在这
 */

public interface Regist {
 @GET("ui/app/userbase/smssend.action?")
 Flowable<CodeResponseBean> getRegist(@Query("mobilephone") String mobilephone);

 @FormUrlEncoded
 @POST("ui/app/userbase/register.action")
 Flowable<RegistResponseBean> goToRegist(@Field("mobilephone") String mobilephone, @Field("password") String password);
 @GET("ui/app/master.action")
 Flowable<LoginResponseBean>goToLogin(@Query("Method") String userlogin,@Query("username") String username,@Query("password") String Password);
 @GET("ui/app/userMaster.action")
 Flowable<UserMeassageBean>getUserMessages(@Header("Accept-Language") String head,@Query("Method")String Method, @Query("sessionId") String SessionId);
}
