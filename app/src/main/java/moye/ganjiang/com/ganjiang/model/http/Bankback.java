package moye.ganjiang.com.ganjiang.model.http;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/10/20.
 * 请求银行界面
 */

public interface Bankback {
    @FormUrlEncoded
    @POST("pmobile227/")
    Flowable<String> Backbank(     @Field("char_set") String char_set,
                                   @Field("partner_id") String partner_id,
                                   @Field("version_no") String version_no,
                                   @Field("biz_type") String biz_type,
                                   @Field("sign_type") String sign_type,
                                   @Field("MerBillNo") String MerBillNo,
                                   @Field("OpenType") String OpenType,
                                   @Field("IdentType") String IdentType,
                                   @Field("IdentNo") String IdentNo,
                                   @Field("UsrName") String UsrName,
                                   @Field("MobileNo") String MobileNo,
                                   @Field("OpenBankId") String OpenBankId,
                                   @Field("OpenAcctId") String OpenAcctId,
                                   @Field("PageReturnUrl") String PageReturnUrl,
                                   @Field("BgRetUrl") String BgRetUrl,
                                   @Field("MerPriv") String MerPriv,
                                   @Field("mac") String mac);


}
