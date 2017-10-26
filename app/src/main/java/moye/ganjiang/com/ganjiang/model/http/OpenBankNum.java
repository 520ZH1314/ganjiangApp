package moye.ganjiang.com.ganjiang.model.http;

import io.reactivex.Flowable;
import moye.ganjiang.com.ganjiang.model.regist.BankBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/10/12.
 * 开通银行账号
 * 以及充值,体现的接口
 */

public interface OpenBankNum {

    @FormUrlEncoded
    @POST("ui/app/userMaster.action")
    Flowable<BankBean> RegistBankNum(

                                     @Field("Method")String openAnAccount,
                                     @Field("sessionId") String SessionId,
                                     @Field("phone") String PhoneNumber,
                                     @Field("bankCard") String BankCard,
                                     @Field("realName") String RealName,
                                     @Field("cardNumber") String CardNumber,
                                     @Field("UsrFlag") String UsrFlag

    );




}
