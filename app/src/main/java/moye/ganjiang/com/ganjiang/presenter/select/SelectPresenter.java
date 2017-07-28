package moye.ganjiang.com.ganjiang.presenter.select;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.CommonSubscriber;
import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.fragments.SelectContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.select.LunBoBean;
import moye.ganjiang.com.ganjiang.utils.RxUtil;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class SelectPresenter extends RxPresenter<SelectContract.View>implements SelectContract.Presenter {
   private DataManager dataManager;
    @Inject
    public SelectPresenter (DataManager dataManager){
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
}
