package moye.ganjiang.com.ganjiang;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.contract.activity.MainActivityContract;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import moye.ganjiang.com.ganjiang.presenter.main.MainActivityPresenter;
import moye.ganjiang.com.ganjiang.ui.fragment.MainFragment;
public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityContract.View {
    private static final String SHAREDPREFERENCES_NAME = "my_sp";
    private static final String NULL = "";
    @BindView(R.id.fl_container)
    FrameLayout fl_container;
    private SharedPreferences mSPrefs;

    private MainActivityContract.View mView;
    private String status;//状态

    //拿到 layout

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance());
        }

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
//        startService(new Intent(mContext,InitializeService.class));
//        mSPrefs = App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
//        string = mSPrefs.getString(Contants.SESSIONID, NULL);
//        if (TextUtils.isEmpty(string)){
//            Intent intent =new Intent(mContext, RegistOrLoginActivity.class);
//            startActivity(intent);
//        }
        //获取数据
        initData();

    }

    private void initData() {
        //判断 SessionId 是否失效
        mPresenter.getData();//获取用户信息



    }


    @Override
    public void onBackPressedSupport() {
        // 对于 4个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
        super.onBackPressedSupport();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();
    }
    // 用来计算返回键的点击间隔时间
    private long exitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                //弹出提示，可以有多种方式
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
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


   //查询用户信息返回的数据
    @Override
    public void showContent(UserMeassageBean bean) {
         status = bean.getStatus();
         //将状态保存
         mPresenter.setLoginStatus(status);
    }

    @Override
    public void showMoreContent() {

    }

    @Override
    protected void initInject() {
       getActivityComponent().inject(this);
    }
}
