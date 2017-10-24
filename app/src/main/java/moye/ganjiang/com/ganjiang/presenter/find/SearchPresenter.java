package moye.ganjiang.com.ganjiang.presenter.find;

import java.util.List;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.activity.mine.SearchContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class SearchPresenter extends RxPresenter<SearchContract.View> implements SearchContract.Presenter{

    private DataManager mDataManager;


    @Inject
    public SearchPresenter(DataManager mDataManager) {
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
