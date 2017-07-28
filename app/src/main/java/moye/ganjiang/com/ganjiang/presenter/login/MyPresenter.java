package moye.ganjiang.com.ganjiang.presenter.login;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.fragments.MyContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class MyPresenter extends RxPresenter<MyContract.View> implements MyContract.Presenter{

    private DataManager mDataManager;


    @Inject
    public MyPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }


    @Override
    public void getData() {

    }



    @Override
    public void getMoreData() {

    }

    @Override
    public void detachView() {
        super.detachView();
    }
}
