package moye.ganjiang.com.ganjiang.presenter.regist;

import android.text.TextUtils;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.CommonSubscriber;
import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.activity.regist.RegistOrLoginContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.regist.RegistOrLoginResponseBean;
import moye.ganjiang.com.ganjiang.utils.RxUtil;
import moye.ganjiang.com.ganjiang.utils.TUtils;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class RegistOrLoginPresenter extends RxPresenter<RegistOrLoginContract.View> implements RegistOrLoginContract.Presenter {

    private DataManager mDataManager;

    @Override
    public void attachView(RegistOrLoginContract.View view) {
        super.attachView(view);

    }

    @Inject
    public RegistOrLoginPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }


   //联网判断手机号是否注册
    @Override
    public void getData(String  PhoneNumber) {
        //判断手机号
        if(TextUtils.isEmpty(PhoneNumber)){
            return;
        }else if (TUtils.isMobile(PhoneNumber)){
            addSubscribe(mDataManager.fetchPhone(PhoneNumber)
                    .compose(RxUtil.<RegistOrLoginResponseBean>rxSchedulerHelper())
                    .subscribeWith(new CommonSubscriber<RegistOrLoginResponseBean>(mView) {
                        @Override
                        public void onNext(RegistOrLoginResponseBean bean) {
                            if(bean.getStatus()==1){
                                //手机号未注册,可以使用
                                //去注册界面
                                mView.goToRegist();
                            }else{
                                //手机号已经注册,去登入
                                mView.goToLogin();
                            }
                        }


                    })
            );
        }else {
            mView.showContent("手机号码格式不正确");
        }





    }


    @Override
    public void getMoreData() {

    }
}