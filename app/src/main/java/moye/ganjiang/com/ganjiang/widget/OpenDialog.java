package moye.ganjiang.com.ganjiang.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.app.Contants;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/9/27.
 */

public class OpenDialog extends Dialog implements View.OnClickListener {
    private OnClickImage onClickImage;
    private ImageView cg_layer_close;
    private Context context;
    private Button btn_kaitong;

    public OpenDialog(@NonNull Context context) {
        super(context, R.style.dialog_default_style);
    }
    public OpenDialog(Context context,OnClickImage onClickImage) {
        super(context,R.style.dialog_default_style);
        this.onClickImage=onClickImage;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow);
        setCanceledOnTouchOutside(false);
        initView();
    }
    private void initView() {
        cg_layer_close = (ImageView) findViewById(R.id.cg_layer_close);
        cg_layer_close.setOnClickListener(this);
        btn_kaitong = (Button) findViewById(R.id.btn_kaitong);
        btn_kaitong.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cg_layer_close:
                this.dismiss();
                break;
            case R.id.btn_kaitong:
                onClickImage.onClick(v, Contants.OPEN);
                this.dismiss();
                break;
        }
    }

}
