package moye.ganjiang.com.ganjiang.component;

import android.app.Activity;

import dagger.Component;
import moye.ganjiang.com.ganjiang.MainActivity;
import moye.ganjiang.com.ganjiang.modules.ActivityModule;
import moye.ganjiang.com.ganjiang.scope.ActivityScope;
import moye.ganjiang.com.ganjiang.ui.activity.home.BankBackActivity;
import moye.ganjiang.com.ganjiang.ui.activity.home.BankDepositsActivity;
import moye.ganjiang.com.ganjiang.ui.activity.home.ProductActivity;
import moye.ganjiang.com.ganjiang.ui.activity.login.LoginActivity;
import moye.ganjiang.com.ganjiang.ui.activity.login.UpDatePassWordActivity;
import moye.ganjiang.com.ganjiang.ui.activity.mine.CertificationActivity;
import moye.ganjiang.com.ganjiang.ui.activity.mine.MyActivity;
import moye.ganjiang.com.ganjiang.ui.activity.regist.RegistActivity;
import moye.ganjiang.com.ganjiang.ui.activity.regist.RegistOrLoginActivity;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();
    void inject(MyActivity myActivity);
    void inject(RegistActivity myActivity);
    void inject(RegistOrLoginActivity myActivity);
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(CertificationActivity certificationActivity);
    void inject(ProductActivity productActivity);
    void inject(UpDatePassWordActivity upDatePassWordActivity);
    void inject(BankDepositsActivity bankDepositsActivity);
    void inject(BankBackActivity bankBackActivity);


}
