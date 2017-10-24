package moye.ganjiang.com.ganjiang.presenter.regist;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.fragments.MainFragmentContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class MainFragmentPresenter extends RxPresenter<MainFragmentContract.View>implements MainFragmentContract.Presenter {
   private DataManager dataManager;

    @Inject
    public MainFragmentPresenter(DataManager dataManager){
        this.dataManager=dataManager;
    }


 @Override
 public void getData() {

 }
//获取登录的状态
    @Override
    public String getLoginStatus() {
        return dataManager.getLoginStatus();
    }

    @Override
    public void getMoreData() {

    }

 @Override
 public String getSessionId() {
   return dataManager.getSessionId();
 }
}
