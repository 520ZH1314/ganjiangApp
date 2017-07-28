package moye.ganjiang.com.ganjiang.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import moye.ganjiang.com.ganjiang.component.DaggerFragmentComponent;
import moye.ganjiang.com.ganjiang.component.FragmentComponent;
import moye.ganjiang.com.ganjiang.modules.FragmentModule;
import moye.ganjiang.com.ganjiang.utils.SnackbarUtil;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 * 基类
 */

public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView {
    @Inject
    public T mPresenter;

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }
    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }



    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        initInject();
        if(mPresenter!=null){
            mPresenter.attachView(this);
        }

        super.onViewCreated(view, savedInstanceState);

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    protected abstract void initView();

    protected abstract void initInject();

}
