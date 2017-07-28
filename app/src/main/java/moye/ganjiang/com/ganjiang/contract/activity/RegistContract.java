package moye.ganjiang.com.ganjiang.contract.activity;

import moye.ganjiang.com.ganjiang.base.BasePresenter;
import moye.ganjiang.com.ganjiang.base.BaseView;
import moye.ganjiang.com.ganjiang.model.regist.CodeResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistResponseBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 */

public interface RegistContract {
    interface View extends BaseView {
        void showContent(CodeResponseBean bean);
        void goToLogin();
        void showMoreContent();
        void showResult(RegistResponseBean bean);
    }

    interface Presenter extends BasePresenter<View> {
        String getUserName();
        void setUserName(String UserName);
        String getMethod();
        void setMethod(String Method);
        void  getPhoneCode(String Number);//获取手机验证码

        void goToRegist(String number,String Password);//去注册

    }
}
