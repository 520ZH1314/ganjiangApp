package moye.ganjiang.com.ganjiang.presenter.home;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.CommonSubscriber;
import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.activity.home.BankBackContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.regist.BankBean;
import moye.ganjiang.com.ganjiang.utils.RxUtil;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class BankBackPresenter extends RxPresenter<BankBackContract.View> implements BankBackContract.Presenter{

    private DataManager mDataManager;


    @Inject
    public BankBackPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }


    @Override
    public void getdata(BankBean bean) {

        String char_set=bean.getChar_set();
        String partner_id=bean.getPartner_id();
        String version_no=bean.getVersion_no();
        String biz_type=bean.getBiz_type();
        String sign_type=bean.getSign_type();
        String MerBillNo=bean.getMerBillNo();
        String OpenType=bean.getOpenType();
        String IdentType=bean.getIdentType();
        String IdentNo=bean.getIdentNo();
        String UsrName=bean.getUsrName();
        String MobileNo=bean.getMobileNo();
        String OpenBankId=bean.getOpenBankId();
        String OpenAcctId=bean.getOpenAcctId();
        String PageReturnUrl=bean.getPageReturnUrl();
        String BgRetUrl=bean.getBgRetUrl();
        String MerPriv=bean.getMerPriv();
        String mac=bean.getMac();
         addSubscribe(
                 mDataManager.fetchBackBankData(
                 char_set,
                 partner_id,
                 version_no,
                 biz_type,
                 sign_type,
                 MerBillNo,
                 OpenType,
                 IdentType,
                 IdentNo,
                 UsrName,
                 MobileNo,
                 OpenBankId,
                 OpenAcctId,
                 PageReturnUrl,
                 BgRetUrl,
                 MerPriv,
                 mac
                 )
           .compose(RxUtil.<String> rxSchedulerHelper())
            .subscribeWith(new CommonSubscriber<String>(mView) {
                @Override
                public void onNext(String s) {
                   mView.showContent(s);
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
