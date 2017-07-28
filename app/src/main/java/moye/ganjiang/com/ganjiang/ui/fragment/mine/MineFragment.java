package moye.ganjiang.com.ganjiang.ui.fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.base.BaseFragment;
import moye.ganjiang.com.ganjiang.contract.fragments.MyContract;
import moye.ganjiang.com.ganjiang.presenter.login.MyPresenter;
import moye.ganjiang.com.ganjiang.ui.activity.mine.MyActivity;


/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/22.
 */

public class MineFragment extends BaseFragment<MyPresenter>implements MyContract.View {
    @BindView(R.id.civ_mine_tx)
    CircleImageView civMineTx;//头像
    @BindView(R.id.tv_mine_nc)
    TextView tvMineNc;
    @BindView(R.id.ll_mine_ll)
    LinearLayout llMineLl;
    @BindView(R.id.tv_mine_bfb)
    TextView tvMineBfb;
    @BindView(R.id.ck_mine_hide)
    CheckBox ckMineHide;
    @BindView(R.id.tv_mine_experience)
    TextView tvMineExperience;
    @BindView(R.id.rl_mine_rl)
    RelativeLayout rlMineRl;
    @BindView(R.id.tv_mine_kyye)
    TextView tvMineKyye;
    @BindView(R.id.tv_mine_money)
    TextView tvMineMoney;
    @BindView(R.id.tv_mine_recharge)
    TextView tvMineRecharge;
    @BindView(R.id.vw_mine_soild)
    View vwMineSoild;
    @BindView(R.id.tv_mine_withdrawals)
    TextView tvMineWithdrawals;
    @BindView(R.id.iv_mine_radio)
    ImageView ivMineRadio;
    @BindView(R.id.ll_mine_radio)
    LinearLayout llMineRadio;
    @BindView(R.id.mlv_mine_investment)
    RecyclerView mlvMineInvestment;
    Unbinder unbinder;

    /**
     * @deprecated 创建一个实例
     */
    public static MineFragment newInstance() {
        Bundle args = new Bundle();

        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //返回布局
    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragemt;
    }

    //加载数据
    @Override
    protected void initEventAndData() {
        civMineTx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity()," 点击了",Toast.LENGTH_SHORT).show();

                Intent intent =new Intent(getContext(),MyActivity.class);
                startActivity(intent);

            }
        });
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

    @Override
    protected void initInject() {

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
