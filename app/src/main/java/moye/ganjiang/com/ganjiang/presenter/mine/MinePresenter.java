package moye.ganjiang.com.ganjiang.presenter.mine;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.fragments.MineContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/9/19.
 */

public class MinePresenter extends RxPresenter<MineContract.View> implements MineContract.Presenter {
    @Override
    public void getData() {

    }
    private DataManager mDataManager;
    @Inject
    public MinePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }



    @Override
    public void getMoreData() {

    }

    @Override
    public String getSessionid() {
        return mDataManager.getSessionId();
    }

    @Override
    public String getLoginStatus() {
        return mDataManager.getLoginStatus();
    }

    public String getUserPhone() {
        return mDataManager.getUserNumber();
    }
}
