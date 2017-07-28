package moye.ganjiang.com.ganjiang.modules;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import moye.ganjiang.com.ganjiang.scope.ActivityScope;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }
    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
