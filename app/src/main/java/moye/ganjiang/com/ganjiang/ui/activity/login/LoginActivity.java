package moye.ganjiang.com.ganjiang.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.app.Contants;
import moye.ganjiang.com.ganjiang.base.App;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.contract.activity.LoginActivityContract;
import moye.ganjiang.com.ganjiang.model.login.LoginResponseBean;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import moye.ganjiang.com.ganjiang.presenter.login.LoginActivityPresenter;
import moye.ganjiang.com.ganjiang.utils.ToastUtil;

public class LoginActivity extends BaseActivity<LoginActivityPresenter> implements LoginActivityContract.View {
    @BindView(R.id.tv_login_toobar)
    TextView tvLoginToobar;//标题
    @BindView(R.id.toobar_login)
    Toolbar toobarLogin;//toobar
    @BindView(R.id.tv_login_number)
    TextView tvLoginNumber;//显示的手机号码
    @BindView(R.id.et_login_mm)
    EditText etLoginMm;//输入密码
    @BindView(R.id.tv_login_yzm)
    TextView tvLoginYzm;//找回密码
    @BindView(R.id.btn_login)
    Button btnLogin;//登录按钮
    private String UserName;
    private String Method;
    private String PhoneNumber;
    private String Password;
    private int status;
    private String SessionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }
    @Override
    protected void initEventAndData() {
         Intent intent = getIntent();
         PhoneNumber = intent.getStringExtra(Contants.PHONENUMBER);
         UserName = intent.getStringExtra(Contants.USERNAME);

         if (UserName==null){
             UserName="gjjr"+PhoneNumber;
         }
         Method = intent.getStringExtra(Contants.METHOD);
        if(Method==null){
            Method="userlogin";
        }
            btnLogin.setOnClickListener(v -> {
                Password = etLoginMm.getText().toString().trim();
                mPresenter.login(Method, UserName, Password);
                if(status!=0){
                   return;
                }else{
                    finish();
                }


            });
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
        ToastUtil.shortShow(msg);
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

        SessionId=loginResponseBean.getSessionId();
        mPresenter.setSessionId(SessionId);
        status=loginResponseBean.getStatus();
           getData();

        }

    @Override
    public void showMoreContent() {

    }

    @Override
    public void showUserMessage(UserMeassageBean bean) {
         //
        App.getAppComponent().getDataManager().insertUserMessage(bean);
    }
    //获取用户信息
    public  void getData(){
         mPresenter.getUserMessages();

    }
}
