package moye.ganjiang.com.ganjiang.presenter.regist;


import android.text.TextUtils;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moye.ganjiang.com.ganjiang.base.CommonSubscriber;
import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.activity.regist.RegistContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.regist.CodeResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistResponseBean;
import moye.ganjiang.com.ganjiang.utils.RxUtil;
import moye.ganjiang.com.ganjiang.utils.TUtils;

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
        //判断手机号
        if(TextUtils.isEmpty(phonenumber)){
            return;
        }else if (TUtils.isMobile(phonenumber)){
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
        }else {
            mView.show("手机号码格式不正确");
        }
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

    //倒计时刷新
    public void sendCode(TextView tvRegistYzm) {
        int count_time = 60; //总时间
        Observable.interval(0,1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .take(count_time+1)//设置循环数
                .map(aLong -> count_time-aLong)//60-1
                .doOnSubscribe(disposable -> tvRegistYzm.setClickable(false))//执行过程中按键为不可点击状态
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long value) {
                        tvRegistYzm.setText("重获(" + value + ")");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                    //循环结束调用此方法
                    @Override
                    public void onComplete() {
                        tvRegistYzm.setClickable(true);
                        tvRegistYzm.setText("重新发送");
                    }
                });
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
