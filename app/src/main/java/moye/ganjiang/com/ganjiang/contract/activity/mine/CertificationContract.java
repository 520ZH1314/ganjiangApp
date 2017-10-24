package moye.ganjiang.com.ganjiang.contract.activity.mine;

import moye.ganjiang.com.ganjiang.base.BasePresenter;
import moye.ganjiang.com.ganjiang.base.BaseView;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 * 我的
 */

public interface CertificationContract {
    interface View extends BaseView {

        void showContent();

        void showMoreContent();
    }

    interface Presenter extends BasePresenter<View> {

        void getData();
        void getMoreData();

    }
}
