package moye.ganjiang.com.ganjiang.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/27.
 */

public class CustomLinearLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled = true;

    public CustomLinearLayoutManager(Context context) {
        super(context);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled && super.canScrollVertically();
    }
}
