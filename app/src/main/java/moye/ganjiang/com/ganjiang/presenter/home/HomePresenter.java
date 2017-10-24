package moye.ganjiang.com.ganjiang.presenter.home;

import android.content.Context;
import android.view.View;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.CommonSubscriber;
import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.fragments.HomeContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.home.LunBoBean;
import moye.ganjiang.com.ganjiang.ui.activity.home.ProductActivity;
import moye.ganjiang.com.ganjiang.utils.RxUtil;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class HomePresenter extends RxPresenter<HomeContract.View>implements HomeContract.Presenter {
   private DataManager dataManager;
    @Inject
    public HomePresenter(DataManager dataManager){
        this.dataManager=dataManager;
    }

    //轮播图数据
    @Override
    public void getData(int terminal, int itino) {
        addSubscribe(
                dataManager.fetchLunBo(terminal,itino)
                .compose(RxUtil.<LunBoBean> rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<LunBoBean>(mView) {
                    @Override
                    public void onNext(LunBoBean lunBoBean) {
                        mView.showContent(lunBoBean);
                    }
                })
        );

    }

    @Override
    public void getMoreData() {

    }
    //设置buttonBuy点击事件
    @Override
    public void setClick(Context context, View view) {
         view.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //跳转到产品界面
                 goToOtherActivity(context, ProductActivity.class);
             }
         });
    }


}
