package moye.ganjiang.com.ganjiang.base;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/17.
 * 基于Rx的Presenter封装,控制订阅的生命周期
 */


public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;

    protected CompositeDisposable mCompositeDisposable;

    protected void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }


    protected void addSubscribe(Disposable subscription) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    protected <U> void addRxBusSubscribe(Class<U> eventType, Consumer<U> act) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
         mCompositeDisposable.add(Rxbus.getDefault().toDefaultFlowable(eventType, act));
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }
    //跳转 Activity
    public void goToOtherActivity(Context context, Class<?> tClass){
        Intent intent =new Intent(context,tClass);

        context.startActivity(intent);
    }


    //验证码倒计时
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

}