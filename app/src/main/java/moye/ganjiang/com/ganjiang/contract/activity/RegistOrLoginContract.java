package moye.ganjiang.com.ganjiang.contract.activity;

import moye.ganjiang.com.ganjiang.base.BasePresenter;
import moye.ganjiang.com.ganjiang.base.BaseView;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 */

public interface RegistOrLoginContract {
    interface View extends BaseView {

        void showContent(String msg);

        void showMoreContent();

        void goToRegist();

        void goToLogin();
    }

    interface Presenter extends BasePresenter<View> {

        void getData(String data);

        void getMoreData();

    }
}
