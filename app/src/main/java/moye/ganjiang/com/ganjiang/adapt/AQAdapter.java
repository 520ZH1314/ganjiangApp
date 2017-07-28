package moye.ganjiang.com.ganjiang.adapt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import moye.ganjiang.com.ganjiang.R;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public  class AQAdapter extends BaseAdapter {
    private final Context mContext;
    private ArrayList<String> mNameList = new ArrayList<String>();

    private LayoutInflater mInflater;

    public AQAdapter(Context context, ArrayList<String> nameList){
        mNameList = nameList;
        mContext = context;


    }


    @Override
    public int getCount() {
        return mNameList.size();
    }

    @Override
    public Object getItem(int position) {
        return mNameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewTag viewTag;

        if (convertView == null)
        {
            convertView =convertView.inflate(mContext,R.layout.item_index_hlv,null);

            // construct an item tag
            viewTag = new ItemViewTag(
                    (TextView) convertView.findViewById(R.id.item_tv_title));
            convertView.setTag(viewTag);
        } else
        {
            viewTag = (ItemViewTag) convertView.getTag();
        }

        // set name
        viewTag.mName.setText(mNameList.get(position));
        return convertView;
    }

    class ItemViewTag
    {

        protected TextView mName;


        public ItemViewTag(TextView name)
        {
            this.mName = name;

        }
    }
}

