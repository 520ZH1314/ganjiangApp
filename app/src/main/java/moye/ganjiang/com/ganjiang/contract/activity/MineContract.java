package moye.ganjiang.com.ganjiang.contract.activity;

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

public interface MineContract {
    interface View extends BaseView {

        void showContent();

        void showMoreContent();
    }

    interface Presenter extends BasePresenter<View> {

        void getData();
        List<UserMeassageBean> getDB();
        void getMoreData();
         void clearSessionId(String key);
    }
}
