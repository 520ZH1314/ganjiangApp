package moye.ganjiang.com.ganjiang.model.http.pres;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.app.Contants;
import moye.ganjiang.com.ganjiang.base.App;

/**
 * @author: lovezh
 * @date: 2017/9/21
 * @description:实现PreferencesHelper的接口
 */

public class ImplPreferencesHelper implements PreferencesHelper {


    private static final String SHAREDPREFERENCES_NAME = "my_sp";
    private static final int DEFAULT = 0;

    private final SharedPreferences mSPrefs;
    private String DEFAULT_USERNAME;
    private String DEFAULT_METHOD;


    @Inject
    public ImplPreferencesHelper() {
        mSPrefs = App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public String getUserName() {
       return mSPrefs.getString(Contants.USERNAME,DEFAULT_USERNAME);
    }

    @Override
    public void setUserName(String username) {
      mSPrefs.edit().putString(Contants.USERNAME,username).apply();
    }

    @Override
    public String getMethod() {
        return mSPrefs.getString(Contants.METHOD,DEFAULT_METHOD);
    }

    @Override
    public void setMethod(String method) {
        mSPrefs.edit().putString(Contants.METHOD,method).apply();
    }

    @Override
    public String getSessionId() {
        return mSPrefs.getString(Contants.SESSIONID,DEFAULT_USERNAME);
    }

    @Override
    public void setSessionId(String SessionId) {
    mSPrefs.edit().putString(Contants.SESSIONID,SessionId).apply();

    }

    @Override
    public void clearSessionId(String Key) {
        mSPrefs.edit().remove(Key).apply();
    }
//设置用户号码
    @Override
    public void setUserNumber(String Phone) {
       mSPrefs.edit().putString(Contants.USERNUMBER,Phone).apply();
    }
//得到用户号码
    @Override
    public String getUserNumber() {
        return mSPrefs.getString(Contants.USERNUMBER,DEFAULT_USERNAME);
    }
// 设置用户银行的开户状态
    @Override
    public void setOpenBankStatus(String status) {
        mSPrefs.edit().putString(Contants.OPENBANKSTATUS,status).apply();
    }
//获取用户银行的开通状态
    @Override
    public String getUserOpenBankStatus() {
        return mSPrefs.getString(Contants.OPENBANKSTATUS,DEFAULT_USERNAME);
    }

    //设置用户登录的状态
    @Override
    public void setLoginStatus(String status) {
         mSPrefs.edit().putString(Contants.LOGINSTATUS,status).apply();
    }
//获取用户登录的状态
    @Override
    public String getLoginStatus() {
        return mSPrefs.getString(Contants.LOGINSTATUS,DEFAULT_USERNAME);
    }

    @Override
    public void setReq_url(String req_url) {
        mSPrefs.edit().putString(Contants.REQURL,req_url).apply();
    }

    @Override
    public String getReq_url() {
        return mSPrefs.getString(Contants.REQURL,DEFAULT_USERNAME);    }


}
