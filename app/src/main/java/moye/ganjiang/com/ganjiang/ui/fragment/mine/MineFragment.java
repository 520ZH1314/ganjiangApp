package moye.ganjiang.com.ganjiang.ui.fragment.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.app.Contants;
import moye.ganjiang.com.ganjiang.base.App;
import moye.ganjiang.com.ganjiang.base.BaseFragment;
import moye.ganjiang.com.ganjiang.contract.fragments.MineContract;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import moye.ganjiang.com.ganjiang.presenter.mine.MinePresenter;
import moye.ganjiang.com.ganjiang.ui.activity.home.BankDepositsActivity;
import moye.ganjiang.com.ganjiang.ui.activity.login.LoginActivity;
import moye.ganjiang.com.ganjiang.utils.LogUtil;
import moye.ganjiang.com.ganjiang.widget.OpenDialog;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/9/19.
 */

public class MineFragment extends BaseFragment<MinePresenter> implements MineContract.View , View.OnClickListener{

    Unbinder unbinder;

    @BindView(R.id.tv_mine_phone)
    TextView tvMinePhone;//手机号码
    @BindView(R.id.iv_mine_refresh)
    ImageView ivMineRefresh;//刷新
    @BindView(R.id.tv_mine_all_money)
    TextView tvMineAllMoney;
    @BindView(R.id.hint_number)
    ImageView hintNumber;
    @BindView(R.id.tv_mine_count_money)
    TextView tvMineCountMoney;//总资产
    @BindView(R.id.lin_Total_assets)
    LinearLayout linTotalAssets;
    @BindView(R.id.lin_my_benfit)
    LinearLayout linMyBenfit;
    @BindView(R.id.lin_Amount_to_be_collected)
    LinearLayout linAmountToBeCollected;
    @BindView(R.id.tv_account_balance)
    TextView tvAccountBalance;
    @BindView(R.id.tv_mine_account)
    TextView tvMineAccount;//待收金额
    @BindView(R.id.tv_mine_tixian)
    TextView tvMineTixian;//提现
    @BindView(R.id.tv_mine_chongzhi)
    TextView tvMineChongzhi;//充值
    @BindView(R.id.tv_mine_invent_records)
    TextView tvMineInventRecords;//投资记录
    @BindView(R.id.lin_invest)
    LinearLayout linInvest;
    @BindView(R.id.tv_mine_asset_detail)
    TextView tvMineAssetDetail;//资产明细
    @BindView(R.id.lin_assets)
    LinearLayout linAssets;
    @BindView(R.id.tv_mine_voucher)
    TextView tvMineVoucher;//我的券包
    @BindView(R.id.lin_my_juanbao)
    LinearLayout linMyJuanbao;
    @BindView(R.id.tv_mine_experience_gold)
    TextView tvMineExperienceGold;//我的体验金
    @BindView(R.id._lintiyanjin)
    LinearLayout Lintiyanjin;

    private String isopenfsinfo;//银行开通的代码0未开通,1开通
    private boolean IsLogin;

    @Override
    public void showProgress() {

    }
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
    /**
     * @deprecated 创建一个实例
     */
    public static MineFragment newInstance() {
        Bundle args = new Bundle();

        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
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

    @Override
    protected int getLayoutId() {

        return  R.layout.mine_fragment;

    }
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

     /**
      *author:lovezh
      *params:
      *description: 初始化点击事件和一些数据
      */
    @Override
    protected void initEventAndData() {
        IsLogin();
        if(IsLogin){
            tvMinePhone.setText(mPresenter.getUserPhone());
            tvMineCountMoney.setText("10000");
            tvMineCountMoney.setClickable(false);
        }else{
            tvMinePhone.setText("去登录");
            tvMineCountMoney.setText("登录|注册");
            tvMineCountMoney.setClickable(true);
            tvMineCountMoney.setOnClickListener(this);
        }


        tvMineTixian.setOnClickListener(this);
        tvMineChongzhi.setOnClickListener(this);
        tvMineInventRecords.setOnClickListener(this);//投资记录
        tvMineAssetDetail.setOnClickListener(this);//资产明细
        tvMineVoucher.setOnClickListener(this);//我的券包
        tvMineExperienceGold.setOnClickListener(this);//我的体验金
        List<UserMeassageBean> userMeassageBeen = App.getAppComponent().getDataManager().queryAllUsers();
        for (UserMeassageBean bean: userMeassageBeen) {
            isopenfsinfo=bean.isopenfsinfo;
            tvMinePhone.setText(bean.mobilephonestr);

        }
    }

    @Override
    protected void initView() {
     //初始化 view
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
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




    //点击事件
    @Override
    public void onClick(View v) {
       if (!IsLogin){
           //没有登录
           switch (v.getId()){
               case R.id.tv_mine_tixian://体现
                   mPresenter.goToOtherActivity(mActivity, LoginActivity.class);
                   break;
               case R.id.tv_mine_chongzhi://充值
                   mPresenter.goToOtherActivity(mActivity, LoginActivity.class);
                   break;
               case R.id.tv_mine_invent_records://投资记录
                   mPresenter.goToOtherActivity(mActivity, LoginActivity.class);
                   break;
               case R.id.tv_mine_voucher://我的券包
                   mPresenter.goToOtherActivity(mActivity, LoginActivity.class);
                   break;
               case R.id.tv_mine_experience_gold://我的体验金
                   mPresenter.goToOtherActivity(mActivity, LoginActivity.class);
                   break;
               case R.id.tv_mine_count_money:// 总资产
                   mPresenter.goToOtherActivity(mActivity, LoginActivity.class);
               default:
                   break;
           }
       }else{
           //登录了判断是否开通银行账号
            if("0".equals(isopenfsinfo)){
                //未开通
                switch (v.getId()){
                    case R.id.tv_mine_tixian://体现
                        goToOpen();
                        break;
                    case R.id.tv_mine_chongzhi://充值
                        goToOpen();
                        break;
                    case R.id.tv_mine_invent_records://投资记录
                        goToOpen();
                        break;
                    case R.id.tv_mine_voucher://我的券包
                        goToOpen();
                        break;
                    case R.id.tv_mine_experience_gold://我的体验金
                        goToOpen();
                        break;
                    default:
                        break;
                }
            }



       }





    }

    private void goToOpen() {
        new OpenDialog(mContext, (view, posion) -> {
            if (posion== Contants.OPEN){
                mPresenter.goToOtherActivity(mContext,BankDepositsActivity.class);

            }

        }).show();
    }


}
