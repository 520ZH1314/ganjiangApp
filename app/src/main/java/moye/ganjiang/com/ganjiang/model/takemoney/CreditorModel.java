package moye.ganjiang.com.ganjiang.model.takemoney;

import android.widget.Toast;

import moye.ganjiang.com.ganjiang.base.BaseModel;
import moye.ganjiang.com.ganjiang.utils.UIUtils;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public  class CreditorModel implements BaseModel{



    @Override
    public void onFailed(String error) {
        Toast.makeText(UIUtils.getContext(),"网络错误",Toast.LENGTH_SHORT).show();
    }


}
