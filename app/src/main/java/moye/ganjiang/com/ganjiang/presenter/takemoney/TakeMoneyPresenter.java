package moye.ganjiang.com.ganjiang.presenter.takemoney;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.fragments.TakeMoneyContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class TakeMoneyPresenter extends RxPresenter<TakeMoneyContract.View> implements TakeMoneyContract.Presenter {

    private DataManager dataManager;
    @Inject
    public TakeMoneyPresenter (DataManager dataManager){
        this.dataManager=dataManager;
    }

    @Override
    public void getData() {

    }

    @Override
    public void getMoreData() {

    }
}
