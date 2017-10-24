package moye.ganjiang.com.ganjiang.contract.activity.login;

import moye.ganjiang.com.ganjiang.base.BasePresenter;
import moye.ganjiang.com.ganjiang.base.BaseView;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 */

public interface UpDatePwdContract {
    interface View extends BaseView {

        void showContent();


    }

    interface Presenter extends BasePresenter<View> {




        //联网获取忘记密码的验证码
        void getUpDatePwdCode(String getValidationCode, String PhoneNumber);
    }
}
