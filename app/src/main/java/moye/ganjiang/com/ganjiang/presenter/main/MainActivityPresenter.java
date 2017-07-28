package moye.ganjiang.com.ganjiang.presenter.main;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.activity.MainActivityContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class MainActivityPresenter extends RxPresenter<MainActivityContract.View>implements MainActivityContract.Presenter {
   private DataManager dataManager;

    @Inject
    public MainActivityPresenter(DataManager dataManager){
        this.dataManager=dataManager;
    }



    @Override
    public void getData() {



    }

    @Override
    public void getMoreData() {

    }
}
