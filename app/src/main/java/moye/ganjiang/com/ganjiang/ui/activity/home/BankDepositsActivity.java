package moye.ganjiang.com.ganjiang.ui.activity.home;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.contract.activity.home.BankDepositsContract;
import moye.ganjiang.com.ganjiang.model.regist.BankBean;
import moye.ganjiang.com.ganjiang.presenter.home.BankDepositsPresenter;

public class BankDepositsActivity extends BaseActivity<BankDepositsPresenter> implements BankDepositsContract.View {

    @BindView(R.id.tv_update_pwd_toobar)
    TextView tvUpdatePwdToobar;//标题
    @BindView(R.id.toobar_open_bank)
    Toolbar toobarOpenBank;
    @BindView(R.id.ed_true_name)
    EditText edTrueName;//姓名
    @BindView(R.id.ed_name_id)
    EditText edNameId;//身份证号码
    @BindView(R.id.ed_bank_bank_number)
    EditText edBankBankNumber;//银行卡号
    @BindView(R.id.ed_bank_phone_number)
    EditText edBankPhoneNumber;//银行预留号码
    @BindView(R.id.fbtn_open_bank)
    Button fbtnOpenBank;//开通
    private String realName;
    private String cardNumber;
    private String bankCard;
    private String phone;
    private String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBar(toobarOpenBank, " ");
    }

    private void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_bank_deposits;
    }

    @Override
    protected void initEventAndData() {
        fbtnOpenBank.setOnClickListener(v->{
            //去注册
            realName =edTrueName.getText().toString().trim();//姓名
            cardNumber =edNameId.getText().toString().trim();//身份证号码
            bankCard=edBankBankNumber.getText().toString().trim();//银行卡号
            phone=edBankPhoneNumber.getText().toString().trim();//银行预留号码
            mPresenter.RegistBankNum("openAnAccount",mPresenter.getSessionId(),
                    phone,
                    bankCard,
                    realName, cardNumber,"1");


        });


    }



    @Override
    public void showErrorMsg(String msg) {
        super.showErrorMsg(msg);

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
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
    public void showContent(BankBean bean) {
         status = bean.getStatus();
        if("1".equals(status)){
            //开通成功
            //去银行返回的界面
             mPresenter.goToOtherActivity(mContext,BankBackActivity.class);
             finish();
        }else {
             return;
        }
    }

    @Override
    protected void setToolBar(Toolbar toolbar, String title) {
        super.setToolBar(toolbar, title);
        toolbar.setNavigationIcon(R.mipmap.title_bar_back);
    }

    @Override
    public void showMoreContent() {

    }
}
