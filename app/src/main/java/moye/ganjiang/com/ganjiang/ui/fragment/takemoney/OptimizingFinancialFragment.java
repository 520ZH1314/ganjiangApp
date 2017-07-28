package moye.ganjiang.com.ganjiang.ui.fragment.takemoney;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.adapt.OptimizingAdapter;
import moye.ganjiang.com.ganjiang.base.BaseFragment;
import moye.ganjiang.com.ganjiang.contract.fragments.OptimizingContract;
import moye.ganjiang.com.ganjiang.model.takemoney.OpiGroupEntity;
import moye.ganjiang.com.ganjiang.presenter.takemoney.OptimizingPresenter;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/28.
 * 优选理财列表
 */

public class OptimizingFinancialFragment extends BaseFragment<OptimizingPresenter> implements OptimizingContract.View {
    @BindView(R.id.optimiz_rec)
    RecyclerView optimizRec;
    Unbinder unbinder;

    private ArrayList<OpiGroupEntity> groups;

    public static OptimizingFinancialFragment newInstance() {
        Bundle args = new Bundle();
        OptimizingFinancialFragment fragment = new OptimizingFinancialFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {
    getFragmentComponent().inject(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.optimiz_fragment;
    }

    @Override
    protected void initEventAndData() {
//        groups = mPresenter.getGroups(1, 6);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        initEventAndData();//初始化数据
        showContent();
        return rootView;
    }


    @Override
    public void showErrorMsg(String msg) {

    }



    @Override
    public void showProgress() {

    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }



    @Override
    public void showContent() {
        optimizRec.setLayoutManager(new LinearLayoutManager(mContext));
        optimizRec.setAdapter(new OptimizingAdapter(mContext,groups));
    }

    @Override
    public void showMoreContent() {

    }
}
