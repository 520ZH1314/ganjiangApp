package moye.ganjiang.com.ganjiang.presenter.takemoney;

import java.util.ArrayList;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.fragments.OptimizingContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.takemoney.OpiGroupEntity;
import moye.ganjiang.com.ganjiang.model.takemoney.OpzimiBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class OptimizingPresenter extends RxPresenter<OptimizingContract.View> implements OptimizingContract.Presenter {
      private DataManager dataManager;
    @Inject
    public OptimizingPresenter(DataManager dataManager){
        this.dataManager=dataManager;
    }
     //String name,String precent,String mAdd, String date
    public  ArrayList<OpiGroupEntity> getGroups(int groupCount, int childrenCount) {
        ArrayList<OpiGroupEntity> groups = new ArrayList<>();
        for (int i = 0; i < groupCount; i++) {
            ArrayList<OpzimiBean> children = new ArrayList<>();
            for (int j = 0; j < childrenCount; j++) {
                children.add(new OpzimiBean("财神道"+j,"10%","+5%","47"+j));
            }
            groups.add(new OpiGroupEntity("新手专享"+i, children));
        }
        return groups;
    }



    @Override
    public void getData() {

    }

    @Override
    public void getMoreData() {

    }
}
