package moye.ganjiang.com.ganjiang.ui.fragment.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.base.BaseFragment;
import moye.ganjiang.com.ganjiang.contract.fragments.MyContract;
import moye.ganjiang.com.ganjiang.presenter.login.MyPresenter;
import moye.ganjiang.com.ganjiang.ui.activity.login.LoginActivity;
import moye.ganjiang.com.ganjiang.utils.LogUtil;


/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/22.
 * SearchFragemnt: 发现 Fragment
 */

public class SearchFragment extends BaseFragment<MyPresenter> implements MyContract.View {

    Unbinder unbinder;
    @BindView(R.id.iv_get_msg)
    ImageView ivGetMsg;
    @BindView(R.id.iv_qiandao)
    ImageView ivQiandao;
    @BindView(R.id.tv_search_phone)
    TextView tvSearchPhone;// 用户手机号码
    @BindView(R.id.tv_search_rank)
    TextView tvSearchRank;//用户积分
    @BindView(R.id.tv_search_school)
    TextView tvSearchSchool;
    @BindView(R.id.tv_rank_store)
    TextView tvRankStore;
    @BindView(R.id.iv_ad)
    ImageView ivAd;
    @BindView(R.id.re_message_center)
    RelativeLayout reMessageCenter;
    @BindView(R.id.re_risk)
    RelativeLayout reRisk;
    @BindView(R.id.re_introd_product)
    RelativeLayout reIntrodProduct;
    @BindView(R.id.re_help_center)
    RelativeLayout reHelpCenter;
    @BindView(R.id.re_about)
    RelativeLayout reAbout;
    @BindView(R.id.re_about_guanjindai)
    RelativeLayout reAboutGuanjindai;
    @BindView(R.id.re_mortgage)
    RelativeLayout reMortgage;
    @BindView(R.id.re_about_edition)
    RelativeLayout reAboutEdition;
    private String sessionld;//拿到 SessionId
    private boolean IsLogin;//是否登录

    /**
     * @deprecated 创建一个实例
     */
    public static SearchFragment newInstance() {
        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //返回布局
    @Override
    protected int getLayoutId() {
        return R.layout.search_fragemt;
    }

    //加载数据
    @Override
    protected void initEventAndData() {
        IsLogin();
        if(IsLogin){
            tvSearchPhone.setText(mPresenter.getUserPhone());
            tvSearchRank.setVisibility(View.VISIBLE);
            tvSearchPhone.setClickable(false);
        }else{
            tvSearchPhone.setText("登录/注册");
            tvSearchPhone.setClickable(true);
            tvSearchRank.setVisibility(View.GONE);
            tvSearchPhone.setOnClickListener(v->{
                mPresenter.goToOtherActivity(mContext, LoginActivity.class);
            });
        }

    }
/**
 *author:lovezh
 *params:
 *description:判断是否登录
 */
    private void IsLogin() {
        String loginStatus = mPresenter.getLoginStatus();
        if("2".equals(loginStatus)||"0".equals(loginStatus)|| TextUtils.isEmpty(loginStatus)){
            //没有登录
            IsLogin= false;
        }else{
            //登录了
            IsLogin=true;

        }

    }
  //当 fragment从不可见到可见的时候刷新以下数据

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        if(IsLogin){
            return;
        }else{
            initEventAndData();
            LogUtil.d("刷新了");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected void initView() {

    }

    //注册这个 fragment
    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
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

    }

    @Override
    public void showMoreContent() {

    }
}
