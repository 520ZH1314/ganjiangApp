package moye.ganjiang.com.ganjiang.contract.activity;

import moye.ganjiang.com.ganjiang.base.BasePresenter;
import moye.ganjiang.com.ganjiang.base.BaseView;
import moye.ganjiang.com.ganjiang.model.login.LoginResponseBean;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 */

public interface LoginActivityContract {
    interface View extends BaseView {

        void showContent(LoginResponseBean loginResponseBean);

        void showMoreContent();
        void showUserMessage(UserMeassageBean bean);
    }

    interface Presenter extends BasePresenter<View> {

        void login(String Method,String username,String Password);

        void getMoreData();
        String getSessionId();
        void setSessionId(String SessionId);

    }
}
