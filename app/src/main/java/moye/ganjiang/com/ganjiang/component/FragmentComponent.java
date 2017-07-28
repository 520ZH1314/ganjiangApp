package moye.ganjiang.com.ganjiang.component;

import android.app.Activity;

import dagger.Component;
import moye.ganjiang.com.ganjiang.modules.FragmentModule;
import moye.ganjiang.com.ganjiang.scope.FragmentScope;
import moye.ganjiang.com.ganjiang.ui.fragment.MainFragment;
import moye.ganjiang.com.ganjiang.ui.fragment.mine.MineFragment;
import moye.ganjiang.com.ganjiang.ui.fragment.select.SelectFragment;
import moye.ganjiang.com.ganjiang.ui.fragment.takemoney.CreditorsRightFragment;
import moye.ganjiang.com.ganjiang.ui.fragment.takemoney.OptimizingFinancialFragment;
import moye.ganjiang.com.ganjiang.ui.fragment.takemoney.TakeMoneyFragment;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();
    void inject(TakeMoneyFragment takeMoneyFragment);
    void inject(OptimizingFinancialFragment optimizingFinancialFragment);
    void inject(CreditorsRightFragment creditorsRightFragment);
    void inject(SelectFragment selectFragment);
    void inject(MineFragment mineFragment);
    void inject(MainFragment mainFragment);

}
