package moye.ganjiang.com.ganjiang.ui.activity.regist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.app.Contants;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.contract.activity.RegistOrLoginContract;
import moye.ganjiang.com.ganjiang.presenter.regist.RegistOrLoginPresenter;
import moye.ganjiang.com.ganjiang.ui.activity.login.LoginActivity;
import moye.ganjiang.com.ganjiang.utils.ToastUtil;

public class RegistOrLoginActivity extends BaseActivity<RegistOrLoginPresenter> implements RegistOrLoginContract.View {

    @BindView(R.id.tv_regist_toobar)
    TextView tvRegistToobar;
    @BindView(R.id.toobar_regist)
    Toolbar toobarRegist;
    @BindView(R.id.ed_registorlogin)
    EditText edRegistorlogin;
    @BindView(R.id.btn_registorlogin)
    Button btnRegistorlogin;

    private String phoneNumber;
    private Unbinder bind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         bind = ButterKnife.bind(this);

          initEventAndData();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_regist_or_login;
    }

    @Override
    protected void initEventAndData() {
         setToolBar(toobarRegist,"");
         btnRegistorlogin.setOnClickListener(v -> {
             phoneNumber=edRegistorlogin.getText().toString().trim();
             mPresenter.getData(phoneNumber);//联网检查
             finish();

        });

    }

    @Override
    protected void setToolBar(Toolbar toolbar, String title) {
        super.setToolBar(toolbar, title);
        toolbar.setNavigationIcon(R.mipmap.title_bar_back);
    }






    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
//        start(new MineFragment());
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

   //
    @Override
    public void showContent(String msg) {
        ToastUtil.shortShow(msg);
    }

    @Override
    public void showMoreContent() {

    }


    @Override
    public void goToRegist() {
          Intent regist=new Intent(this,RegistActivity.class);
          regist.putExtra(Contants.PHONENUMBER,phoneNumber);
           startActivity(regist);
    }

    @Override
    public void goToLogin() {
        Intent login =new Intent(this, LoginActivity.class);
        login.putExtra(Contants.PHONENUMBER,phoneNumber);
        startActivity(login);
    }
}
