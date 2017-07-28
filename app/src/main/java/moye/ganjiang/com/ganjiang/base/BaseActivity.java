package moye.ganjiang.com.ganjiang.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.component.ActivityComponent;
import moye.ganjiang.com.ganjiang.component.DaggerActivityComponent;
import moye.ganjiang.com.ganjiang.modules.ActivityModule;
import moye.ganjiang.com.ganjiang.utils.SnackbarUtil;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/23.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView
{


    @Inject
    public T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }
    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    protected abstract void initInject();
    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
    }


}
