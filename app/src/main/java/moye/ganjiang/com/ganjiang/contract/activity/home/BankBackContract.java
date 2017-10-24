package moye.ganjiang.com.ganjiang.contract.activity.home;

import moye.ganjiang.com.ganjiang.base.BasePresenter;
import moye.ganjiang.com.ganjiang.base.BaseView;
import moye.ganjiang.com.ganjiang.model.regist.BankBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 * 银行开户返回的 web界面的Contract
 */
public interface BankBackContract {
    interface View extends BaseView {

        void showContent(String s);

        void showMoreContent();
    }

    interface Presenter extends BasePresenter<View> {
        void getdata(BankBean bean);
        void getMoreData();
        String getSessionId();
    }
}
