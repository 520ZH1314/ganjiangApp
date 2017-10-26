package moye.ganjiang.com.ganjiang.presenter.home;

import android.text.TextUtils;

import java.util.List;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.activity.home.ProductContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class ProductPresenter extends RxPresenter<ProductContract.View> implements ProductContract.Presenter{

    private DataManager mDataManager;
    public String IsOpen;

    @Inject
    public ProductPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }


    @Override
    public void getData() {

    }
//获取 SessionId
    @Override
    public String getSessionId() {
        return mDataManager.getSessionId();
    }


// 从数据库获取用户信息
@Override
public List<UserMeassageBean> getUserMessage() {

    return mDataManager.queryAllUsers();
}
//判断是否开通银行账号

    public void IsOpen() {
        for (UserMeassageBean data : mDataManager.queryAllUsers()) {
            if ("0".equals(data.isopenfsinfo)&&!TextUtils.isEmpty(data.isopenfsinfo)) {
                IsOpen= "0";
            } else {
               IsOpen="1";
            }
        }
    }
    //获取状态码
    public String getIsOpen(){

        return  IsOpen;
    }
    @Override
    public void getMoreData() {

    }

    @Override
    public void detachView() {
        super.detachView();
    }
    //判断是否登录
    @Override
    public String getLoginStatus() {
        return mDataManager.getLoginStatus();
    }
}
