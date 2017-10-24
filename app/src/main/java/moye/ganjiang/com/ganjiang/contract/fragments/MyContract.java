package moye.ganjiang.com.ganjiang.contract.fragments;

import moye.ganjiang.com.ganjiang.base.BasePresenter;
import moye.ganjiang.com.ganjiang.base.BaseView;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 */

public interface MyContract {
    interface View extends BaseView {

        void showContent();

        void showMoreContent();
    }

    interface Presenter extends BasePresenter<View> {
        String getUserPhone();
        void getData();
        String getSessionId();
        void getMoreData();
        String getLoginStatus();

    }
}
