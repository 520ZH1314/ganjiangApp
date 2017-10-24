package moye.ganjiang.com.ganjiang.ui.fragment.takemoney;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.adapt.TakeMoneyRecyclerViewAdapter;
import moye.ganjiang.com.ganjiang.base.BaseFragment;
import moye.ganjiang.com.ganjiang.contract.fragments.TakeMoneyContract;
import moye.ganjiang.com.ganjiang.model.contentdata.Markbean;
import moye.ganjiang.com.ganjiang.presenter.takemoney.TakeMoneyPresenter;
import moye.ganjiang.com.ganjiang.utils.ToastUtil;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/22.
 * <p>
 * 理财界面
 */

public class TakeMoneyFragment extends BaseFragment<TakeMoneyPresenter> implements TakeMoneyContract.View {

    Unbinder unbinder;
    @BindView(R.id.tv_takemoney_title)
    TextView tvTakemoneyTitle;

    @BindView(R.id.rec_take_money)
    RecyclerView recTakeMoney;
    @BindView(R.id.rl_take_money)
    RelativeLayout rlTakeMoney;
    @BindView(R.id.take_money_refresh)
    SwipeRefreshLayout takeMoneyRefresh;

    private TakeMoneyRecyclerViewAdapter mAdapter;

    private int mCurrentPage=0;
    private int mMorePageNumber = 1;

    private int mCurrentCounter=10;//每页的标数量
    private int total;//标的总数量
    private int mPageSize;
    private int mCurrentSize;//当前标数量

    private List<Markbean.ListBean> listBeen=new ArrayList<>();
    private List<Markbean.ListBean> morelistBeen=new ArrayList<>();
    private Markbean refrshdata;



    public static TakeMoneyFragment newInstance() {
        Bundle args = new Bundle();
        TakeMoneyFragment fragment = new TakeMoneyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.takemoney_fragemt;
    }

    //初始化事件和数据
    @Override
    protected void initEventAndData() {

          //设置下拉刷新
           takeMoneyRefresh.setOnRefreshListener(() -> {
            if(mCurrentPage>=mPageSize){
                 takeMoneyRefresh.setRefreshing(false);
                 ToastUtil.shortShow("没有更多数据了");
                 return;
            }
            //一下拉开始刷新
            takeMoneyRefresh.setRefreshing(true);
            mCurrentPage=mCurrentPage+1;
               mAdapter.getData().clear();
            //获取数据
               mPresenter.getData(-1, mCurrentPage);
               getData(listBeen);
             takeMoneyRefresh.setRefreshing(false);

        });

        //设置加载更多
        mAdapter.setOnLoadMoreListener(() -> {
                //去加载
                if(mMorePageNumber>mPageSize){
                    ToastUtil.shortShow("数据加载完成");
                    mAdapter.loadMoreEnd();
                    mMorePageNumber=0;

                }
                mPresenter.getMoreData(-1,mMorePageNumber);
                addData(morelistBeen);
                mMorePageNumber+=1;
                mAdapter.loadMoreComplete();
        },recTakeMoney);


        //item 点击事件




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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        AutoRefrsh();
        initAdapter();
        return rootView;
    }

    @Override
    protected void initView() {
        tvTakemoneyTitle.setText("理财");



    }


    private void AutoRefrsh() {

        takeMoneyRefresh.post(() -> {
                    takeMoneyRefresh.setRefreshing(true);
                      mPresenter.getData(-1, 0);
                      //订阅 添加数据
                      mAdapter.setNewData(listBeen);
                      takeMoneyRefresh.setRefreshing(false);
                }

        );



    }

    private void getData(List<Markbean.ListBean> listBeen) {
        mAdapter.setNewData(listBeen);

    }

    private void addData(List<Markbean.ListBean> morelistBeen) {
        mAdapter.addData(morelistBeen);
    }

    private void initAdapter() {

        mAdapter = new TakeMoneyRecyclerViewAdapter(R.layout.recyleview_take_money_item, listBeen);
        mAdapter.openLoadAnimation();
        recTakeMoney.setLayoutManager(new LinearLayoutManager(mContext));
        //
        takeMoneyRefresh.setProgressBackgroundColorSchemeResource(android.R.color.white);
        // 设置下拉进度的主题颜色
         takeMoneyRefresh.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);



         recTakeMoney.setAdapter(mAdapter);


    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

    }





    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }







//取消订阅

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void showContent(Markbean markbean) {
         mPageSize=markbean.getPageSize();
         total=markbean.getTotal();
         listBeen.addAll(markbean.getList());
         mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoreContent(Markbean listBean) {
           morelistBeen.addAll(listBean.getList());

    }
}
