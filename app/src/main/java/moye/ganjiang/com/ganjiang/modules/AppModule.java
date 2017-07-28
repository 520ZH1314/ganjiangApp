package moye.ganjiang.com.ganjiang.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import moye.ganjiang.com.ganjiang.base.App;
import moye.ganjiang.com.ganjiang.model.db.DBHelper;
import moye.ganjiang.com.ganjiang.model.db.RealmHelper;
import moye.ganjiang.com.ganjiang.model.http.DataManager;
import moye.ganjiang.com.ganjiang.model.http.HttpHelper;
import moye.ganjiang.com.ganjiang.model.http.pres.ImplPreferencesHelper;
import moye.ganjiang.com.ganjiang.model.http.pres.PreferencesHelper;
import moye.ganjiang.com.ganjiang.utils.RetrofitHelper;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
     App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

      @Provides
    @Singleton
      DBHelper provideDBHelper(RealmHelper realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(ImplPreferencesHelper implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper ,PreferencesHelper preferencesHelper,DBHelper dbHelper) {
        return new DataManager(httpHelper ,preferencesHelper,dbHelper);
    }
}
