package moye.ganjiang.com.ganjiang.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.HashSet;
import java.util.Set;

import io.realm.Realm;
import moye.ganjiang.com.ganjiang.component.AppComponent;
import moye.ganjiang.com.ganjiang.component.DaggerAppComponent;
import moye.ganjiang.com.ganjiang.modules.AppModule;
import moye.ganjiang.com.ganjiang.modules.HttpModule;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 */

public class App extends Application
{
    private static App instance;
    public static AppComponent appComponent;
    private Set<Activity> allActivities;



    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//
//        //初始化屏幕宽高
//        getScreenSize();

               //初始化数据库
        Realm.init(getApplicationContext());

//       // 在子线程中完成其他初始化//
//        InitializeService.start(this);

    }
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public static AppComponent getAppComponent(){
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                        .appModule(new AppModule(instance))
                        .httpModule(new HttpModule())
                        .build();
        }
        return appComponent;
    }




}
