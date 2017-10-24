package moye.ganjiang.com.ganjiang.presenter.takemoney;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.CommonSubscriber;
import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.fragments.TakeMoneyContract;
import moye.ganjiang.com.ganjiang.model.contentdata.Markbean;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.utils.RxUtil;


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

   //获取标数据
    @Override
    public void getData(int tstatus, int pageNum) {

        addSubscribe(dataManager.fetchGetMarkDatas(tstatus,pageNum)
                .compose(RxUtil.<Markbean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<Markbean>(mView) {

                    @Override
                    public void onNext(Markbean markBean) {

                         mView.showContent(markBean);

                    }


                })



        );


    }

    @Override
    public void getMoreData(int tstatus, int pageNum) {
        addSubscribe(dataManager.fetchGetMoreMarkDatas(tstatus,pageNum)
                .compose(RxUtil.<Markbean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<Markbean>(mView) {
                    @Override
                    public void onNext(Markbean ListBean) {

                        mView.showMoreContent(ListBean);
                    }
                })

        );

    }

    }

