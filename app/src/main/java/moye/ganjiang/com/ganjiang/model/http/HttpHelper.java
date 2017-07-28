package moye.ganjiang.com.ganjiang.model.http;


import io.reactivex.Flowable;
import moye.ganjiang.com.ganjiang.model.regist.CodeResponseBean;
import moye.ganjiang.com.ganjiang.model.login.LoginResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistOrLoginResponseBean;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import moye.ganjiang.com.ganjiang.model.select.LunBoBean;

/**
 * @author:
 * @date: 2017/4/21
 * @description:
 */

public interface HttpHelper {
    //验证手机号码是否注册
    Flowable<RegistOrLoginResponseBean> fetchPhone(String PhoneNumber);
    //获取轮播图
    Flowable<LunBoBean> fetchLunBo(int terminal,int itino);
    //获取注册验证码.和验证手机号的验证码
    Flowable<CodeResponseBean> fetchPhoneCode(String PhoneNumber);
    //去注册
    Flowable<RegistResponseBean> fetchRegist(String PhoneNumber, String Password);
    //登录
    Flowable<LoginResponseBean>fetchLogin(String method,String username,String Password);
    //获取用户信息
    Flowable<UserMeassageBean>fetchGetUserMessage(String head,String method,String Sessionid);
}
