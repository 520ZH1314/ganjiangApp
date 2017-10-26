package moye.ganjiang.com.ganjiang.presenter.home;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.CommonSubscriber;
import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.activity.home.BankBackContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
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
    public String getReq_url() {
        return mDataManager.getReq_url();
    }

    @Override
    public void getMoreData() {

    }

    //获取个人信息
    public void getUserMessages(String Mthod,String getUserBaseDetail,String SessionId) {
        addSubscribe(
                mDataManager.fetchGetUserMessage(Mthod,getUserBaseDetail,SessionId)
                        .compose(RxUtil.<UserMeassageBean>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<UserMeassageBean>(mView) {
                            @Override
                            public void onNext(UserMeassageBean userMeassageBean) {
                                //保存状态状态
                                String status = userMeassageBean.getStatus();
                                mDataManager.setLoginStatus(status);
                                mView.showData(userMeassageBean);
//                      //存入数据库
//                      mDataManager.insertUserMessage(userMeassageBean);

                            }


                        })

        );
    }
    @Override
    public void UpdateUserMessage(UserMeassageBean userMeassageBean) {
        mDataManager.updateUserMessage(userMeassageBean);
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
