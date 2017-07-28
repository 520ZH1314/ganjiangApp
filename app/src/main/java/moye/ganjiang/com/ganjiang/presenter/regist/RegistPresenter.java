package moye.ganjiang.com.ganjiang.presenter.regist;


import android.text.TextUtils;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.CommonSubscriber;
import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.activity.RegistContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.regist.CodeResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistResponseBean;
import moye.ganjiang.com.ganjiang.utils.RxUtil;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/12.
 * //注册的交互
 */

public class RegistPresenter extends RxPresenter<RegistContract.View> implements RegistContract.Presenter {


    public DataManager mDataManager;

    @Inject
    public RegistPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    //去注册
    @Override
    public void goToRegist(String phonenumber, String password) {
        addSubscribe(
                mDataManager.fetchRegist(phonenumber, password)
                        .compose(RxUtil.<RegistResponseBean>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<RegistResponseBean>(mView) {
                            @Override
                            public void onNext(RegistResponseBean registBean) {
                                mView.showResult(registBean);
                                mView.goToLogin();
                            }
                        })

        );


    }


    @Override
    public String getUserName() {
        return mDataManager.getUserName();
    }

    @Override
    public void setUserName(String UserName) {
        mDataManager.setUserName(UserName);
    }

    @Override
    public String getMethod() {
        return mDataManager.getMethod();
    }

    @Override
    public void setMethod(String Method) {
     mDataManager.setMethod(Method);
    }

    //获取手机验证码
    @Override
    public void getPhoneCode(String number) {
        if (TextUtils.isEmpty(number)) {
            return;
        }
        addSubscribe(
                mDataManager.fetchPhoneCode(number)
                        .compose(RxUtil.<CodeResponseBean>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<CodeResponseBean>(mView) {
                            @Override
                            public void onNext(CodeResponseBean bean) {
                                mView.showContent(bean);
                            }
                        })
        );
    }



}
