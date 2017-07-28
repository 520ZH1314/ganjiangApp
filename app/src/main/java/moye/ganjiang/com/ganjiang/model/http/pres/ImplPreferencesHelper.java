package moye.ganjiang.com.ganjiang.model.http.pres;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.app.Contants;
import moye.ganjiang.com.ganjiang.base.App;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public class ImplPreferencesHelper implements PreferencesHelper {


    private static final String SHAREDPREFERENCES_NAME = "my_sp";

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


}
