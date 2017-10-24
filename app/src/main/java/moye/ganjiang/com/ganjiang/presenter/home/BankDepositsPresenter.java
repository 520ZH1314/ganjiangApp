package moye.ganjiang.com.ganjiang.presenter.home;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.CommonSubscriber;
import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.activity.home.BankDepositsContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.regist.BankBean;
import moye.ganjiang.com.ganjiang.utils.RxUtil;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class BankDepositsPresenter extends RxPresenter<BankDepositsContract.View> implements BankDepositsContract.Presenter{

    private DataManager mDataManager;


    @Inject
    public BankDepositsPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    //去注册
    @Override
    public  void RegistBankNum(String openAnAccount, String sessionId, String phone, String bankCard, String realName, String cardNumber) {
        addSubscribe(mDataManager.fetchRegistBankNum(openAnAccount, sessionId, phone, bankCard, realName, cardNumber)
                .compose(RxUtil.<BankBean> rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<BankBean>(mView) {
                    @Override
                    public void onNext(BankBean bankBean) {

                          //返回的数据
                        mDataManager.setReq_url(bankBean.getReq_url());
                         mDataManager.setOpenBankStatus(bankBean.getStatus());
                         mView.showContent(bankBean);
                         mView.showErrorMsg(bankBean.getMsg());

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                })


        );
    }


    @Override
    public void getMoreData() {

    }

    @Override
    public String getSessionId() {
        return mDataManager.getSessionId();
    }


    @Override
    public void detachView() {
        super.detachView();
    }
}
