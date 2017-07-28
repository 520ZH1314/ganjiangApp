package moye.ganjiang.com.ganjiang.utils;

import javax.inject.Inject;

import io.reactivex.Flowable;
import moye.ganjiang.com.ganjiang.model.http.HttpHelper;
import moye.ganjiang.com.ganjiang.model.http.Regist;
import moye.ganjiang.com.ganjiang.model.http.RegistOrlogin;
import moye.ganjiang.com.ganjiang.model.regist.CodeResponseBean;
import moye.ganjiang.com.ganjiang.model.login.LoginResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistOrLoginResponseBean;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import moye.ganjiang.com.ganjiang.model.select.LunBoBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 */

public class RetrofitHelper implements HttpHelper {
    private RegistOrlogin mRegistOrlogin;
    private Regist mRegist;


    @Inject
    public RetrofitHelper(RegistOrlogin registOrlogin, Regist regist) {
        this.mRegistOrlogin = registOrlogin;
        this.mRegist = regist;
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
   //获取轮播图
   @Override
   public Flowable<LunBoBean> fetchLunBo(int terminal, int itino) {
       return mRegistOrlogin.goLunBoTu(terminal,itino);
   }

}
