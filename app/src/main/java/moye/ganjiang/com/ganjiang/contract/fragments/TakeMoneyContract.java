package moye.ganjiang.com.ganjiang.contract.fragments;

import moye.ganjiang.com.ganjiang.base.BasePresenter;
import moye.ganjiang.com.ganjiang.base.BaseView;
import moye.ganjiang.com.ganjiang.model.contentdata.Markbean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 */

public interface TakeMoneyContract {
    interface View extends BaseView {
        void showContent(Markbean markbean);

        void showMoreContent(Markbean listBean);
    }

    interface Presenter extends BasePresenter<View> {

        void getData(int tstatus, int pageNum);

        void getMoreData(int tstatus, int pageNum);

    }
}
