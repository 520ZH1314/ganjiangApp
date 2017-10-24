package moye.ganjiang.com.ganjiang.contract.activity.home;

import java.util.List;

import moye.ganjiang.com.ganjiang.base.BasePresenter;
import moye.ganjiang.com.ganjiang.base.BaseView;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 * 我的
 */

public interface ProductContract {
    interface View extends BaseView {

        void showContent();

        void showMoreContent();
    }

    interface Presenter extends BasePresenter<View> {
        void getData();
        String getSessionId();
        List<UserMeassageBean> getUserMessage();
        void getMoreData();
    }
}
