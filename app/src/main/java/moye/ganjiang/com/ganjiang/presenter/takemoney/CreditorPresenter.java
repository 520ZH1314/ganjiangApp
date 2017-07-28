package moye.ganjiang.com.ganjiang.presenter.takemoney;

import java.util.ArrayList;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.base.RxPresenter;
import moye.ganjiang.com.ganjiang.contract.fragments.CreditorContract;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.takemoney.CreditorBean;
import moye.ganjiang.com.ganjiang.model.takemoney.CreditorEntity;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public class CreditorPresenter extends RxPresenter<CreditorContract.View>implements CreditorContract.Presenter {
       private DataManager dataManager;
    @Inject
    public CreditorPresenter (DataManager dataManager){
        this.dataManager=dataManager;
    }
     //String name,String precent,String mAdd, String date
     public  ArrayList<CreditorEntity> getGroups(int groupCount,int childrenCount) {
         ArrayList<CreditorEntity> groups = new ArrayList<>();
         for (int i = 0; i < groupCount; i++) {
             ArrayList<CreditorBean> children = new ArrayList<>();
             for (int j = 0; j < childrenCount; j++) {
                 children.add(new CreditorBean("广东省深圳市宝安区沙井大厦" + j, "10%", "104" + j, j + ""));
             }
             groups.add(new CreditorEntity("新手专享",children));
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
