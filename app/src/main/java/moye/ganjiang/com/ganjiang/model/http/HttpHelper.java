package moye.ganjiang.com.ganjiang.model.http;


import io.reactivex.Flowable;
import moye.ganjiang.com.ganjiang.model.contentdata.Markbean;
import moye.ganjiang.com.ganjiang.model.home.LunBoBean;
import moye.ganjiang.com.ganjiang.model.login.LoginResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.BankBean;
import moye.ganjiang.com.ganjiang.model.regist.CodeResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistOrLoginResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistResponseBean;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;

/**
 * @author:
 * @date: 2017/4/21
 * @description:
 */

public interface HttpHelper {
    //验证手机号码是否注册
    Flowable<RegistOrLoginResponseBean> fetchPhone(String PhoneNumber);

    //获取轮播图
    Flowable<LunBoBean> fetchLunBo(int terminal, int itino);

    //获取注册验证码.和验证手机号的验证码
    Flowable<CodeResponseBean> fetchPhoneCode(String PhoneNumber);

    //去注册
    Flowable<RegistResponseBean> fetchRegist(String PhoneNumber, String Password);

    //登录
    Flowable<LoginResponseBean> fetchLogin(String method, String username, String Password);

    //获取用户信息
    Flowable<UserMeassageBean> fetchGetUserMessage(String head, String method, String Sessionid);

    //忘记密码的验证码
    Flowable<String> fetchGetUpdatePwdYzm(String getValidationCode, String PhoneNumber);

    //银行注册
    Flowable<BankBean> fetchRegistBankNum(String openAnAccount,
                                          String SessionId,
                                          String PhoneNumber,
                                          String BankCard,
                                          String RealName,
                                          String CardNumber,
                                          String UsrFlag
    );

    //获取标的数据
    Flowable<Markbean> fetchGetMarkDatas(int tstatus, int pageNum);

    //获取更多标的数据
    Flowable<Markbean> fetchGetMoreMarkDatas(int tstatus, int pageNum);







}
