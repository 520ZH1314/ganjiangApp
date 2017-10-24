package moye.ganjiang.com.ganjiang.modules;


import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import moye.ganjiang.com.ganjiang.BuildConfig;
import moye.ganjiang.com.ganjiang.app.Contants;
import moye.ganjiang.com.ganjiang.model.http.Bankback;
import moye.ganjiang.com.ganjiang.model.http.ContentData;
import moye.ganjiang.com.ganjiang.model.http.OpenBankNum;
import moye.ganjiang.com.ganjiang.model.http.Regist;
import moye.ganjiang.com.ganjiang.model.http.RegistOrlogin;
import moye.ganjiang.com.ganjiang.qualifier.BankbackUrl;
import moye.ganjiang.com.ganjiang.qualifier.ContentDataUrl;
import moye.ganjiang.com.ganjiang.qualifier.OpenBankUrl;
import moye.ganjiang.com.ganjiang.qualifier.RegistOrLoginUrl;
import moye.ganjiang.com.ganjiang.qualifier.RegistUrl;
import moye.ganjiang.com.ganjiang.utils.SystemUtil;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by codeest on 2017/2/26.
 */

@Module
public class HttpModule {

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }


    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    @RegistUrl
    Retrofit provideRegistRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, Contants.REGISTBathUrl);
    }
  @Singleton
  @Provides
  @RegistOrLoginUrl
  Retrofit provideRegistOrLoginRetrofit(Retrofit.Builder builder, OkHttpClient client) {
      return createRetrofit(builder, client, Contants.REGISTBathUrl);

  }

  //银行返回的数据
    @Singleton
    @Provides
    @BankbackUrl
    Retrofit provideRegistBackBankRetrofit(Retrofit.Builder builder, OkHttpClient client) {

        return createRetrofit(builder, client, Contants.REQURL);

    }



 @Singleton
 @Provides
 @OpenBankUrl
 Retrofit provideOpenBankRetrofit(Retrofit.Builder builder, OkHttpClient client) {
     return createRetrofit(builder, client, Contants.REGISTBathUrl);
 }


    @Singleton
    @Provides
    @ContentDataUrl
    Retrofit provideGetMarkDataRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, Contants.MARKBathUrl);
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("RxJava", message);
                }
            });

             loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
             builder.addInterceptor(loggingInterceptor);
        }
        File cacheFile = new File("Cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!SystemUtil.isNetworkConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Log.d("retrofitRequest", String.format("Sending request %s on %s%n%s",
                        request.url(), chain.connection(), request.headers()));
                Response response = chain.proceed(request);
                if (SystemUtil.isNetworkConnected()) {
                    int maxAge = 0;
                    // 有网络时, 不缓存, 最大保存时长为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                ResponseBody body = response.peekBody(1024*1024);
                String ss = body.string();
                Log.d("Response", ss);
                return response;
            }
        };
//
        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }
    //验证手机是否注册
   @Singleton
   @Provides
    RegistOrlogin provideRegistOrloginService(@RegistOrLoginUrl Retrofit retrofit){
       return retrofit.create(RegistOrlogin.class);
   }


    //注册 和登录模块
    @Singleton
    @Provides
    Regist provideRegistService(@RegistUrl Retrofit retrofit) {
        return retrofit.create(Regist.class);
    }

   //银行注册
    @Singleton
    @Provides
    OpenBankNum provideRegistBankService(@OpenBankUrl Retrofit retrofit){
        return  retrofit.create(OpenBankNum.class);
    }

    //

    //标数据
    @Singleton
    @Provides
    ContentData provideGetMarkDataService(@ContentDataUrl Retrofit retrofit){
        return  retrofit.create(ContentData.class);
    }
    //请求银行的数据
    @Singleton
    @Provides
    Bankback provideGetBackbankService(@BankbackUrl Retrofit retrofit){
        return  retrofit.create(Bankback.class);
    }


//    @Singleton
//    @Provides
//    GankApis provideGankService(@GankUrl  Retrofit retrofit) {
//        return retrofit.create(GankApis.class);
//    }
//
//    @Singleton
//    @Provides
//    WeChatApis provideWechatService(@WechatUrl Retrofit retrofit) {
//        return retrofit.create(WeChatApis.class);
//    }
//
//    @Singleton
//    @Provides
//    GoldApis provideGoldService(@GoldUrl Retrofit retrofit) {
//        return retrofit.create(GoldApis.class);
//    }
//
//    @Singleton
//    @Provides
//    VtexApis provideVtexService(@VtexUrl Retrofit retrofit) {
//        return retrofit.create(VtexApis.class);
//    }
//
//    @Singleton
//    @Provides
//    MyApis provideMyService(@MyUrl Retrofit retrofit) {
//        return retrofit.create(MyApis.class);
//    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
