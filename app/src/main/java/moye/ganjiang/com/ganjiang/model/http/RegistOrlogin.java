package moye.ganjiang.com.ganjiang.model.http;

import io.reactivex.Flowable;
import moye.ganjiang.com.ganjiang.model.regist.RegistOrLoginResponseBean;
import moye.ganjiang.com.ganjiang.model.select.LunBoBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;



/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/10.
 * rxjava +Retrofit实现网络请求
 */

public interface RegistOrlogin {
 @FormUrlEncoded
 @POST("ui/app/getImage.action")
 Flowable<LunBoBean> goLunBoTu(@Field("terminal") int terminal, @Field("itino") int itino);
 @GET("ui/app/userbase/verifyLoginName.action?")
 Flowable<RegistOrLoginResponseBean> getRegistOrLogin(@Query("mobilephone") String mobilephone);
}
