package moye.ganjiang.com.ganjiang.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.app.Contants;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.contract.activity.login.LoginActivityContract;
import moye.ganjiang.com.ganjiang.model.login.LoginResponseBean;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import moye.ganjiang.com.ganjiang.presenter.login.LoginActivityPresenter;
import moye.ganjiang.com.ganjiang.ui.activity.regist.RegistActivity;

/**
 * author:lovezh
 * params:登录的界面
 * description:
 */
public class LoginActivity extends BaseActivity<LoginActivityPresenter> implements LoginActivityContract.View {
    @BindView(R.id.tv_login_toobar)
    TextView tvLoginToobar;//标题
    @BindView(R.id.toobar_login)
    Toolbar toobarLogin;//toobar

    @BindView(R.id.et_login_mm)
    EditText etLoginMm;//输入密码
    @BindView(R.id.tv_login_yzm)
    TextView tvLoginYzm;//找回密码
    @BindView(R.id.btn_login)
    Button btnLogin;//登录按钮
    @BindView(R.id.et_login_phone)
    EditText etLoginPhone;
    @BindView(R.id.tv_login_go_regist)
    TextView tvLoginGoRegist;//跳转注册按钮
    private String UserName;
    private String Method;
    private String PhoneNumber;
    private String Password;
    private String status;
    private String SessionId;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBar(toobarLogin, " ");


    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initEventAndData() {

        //登录的逻辑
        Intent intent = getIntent();
        Method = intent.getStringExtra(Contants.METHOD);
        if (Method == null) {
            Method = "userlogin";
        }
        //登录点击事件
        btnLogin.setOnClickListener(v -> {

            PhoneNumber = etLoginPhone.getText().toString().trim();
            Password = etLoginMm.getText().toString().trim();
            mPresenter.login(Method, PhoneNumber, Password);


        });
        //注册的点击事件
        tvLoginGoRegist. setOnClickListener(v->{

            mPresenter.goToOtherActivity(mContext, RegistActivity.class);
             finish();

        });
        //修改密码点击事件
        tvLoginYzm.setOnClickListener(v->{
            mPresenter.goToOtherActivity(mContext, UpDatePassWordActivity.class);
        });
    }

    //传递过去 islogin
    public boolean IsLogin() {
        if ("1".equals(status)) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showErrorMsg(String msg) {
        super.showErrorMsg(msg);

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
    public void showContent(LoginResponseBean loginResponseBean) {
        SessionId = loginResponseBean.getSessionId();
        mPresenter.setSessionId(SessionId);
        status = loginResponseBean.getStatus();
        if ("1".equals(status)) {
            mPresenter.setUserNumber(PhoneNumber);
             //登录成功
             //获取个人信息
            mPresenter.getUserMessages("Mthod","getUserBaseDetail",mPresenter.getSessionId());
            finish();

        } else {
            //登录失败
            return;
        }



    }

    @Override
    public void showMoreContent() {

    }


    @Override
    public void showUserMessage(UserMeassageBean bean) {




    }


    @Override
    protected void setToolBar(Toolbar toolbar, String title) {
        super.setToolBar(toolbar, title);
        toolbar.setNavigationIcon(R.mipmap.title_bar_back);
    }


}
