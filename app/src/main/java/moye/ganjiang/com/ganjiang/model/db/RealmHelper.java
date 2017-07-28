package moye.ganjiang.com.ganjiang.model.db;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;

/**
 * Created by codeest on 16/8/16.
 */

public class RealmHelper implements DBHelper {

    private static final String DB_NAME = "myRealm.realm";

    private Realm mRealm;

    @Inject
    public RealmHelper() {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build());
    }

   //查询用户信息
    @Override
    public UserMeassageBean queryUserMessage(String ID) {
       UserMeassageBean bean = mRealm.where(UserMeassageBean.class).equalTo("id",ID).findFirst();
        return bean;
    }
  //更新用户信息
    @Override
    public void updateUserMessage(UserMeassageBean bean) {
        UserMeassageBean data = mRealm.where(UserMeassageBean.class).findFirst();
        mRealm.beginTransaction();
        if (data != null) {
            data.deleteFromRealm();
        }
        mRealm.copyToRealm(bean);
        mRealm.commitTransaction();
    }
  //增加用户信息
    @Override
    public void insertUserMessage(UserMeassageBean bean) {
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(bean);
        mRealm.commitTransaction();
    }
 // 查询所有信息
    @Override
    public List<UserMeassageBean> queryAllUsers() {
        RealmResults<UserMeassageBean> data = mRealm.where(UserMeassageBean.class).findAll();
        return data;
    }
}
