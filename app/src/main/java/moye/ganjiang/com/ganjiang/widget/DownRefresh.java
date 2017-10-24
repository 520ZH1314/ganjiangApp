package moye.ganjiang.com.ganjiang.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeRefreshTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moye.ganjiang.com.ganjiang.R;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/9/19.
 * 自定义刷新头布局
 */

public class DownRefresh extends LinearLayout implements SwipeRefreshTrigger, SwipeTrigger {
    @BindView(R.id.head_arrow)
    ImageView headArrow;//箭头
    @BindView(R.id.ref_tv)
    TextView refTv;//文字
    @BindView(R.id.head_loading)
    ImageView headLoading;
    private Unbinder bind;

    public DownRefresh(Context context) {
        this(context, null, 0);
    }

    public DownRefresh(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DownRefresh(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    //初始化
    private void initView() {

        //这里的原理就是简单的动态布局添加
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = View.inflate(getContext(), R.layout.headrefresh, null);
        addView(view, lp);
        bind= ButterKnife.bind(this);

    }

    //正在刷新的刷新
    @Override
    public void onRefresh() {
        refTv.setText("正在刷新...");
        headLoading.setVisibility(View.VISIBLE);
        headArrow.setVisibility(View.GONE);
        headArrow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.loading));

    }

    @Override
    public void onPrepare() {

    }

    @Override
    public void onMove(int i, boolean b, boolean b1) {
        if (!b) {
            if (i >= getHeight()) {
                headLoading.setVisibility(View.GONE);
                headArrow.setVisibility(View.VISIBLE);
                headArrow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.arrow_up));
                refTv.setText(" 释放立即刷新");
            } else {
                headLoading.setVisibility(View.GONE);
                headArrow.setVisibility(View.VISIBLE);
                headArrow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.arrow_down));
                refTv.setText("下拉可以刷新");
            }
        } else {
                 refTv.setText("刷新成功");
        }



    }

    @Override
    public void onRelease() {
        headLoading.setVisibility(View.GONE);
        headArrow.setVisibility(View.VISIBLE);
        headArrow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.arrow_up));
        refTv.setText(" 释放立即刷新");
    }

    @Override
    public void onComplete() {
        refTv.setText("刷新成功");
    }

    @Override
    public void onReset() {

    }
}
