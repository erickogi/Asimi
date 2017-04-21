package com.erickogi14gmail.asimi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.erickogi14gmail.asimi.Data.DBPojo;
import com.erickogi14gmail.asimi.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 4/21/2017.
 */

public class Remainders_list_Adapter extends BaseAdapter {
    Context context;
    ArrayList<DBPojo> listData;


    public Remainders_list_Adapter(Context context, ArrayList<DBPojo> listData) {
        this.context = context;
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.textView_remainder_name = (TextView) convertView.findViewById(R.id.txt_remainder_list_title);
            viewHolder.textView_remainder_description = (TextView) convertView.findViewById(R.id.txt_remainder_list_description);
            viewHolder.textView_remainder_place = (TextView) convertView.findViewById(R.id.txt_remainder_place);
            viewHolder.textView_remainder_time = (TextView) convertView.findViewById(R.id.txt_remainder_time);
            viewHolder.txtId = (TextView) convertView.findViewById(R.id.txt_remainder_id);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        DBPojo pojo = listData.get(position);
        viewHolder.textView_remainder_name.setText(pojo.getREMAINDER_NAME());
        viewHolder.textView_remainder_description.setText(pojo.getREMAINDER_DESCRIPTION());
        viewHolder.textView_remainder_place.setText(pojo.getREMAINDER_PLACE_NAME());
        viewHolder.textView_remainder_time.setText(pojo.getREMAINDER_STATE());
        viewHolder.txtId.setText(String.valueOf(pojo.getID()));


        return convertView;


    }

    static class ViewHolder {
        TextView textView_remainder_name, textView_remainder_description, textView_remainder_place, textView_remainder_time, txtId;
    }
}

