package moye.ganjiang.com.ganjiang.ui.activity.home;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.app.Contants;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.base.Rxbus;
import moye.ganjiang.com.ganjiang.contract.activity.home.BankBackContract;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import moye.ganjiang.com.ganjiang.presenter.home.BankBackPresenter;
import moye.ganjiang.com.ganjiang.utils.ToastUtil;

public class BankBackActivity extends BaseActivity<BankBackPresenter> implements BankBackContract.View {


    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected int getLayout() {
        return R.layout.activity_bank_back;
    }

    @Override
    protected void initEventAndData() {
        //初始化 webview
        initWebView();


    }

    private void initWebView() {
        webView.loadUrl(mPresenter.getReq_url());
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // 返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                if(url.contains(Contants.FAILINTERCEPT)){
                    mPresenter.goToOtherActivity(mContext,BankDepositsActivity.class);
                    finish();
                }else{
                    //查询下用户信息
                    mPresenter.getUserMessages("Mthod","getUserBaseDetail",mPresenter.getSessionId());
                    mPresenter.goToOtherActivity(mContext,ProductActivity.class);
                    finish();
                }

                return super.shouldOverrideUrlLoading(view, url);

            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    // 网页加载完成
                } else {
                    // 加载中
                }

            }
        });
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

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
    public void showContent(String s) {
        ToastUtil.shortShow(s);
    }

    @Override
    public void showMoreContent() {

    }

    @Override
    public void showData(UserMeassageBean userMeassageBean) {

        //更新下用户信息
        //更新下数据库
        mPresenter.UpdateUserMessage(userMeassageBean);
        Rxbus.getDefault().post(userMeassageBean);
    }

}
