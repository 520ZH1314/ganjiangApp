package moye.ganjiang.com.ganjiang.utils;

import javax.inject.Inject;

import io.reactivex.Flowable;
import moye.ganjiang.com.ganjiang.model.contentdata.Markbean;
import moye.ganjiang.com.ganjiang.model.home.LunBoBean;
import moye.ganjiang.com.ganjiang.model.http.ContentData;
import moye.ganjiang.com.ganjiang.model.http.HttpHelper;
import moye.ganjiang.com.ganjiang.model.http.OpenBankNum;
import moye.ganjiang.com.ganjiang.model.http.Regist;
import moye.ganjiang.com.ganjiang.model.http.RegistOrlogin;
import moye.ganjiang.com.ganjiang.model.login.LoginResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.BankBean;
import moye.ganjiang.com.ganjiang.model.regist.CodeResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistOrLoginResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistResponseBean;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 */

public class RetrofitHelper implements HttpHelper {
    private RegistOrlogin mRegistOrlogin;
    private Regist mRegist;
    private OpenBankNum mOpen;
    private ContentData mMark;

    @Inject
    public RetrofitHelper(RegistOrlogin registOrlogin, Regist regist, OpenBankNum openBankNum, ContentData Mmark) {
        this.mRegistOrlogin = registOrlogin;
        this.mRegist = regist;
        this.mOpen=openBankNum;
        this.mMark=Mmark;


    }

    //判断手机号是否注册
    @Override
    public Flowable<RegistOrLoginResponseBean> fetchPhone(String PhoneNumber) {
        return mRegistOrlogin.getRegistOrLogin(PhoneNumber);
    }



    //注册时获取短信验证码
    @Override
    public Flowable<CodeResponseBean> fetchPhoneCode(String PhoneNumber) {
        return mRegist.getRegist(PhoneNumber);
    }

    //注册
    @Override
    public Flowable<RegistResponseBean> fetchRegist(String PhoneNumber, String Password) {
        return mRegist.goToRegist(PhoneNumber, Password);
    }

    //登录
    @Override
    public Flowable<LoginResponseBean> fetchLogin(String method, String username, String Password) {
        return mRegist.goToLogin(method, username, Password);
    }



    //获取用户信息
    @Override
    public Flowable<UserMeassageBean> fetchGetUserMessage(String head,String method, String Sessionid) {
        return mRegist.getUserMessages(head,method, Sessionid);
    }
    //获取修改密码的验证码
    @Override
    public Flowable<String> fetchGetUpdatePwdYzm(String getValidationCode, String PhoneNumber) {
        return mRegist.getUpdatePwd(getValidationCode,PhoneNumber);
    }
    //银行开户
    @Override
    public Flowable<BankBean> fetchRegistBankNum(String openAnAccount, String SessionId, String PhoneNumber, String BankCard, String RealName, String CardNumber,String UsrFlag) {
        return mOpen.RegistBankNum(openAnAccount,SessionId,PhoneNumber,BankCard,RealName,CardNumber,UsrFlag);
    }

    @Override
    public Flowable<Markbean> fetchGetMarkDatas(int tstatus, int pageNum) {
        return mMark.getContentData(tstatus,pageNum);
    }

    @Override
    public Flowable<Markbean> fetchGetMoreMarkDatas(int tstatus, int pageNum) {
        return mMark.getMoreContentData(tstatus,pageNum);
    }



    //获取轮播图
   @Override
   public Flowable<LunBoBean> fetchLunBo(int terminal, int itino) {
       return mRegistOrlogin.goLunBoTu(terminal,itino);
   }

}
