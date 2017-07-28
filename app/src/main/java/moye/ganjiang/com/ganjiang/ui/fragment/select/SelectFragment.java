package moye.ganjiang.com.ganjiang.ui.fragment.select;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeRefreshHeaderLayout;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.transformer.CubeOutTransformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.adapt.AQAdapter;
import moye.ganjiang.com.ganjiang.adapt.SelectAdapter;
import moye.ganjiang.com.ganjiang.base.BaseFragment;
import moye.ganjiang.com.ganjiang.contract.fragments.SelectContract;
import moye.ganjiang.com.ganjiang.model.select.GroupEntity;
import moye.ganjiang.com.ganjiang.model.select.LunBoBean;
import moye.ganjiang.com.ganjiang.presenter.select.SelectPresenter;
import moye.ganjiang.com.ganjiang.utils.GlideImageLoader;
import moye.ganjiang.com.ganjiang.widget.CustomLinearLayoutManager;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/22.
 */

public class SelectFragment extends BaseFragment<SelectPresenter> implements SelectContract.View {


    @BindView(R.id.swipe_refresh_header)
    SwipeRefreshHeaderLayout swipeRefreshHeader;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;
    @BindView(R.id.vpl_index)
    Banner mBanner;//轮播图
    @BindView(R.id.animationIV)
    ImageView mAnimationIV;//
    @BindView(R.id.ll_index_broadcast)
    LinearLayout mllIndexBroadcast;// 公告
    @BindView(R.id.select_gd)
    GridView selectGd;//热门活动
    @BindView(R.id.pb_progressbar)
    ProgressBar pbProgressbar;//财神到的进度条
    @BindView(R.id.ll_index_money_coming)
    LinearLayout llIndexMoneyComing;
    @BindView(R.id.select_money_rc)
    RecyclerView selectMoneyRc;
    @BindView(R.id.ll_text)
    LinearLayout llText;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.rl_msg)
    RelativeLayout rlMsg;
    @BindView(R.id.ob_select)
    ScrollView obSelect;
    @BindView(R.id.iv_selected_add2)
    ImageView ivSelectedAdd2;
    @BindView(R.id.tv_index_community)
    TextView tvIndexCommunity;
    @BindView(R.id.iv_selected_add)
    ImageView ivSelectedAdd;
    List images=new ArrayList<>();;
    ArrayList<String> titles=new ArrayList<>();
    Unbinder unbinder;

    private AQAdapter adapter;

    private ArrayList<String> hotActivity;
    private int screenWidth;
    private ArrayList<GroupEntity> mData;


    public static SelectFragment newInstance() {
        Bundle args = new Bundle();
        SelectFragment fragment = new SelectFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.select_fragemt;
    }


    @Override
    protected void initEventAndData() {
        String[] hots = getResources().getStringArray(R.array.hot_activitys);
        hotActivity = new ArrayList<>(Arrays.asList(hots));
        adapter = new AQAdapter(getContext(), hotActivity);
        mPresenter.getData(1,61);
//        mData=mPresenter.getData(2,3);
//        showContent();

    }


    //初始化 view
    @Override
    protected void initView() {


    }

    @Override
    protected void initInject() {
     getFragmentComponent().inject(this);
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


    private void setBanner() {
//        String[] urls = getResources().getStringArray(R.array.url4);
        //Arrays.asList(urls)
//
//        ArrayList<String> titles = new ArrayList<>(Arrays.asList(new String[]{"first title",
//                "second title", "third title",
//                "fourth title"}));
        mBanner.setBannerTitles(titles);
        mBanner.setImages(images);
        mBanner.setBannerAnimation(CubeOutTransformer.class);
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.start();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);


        return rootView;
    }


    @Override
    public void showContent(LunBoBean bean) {

        List<LunBoBean.ImgsBean> imgs = bean.getImgs();
        for (LunBoBean.ImgsBean data : imgs) {
            //得到图片资源
            getLunBoTu(data);
            //得到标题
            getTiTles(data);
        }


        //设置 RecyleView 内容
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 2 * screenWidth / 5);
        mBanner.setLayoutParams(params);

        setBanner();//设置轮播图
        //设置热门活动
        selectGd.setAdapter(adapter);
        CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(mContext);
        linearLayoutManager.setScrollEnabled(false);
        selectMoneyRc.setLayoutManager(linearLayoutManager);
        selectMoneyRc.setAdapter(new SelectAdapter(getContext(), mData));
    }

    private List getTiTles(LunBoBean.ImgsBean data) {
        images.add(data.getTitlepic());
        return images;
    }

    private List getLunBoTu(LunBoBean.ImgsBean data) {
         titles.add(data.getTitle());
         return titles;
    }

    @Override
    public void showMoreContent() {

    }
}
