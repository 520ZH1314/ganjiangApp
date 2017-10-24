package moye.ganjiang.com.ganjiang.contract.activity;

import moye.ganjiang.com.ganjiang.base.BasePresenter;
import moye.ganjiang.com.ganjiang.base.BaseView;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 */

public interface MainActivityContract {
    interface View extends BaseView {

        void showContent(UserMeassageBean bean);

        void showMoreContent();

    }

    interface Presenter extends BasePresenter<View> {
        void setLoginStatus(String status);
        void getData();

        void getMoreData();

    }
}
