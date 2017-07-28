package moye.ganjiang.com.ganjiang.component;


import javax.inject.Singleton;

import dagger.Component;
import moye.ganjiang.com.ganjiang.base.App;
import moye.ganjiang.com.ganjiang.model.db.RealmHelper;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.http.pres.ImplPreferencesHelper;
import moye.ganjiang.com.ganjiang.modules.AppModule;
import moye.ganjiang.com.ganjiang.modules.HttpModule;
import moye.ganjiang.com.ganjiang.utils.RetrofitHelper;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    RealmHelper realmHelper();    //提供数据库帮助类
//
    ImplPreferencesHelper preferencesHelper(); //提供sp帮助类
}
