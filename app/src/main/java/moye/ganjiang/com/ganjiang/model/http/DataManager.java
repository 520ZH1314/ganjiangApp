package moye.ganjiang.com.ganjiang.model.http;

import java.util.List;

import io.reactivex.Flowable;
import moye.ganjiang.com.ganjiang.model.contentdata.Markbean;
import moye.ganjiang.com.ganjiang.model.db.DBHelper;
import moye.ganjiang.com.ganjiang.model.home.LunBoBean;
import moye.ganjiang.com.ganjiang.model.http.pres.PreferencesHelper;
import moye.ganjiang.com.ganjiang.model.login.LoginResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.BankBean;
import moye.ganjiang.com.ganjiang.model.regist.CodeResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistOrLoginResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistResponseBean;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/17.
 * //数据管理中心
 */

public class DataManager implements HttpHelper, PreferencesHelper, DBHelper {
    HttpHelper mHttpHelper;
    PreferencesHelper mPreferencesHelper;
    DBHelper mDbHelper;

    public DataManager(HttpHelper httpHelp, PreferencesHelper preferencesHelper, DBHelper dbHelper) {
        mHttpHelper = httpHelp;
        mPreferencesHelper = preferencesHelper;
        mDbHelper = dbHelper;
    }

    //判断是否注册
    @Override
    public Flowable<RegistOrLoginResponseBean> fetchPhone(String PhoneNumber) {
        return mHttpHelper.fetchPhone(PhoneNumber);
    }

    //获取轮播图
    @Override
    public Flowable<LunBoBean> fetchLunBo(int terminal, int itino) {
        return mHttpHelper.fetchLunBo(terminal, itino);
    }

    //获取手机验证码
    @Override
    public Flowable<CodeResponseBean> fetchPhoneCode(String PhoneNumber) {
        return mHttpHelper.fetchPhoneCode(PhoneNumber);
    }

    //注册
    @Override
    public Flowable<RegistResponseBean> fetchRegist(String PhoneNumber, String Password) {
        return mHttpHelper.fetchRegist(PhoneNumber, Password);
    }

    //登录
    @Override
    public Flowable<LoginResponseBean> fetchLogin(String method, String username, String Password) {
        return mHttpHelper.fetchLogin(method, username, Password);
    }

    //获取用户信息
    @Override
    public Flowable<UserMeassageBean> fetchGetUserMessage(String head, String method, String Sessionid) {
        return mHttpHelper.fetchGetUserMessage(head, method, Sessionid);
    }

    //获取用户忘记密码的验证码
    @Override
    public Flowable<String> fetchGetUpdatePwdYzm(String getValidationCode, String PhoneNumber) {
        return mHttpHelper.fetchGetUpdatePwdYzm(getValidationCode, PhoneNumber);
    }

    //银行卡注册
    @Override
    public Flowable<BankBean> fetchRegistBankNum(String openAnAccount, String SessionId, String PhoneNumber, String BankCard, String RealName, String CardNumber) {
        return mHttpHelper.fetchRegistBankNum(openAnAccount, SessionId, PhoneNumber, BankCard, RealName, CardNumber);
    }

    //获取标数据
    @Override
    public Flowable<Markbean> fetchGetMarkDatas(int tstatus, int pageNum) {
        return mHttpHelper.fetchGetMarkDatas(tstatus, pageNum);
    }
    //获取更多

    @Override
    public Flowable<Markbean> fetchGetMoreMarkDatas(int tstatus, int pageNum) {
        return mHttpHelper.fetchGetMoreMarkDatas(tstatus, pageNum);
    }

    @Override
    public Flowable<String> fetchBackBankData(String char_set, String partner_id, String version_no,
                                              String biz_type, String sign_type, String MerBillNo,
                                              String OpenType, String IdentType, String IdentNo,
                                              String UsrName, String MobileNo, String OpenBankId,
                                              String OpenAcctId, String PageReturnUrl,
                                              String BgRetUrl, String MerPriv, String mac) {
        return mHttpHelper.fetchBackBankData(
                char_set, partner_id,
                version_no,
                biz_type,
                sign_type,
                MerBillNo,
                OpenType,
                IdentType,
                IdentNo,
                UsrName,
                MobileNo,
                OpenBankId,
                OpenAcctId,
                PageReturnUrl,
                BgRetUrl,
                MerPriv,
                mac);

    }


    //银行注册

    //获取用户名
    @Override
    public String getUserName() {
        return mPreferencesHelper.getUserName();
    }

    //设置用户名
    @Override
    public void setUserName(String UserName) {
        mPreferencesHelper.setUserName(UserName);
    }

    //获取请求方式
    @Override
    public String getMethod() {
        return mPreferencesHelper.getMethod();
    }

    //设置请求方式
    @Override
    public void setMethod(String Method) {
        mPreferencesHelper.setMethod(Method);
    }

    //获得 SessionId
    @Override
    public String getSessionId() {
        return mPreferencesHelper.getSessionId();
    }

    @Override
    public void setSessionId(String SessionId) {
        mPreferencesHelper.setSessionId(SessionId);
    }

    // 清除 SessionId
    @Override
    public void clearSessionId(String Key) {
        mPreferencesHelper.clearSessionId(Key);
    }

    //保存用户号码
    @Override
    public void setUserNumber(String Phone) {
        mPreferencesHelper.setUserNumber(Phone);
    }

    //得到用户号码
    @Override
    public String getUserNumber() {
        return mPreferencesHelper.getUserNumber();
    }

    //设置用户开通银行的状态
    @Override
    public void setOpenBankStatus(String status) {
        mPreferencesHelper.setOpenBankStatus(status);
    }

    //获取用户开通银行的状态
    @Override
    public String getUserOpenBankStatus() {
        return mPreferencesHelper.getUserOpenBankStatus();
    }

    @Override
    public void setLoginStatus(String status) {
        mPreferencesHelper.setLoginStatus(status);
    }

    @Override
    public String getLoginStatus() {
        return mPreferencesHelper.getLoginStatus();
    }

    @Override
    public void setReq_url(String req_url) {
         mPreferencesHelper.setReq_url(req_url);
    }

    @Override
    public String getReq_url() {
        return mPreferencesHelper.getReq_url();
    }


    /**
     * author:lovezh
     * params:
     * description:
     * 以下三个方法数据库的增删改查
     */
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
