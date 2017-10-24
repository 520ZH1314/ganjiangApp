package moye.ganjiang.com.ganjiang.ui.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.contract.activity.mine.SearchContract;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import moye.ganjiang.com.ganjiang.presenter.find.SearchPresenter;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/8.
 */

public class MyActivity extends BaseActivity<SearchPresenter> implements SearchContract.View, View.OnClickListener {
    @BindView(R.id.personal_data_toobar_tv)
    TextView personalDataToobarTv;
    @BindView(R.id.personal_toobar)
    Toolbar personalToobar;
    @BindView(R.id.civ_account_img)
    CircleImageView civAccountImg;//头像
    @BindView(R.id.iv_account_right)
    ImageView ivAccountRight;
    @BindView(R.id.rl_account_user_img)
    RelativeLayout rlAccountUserImg;//头像列
    @BindView(R.id.usename)
    TextView usename;//用户名
    @BindView(R.id.tv_account_id_card)
    TextView tvAccountIdCard;//实名认证
    @BindView(R.id.rl_certiFication)
    RelativeLayout rlCertiFication;//实名认证列
    @BindView(R.id.user_message)
    TextView userMessage;
    @BindView(R.id.tv_account_info_phone)
    TextView tvAccountInfoPhone;//手机号码
    @BindView(R.id.tv_account_mail)
    TextView tvAccountMail;//电子邮箱
    @BindView(R.id.tv_account_bank_number)
    TextView tvAccountBankNumber;//是否开通微商
    @BindView(R.id.tv_account_id_card_number)
    TextView tvAccountIdCardNumber;//身份证号码
    @BindView(R.id.jy_password)
    TextView jyPassword;//交易密码
    @BindView(R.id.rl_account_info_password)
    RelativeLayout rlAccountInfoPassword;
    @BindView(R.id.close)
    TextView close;
    private String loginname;
    private String mobilephone;
    private String email;
    private String isopenfsinfo;
    private String accounttype;
    private String tradepass;
    private String ismobileverify;
    private String certificationnumber;
    private Unbinder bind;

    @Override
    protected int getLayout() {
        return R.layout.activity_my;
    }

    @Override
    protected void initEventAndData() {
        List<UserMeassageBean> db = mPresenter.getDB();
        for (UserMeassageBean bean : db) {
            String imagepath = bean.getImagepath();//头像
            loginname = bean.getLoginname();//用户名
            ismobileverify = bean.getIsreally();//实名验证状态
            mobilephone = bean.getMobilephone();//手机号码
            email = bean.getEmail();//电子邮箱
            isopenfsinfo = bean.getIsopenfsinfo();//是否开通微商
            accounttype = bean.getAccounttype();//个人类型
            tradepass = bean.getTradepass();//交易密码
            certificationnumber = bean.certificationnumber;//身份证


        }

    }

    @Override
    protected void setToolBar(Toolbar toolbar, String title) {
        super.setToolBar(toolbar, title);
        toolbar.setNavigationIcon(R.mipmap.title_bar_back);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        setContentView(getLayout());
        bind = ButterKnife.bind(this);
        setToolBar(personalToobar, "");
        personalDataToobarTv.setText("账号中心");

        initView();

    }

    private void initView() {

        usename.setText(loginname);
        if ("0".equals(ismobileverify)) {
            tvAccountIdCard.setText("未验证");
        } else {
            tvAccountIdCard.setText("已验证");
        }
        if ("0".equals(accounttype)) {
            userMessage.setText("企业");
        } else {
            userMessage.setText("个人");
        }
        tvAccountInfoPhone.setText(mobilephone);
        tvAccountMail.setText(email);
        if ("0".equals(isopenfsinfo)) {
            tvAccountBankNumber.setText("未开通");
        } else {
            tvAccountBankNumber.setText("已开通");
        }
        tvAccountIdCardNumber.setText(certificationnumber);
        //设置点击事件
        rlCertiFication.setOnClickListener(this);// 实名认证

    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
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

    }

    @Override
    public void showMoreContent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //实名认证列
            case R.id.rl_certiFication :
                 //跳转到实名认证
                goToSetting(CertificationActivity.class);
                break;

        }
    }
    //跳转界面
    private void goToSetting( Class<?> cls) {
        Intent Certification=new Intent(this,cls);
        startActivity(Certification);
    }
}
