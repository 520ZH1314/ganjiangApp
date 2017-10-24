package moye.ganjiang.com.ganjiang.presenter.login;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.CommonSubscriber;
import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.activity.login.LoginActivityContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.login.LoginResponseBean;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import moye.ganjiang.com.ganjiang.utils.LogUtil;
import moye.ganjiang.com.ganjiang.utils.RxUtil;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class LoginActivityPresenter extends RxPresenter<LoginActivityContract.View>implements LoginActivityContract.Presenter {
   private DataManager mDataManager;
    public UserMeassageBean bean;

    @Inject
    public LoginActivityPresenter(DataManager dataManager){
        this.mDataManager=dataManager;
    }

//登录
 @Override
 public void login(String Method, String username, String Password) {
     addSubscribe(mDataManager.fetchLogin(Method,username,Password)
                   .compose(RxUtil.<LoginResponseBean> rxSchedulerHelper())
                   .subscribeWith(new CommonSubscriber<LoginResponseBean>(mView) {
                   @Override
                  public void onNext(LoginResponseBean loginResponseBean) {
                       mView.showContent(loginResponseBean);
                       mView.showErrorMsg(loginResponseBean.getMsg());
                       //保存 status
                     mDataManager.setLoginStatus(loginResponseBean.getStatus());
                   }
                       @Override
                       public void onError(Throwable e) {
                           super.onError(e);
                           LogUtil.d(e.getMessage());
                           mView.showErrorMsg(e.getMessage());
                       }
                   })
     );
 }

    @Override
    public void setUserNumber(String num) {
        mDataManager.setUserNumber(num);
    }

    //获取个人信息
    public void getUserMessages() {
      addSubscribe(
              mDataManager.fetchGetUserMessage("Mthod","getUserBaseDetail",mDataManager.getSessionId())
              .compose(RxUtil.<UserMeassageBean>rxSchedulerHelper())
              .subscribeWith(new CommonSubscriber<UserMeassageBean>(mView) {
                  @Override
                  public void onNext(UserMeassageBean userMeassageBean) {
                      //保存状态状态
                      String status = userMeassageBean.getStatus();
                      mDataManager.setLoginStatus(status);
                      mView.showUserMessage(userMeassageBean);
//                      //存入数据库
//                      mDataManager.insertUserMessage(userMeassageBean);

                  }


              })

      );
    }

    @Override
    public void getMoreData() {

    }

    @Override
    public String getSessionId() {
        return mDataManager.getSessionId();
    }

    @Override
    public void setSessionId(String SessionId) {
           mDataManager.setSessionId(SessionId);
    }


}
