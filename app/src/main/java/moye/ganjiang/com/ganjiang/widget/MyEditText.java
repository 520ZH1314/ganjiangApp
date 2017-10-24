package moye.ganjiang.com.ganjiang.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/9/26.
 */

public class MyEditText extends android.support.v7.widget.AppCompatEditText {
  //拿到画笔
    private Paint mPaint;

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();// 初始化一些属性
    }

    private void initView() {
        mPaint=new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        //可以自定义画笔的颜色，我这里设置成黑色
        mPaint.setColor(Color.BLACK);
    }
    //重写 OnDraw 方法

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**canvas画直线，从左下角到右下角，this.getHeight()-2是获得父edittext的高度，但是必须要-2这样才能保证
         * 画的横线在edittext上面，那样才看得见，如果不-2，你可以试一试看一下是否能看得见。
         */
        canvas.drawLine(0, this.getHeight()-2, this.getWidth()-2, this.getHeight()-2, mPaint);
    }
}
