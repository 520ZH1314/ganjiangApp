package moye.ganjiang.com.ganjiang.presenter.login;

import android.text.TextUtils;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.CommonSubscriber;
import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.activity.login.UpDatePwdContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.utils.RxUtil;
import moye.ganjiang.com.ganjiang.utils.TUtils;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/9/19.
 */

public class UpDatePassWordActivityPresenter extends RxPresenter<UpDatePwdContract.View> implements UpDatePwdContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public UpDatePassWordActivityPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }


    //联网获取忘记密码的验证码
    @Override
    public void getUpDatePwdCode(String getValidationCode, String PhoneNumber) {
        //判断手机号
        if (TextUtils.isEmpty(PhoneNumber)) {
            return;
        } else if (TUtils.isMobile(PhoneNumber)) {
            addSubscribe(mDataManager.fetchGetUpdatePwdYzm(getValidationCode, PhoneNumber)
                    .compose(RxUtil.<String>rxSchedulerHelper())
                    .subscribeWith(new CommonSubscriber<String>(mView) {
                        @Override
                        public void onNext(String s) {

                        }
                    })

            );

        }
    }
}