package moye.ganjiang.com.ganjiang.presenter.login;

import java.util.List;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.activity.MineContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class MinePresenter extends RxPresenter<MineContract.View> implements MineContract.Presenter{

    private DataManager mDataManager;


    @Inject
    public MinePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }


    @Override
    public void getData() {

    }

    @Override
    public List<UserMeassageBean> getDB() {
        return mDataManager.queryAllUsers();
    }

    @Override
    public void getMoreData() {

    }

    @Override
    public void clearSessionId(String Key) {

    }

    @Override
    public void detachView() {
        super.detachView();
    }
}
