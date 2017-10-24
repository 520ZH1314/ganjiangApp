package moye.ganjiang.com.ganjiang.contract.activity.home;

import moye.ganjiang.com.ganjiang.base.BasePresenter;
import moye.ganjiang.com.ganjiang.base.BaseView;
import moye.ganjiang.com.ganjiang.model.regist.BankBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 * 银行开户界面的 Contract
 */
public interface BankDepositsContract {
    interface View extends BaseView {

        void showContent(BankBean bankBean);

        void showMoreContent();
    }

    interface Presenter extends BasePresenter<View> {
        void RegistBankNum(String openAnAccount,String sessionId,
                           String phone,
                           String bankCard ,
                           String realName,
                           String cardNumber);
        void getMoreData();
        String getSessionId();
    }
}
