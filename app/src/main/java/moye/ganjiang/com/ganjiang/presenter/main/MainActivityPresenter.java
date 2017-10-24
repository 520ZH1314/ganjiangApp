package moye.ganjiang.com.ganjiang.presenter.main;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.CommonSubscriber;
import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.activity.MainActivityContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import moye.ganjiang.com.ganjiang.utils.RxUtil;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class MainActivityPresenter extends RxPresenter<MainActivityContract.View> implements MainActivityContract.Presenter {
    private DataManager dataManager;

    @Inject
    public MainActivityPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }


    @Override
    public void setLoginStatus(String status) {
        dataManager.setLoginStatus(status);
    }

    @Override
    public void getData() {
        addSubscribe(
                dataManager.fetchGetUserMessage("Mthod", "getUserBaseDetail", dataManager.getSessionId())
                        .compose(RxUtil.<UserMeassageBean>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<UserMeassageBean>(mView) {
                            @Override
                            public void onNext(UserMeassageBean userMeassageBean) {
                                mView.showContent(userMeassageBean);

                            }
                        })

        );


    }

    @Override
    public void getMoreData() {

    }
}
