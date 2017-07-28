package moye.ganjiang.com.ganjiang.model.http;

import java.util.List;

import io.reactivex.Flowable;
import moye.ganjiang.com.ganjiang.model.db.DBHelper;
import moye.ganjiang.com.ganjiang.model.http.pres.PreferencesHelper;
import moye.ganjiang.com.ganjiang.model.login.LoginResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.CodeResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistOrLoginResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistResponseBean;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import moye.ganjiang.com.ganjiang.model.select.LunBoBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/17.
 */

public class DataManager implements HttpHelper ,PreferencesHelper,DBHelper {
    HttpHelper mHttpHelper;
    PreferencesHelper mPreferencesHelper;
    DBHelper mDbHelper;
    public DataManager(HttpHelper httpHelp, PreferencesHelper preferencesHelper, DBHelper dbHelper) {
        mHttpHelper = httpHelp;
        mPreferencesHelper=preferencesHelper;
        mDbHelper=dbHelper;
    }

    @Override
    public Flowable<RegistOrLoginResponseBean> fetchPhone(String PhoneNumber) {
        return mHttpHelper.fetchPhone(PhoneNumber);
    }

    @Override
    public Flowable<LunBoBean> fetchLunBo(int terminal, int itino) {
        return mHttpHelper.fetchLunBo(terminal,itino);
    }

    @Override
    public Flowable<CodeResponseBean> fetchPhoneCode(String PhoneNumber) {
        return mHttpHelper.fetchPhoneCode(PhoneNumber);
    }

    @Override
    public Flowable<RegistResponseBean> fetchRegist(String PhoneNumber, String Password) {
        return mHttpHelper.fetchRegist(PhoneNumber,Password);
    }

    @Override
    public Flowable<LoginResponseBean> fetchLogin(String method, String username, String Password) {
        return mHttpHelper.fetchLogin(method,username,Password);
    }

    @Override
    public Flowable<UserMeassageBean> fetchGetUserMessage(String head, String method, String Sessionid) {
        return mHttpHelper.fetchGetUserMessage(head,method,Sessionid);
    }




    @Override
    public String getUserName() {
        return mPreferencesHelper.getUserName();
    }

    @Override
    public void setUserName(String UserName) {
        mPreferencesHelper.setUserName(UserName);
    }

    @Override
    public String getMethod() {
        return mPreferencesHelper.getMethod();
    }

    @Override
    public void setMethod(String Method) {
        mPreferencesHelper.setMethod(Method);
    }

    @Override
    public String getSessionId() {
        return mPreferencesHelper.getSessionId();
    }

    @Override
    public void setSessionId(String SessionId) {
        mPreferencesHelper.setSessionId(SessionId);
    }

    @Override
    public void clearSessionId(String Key) {
        mPreferencesHelper.clearSessionId(Key);
    }

    @Override
    public UserMeassageBean queryUserMessage(String ID) {
        return mDbHelper.queryUserMessage(ID);
    }

    @Override
    public void updateUserMessage(UserMeassageBean bean) {
         mDbHelper.updateUserMessage(bean);
    }

    @Override
    public void insertUserMessage(UserMeassageBean bean) {
         mDbHelper.insertUserMessage(bean);
    }

    @Override
    public List<UserMeassageBean> queryAllUsers() {
        return mDbHelper.queryAllUsers();
    }
}
